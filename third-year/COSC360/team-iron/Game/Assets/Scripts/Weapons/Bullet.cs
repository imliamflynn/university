using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/*
 * Describes a simple bullet object.
 */
public class Bullet : MonoBehaviour
{
    public float speed;
    public static int damage; // base amount of damage the bullet does - default 10
    public int damageDeviation; // each bullet will do damage of (damage +/- damageDeviation)
    public float criticalHitChange; // chance a bullet will do extra damage
    public bool destroysOnCollisionWithEnemy;

    private Vector2 direction;

    // Initialise
    private void Start()
    {
        switch (PlayerWeapon.weapon)
        {
            case PlayerWeapon.WeaponTypes.AlienMachineGun:
                damage = 10;
                damageDeviation = 3;
                break;
            case PlayerWeapon.WeaponTypes.LaserBowAndArrow:
                damage = 90;
                damageDeviation = 20;
                break;
            default: break;
        }
        direction = Camera.main.ScreenToWorldPoint(Input.mousePosition) - transform.position;
    }

    // Update is called once per frame
    void Update()
    {
        // Move toward target
        transform.position = Vector2.MoveTowards
            (this.transform.position, (Vector2)transform.position + direction, speed * Time.deltaTime);

        // Rotate
        float angle = Mathf.Atan2(direction.y, direction.x) * Mathf.Rad2Deg;
        transform.rotation = Quaternion.AngleAxis(angle, Vector3.forward);

    }

    // Handle collision
    void OnCollisionEnter2D(Collision2D collision)
    {
        int d = damage; // get base amount
        if (Random.value < criticalHitChange) d *= 3; // apply chance for triple damage
        d += Random.Range(-damageDeviation, damageDeviation); // apply randomness deviation
        

        switch (collision.gameObject.tag)
        {
            case "Wall":
                Destroy(gameObject);
                break;

            case "Enemy":
                collision.transform.GetComponent<Enemy>().dealDamage(d); // send damage to enemy
                if (destroysOnCollisionWithEnemy) Destroy(gameObject); // destroy self
                AlienMachineGun.Hit();
                break;

            case "StrongEnemy":
                collision.transform.GetComponent<StrongEnemy>().dealDamage(d); // send damage to enemy
                if (destroysOnCollisionWithEnemy) Destroy(gameObject); // destroy self
                AlienMachineGun.Hit();
                break;

            case "RangeEnemy":
                collision.transform.GetComponent<rangeEnemy>().dealDamage(d);
                if (destroysOnCollisionWithEnemy) Destroy(gameObject); // destroy self
                AlienMachineGun.Hit();
                break;
                


            // Ignore all other collisions
            default:
                Physics2D.IgnoreCollision(collision.transform.GetComponent<Collider2D>(), GetComponent<Collider2D>());
                break;
        }
    }

    private void OnTriggerEnter2D(Collider2D other)
    {
        int d = damage; // get base amount
        if (Random.value < criticalHitChange) d *= 3; // apply chance for triple damage
        d += Random.Range(-damageDeviation, damageDeviation); // apply randomness deviation
        

        if (other.CompareTag("WeakSpot"))
        {
            other.transform.GetComponent<WeakSpot>().dealDamage(d); // send damage to enemy
            Destroy(gameObject); // destroy self
            AlienMachineGun.Hit();
        }
    }
}
