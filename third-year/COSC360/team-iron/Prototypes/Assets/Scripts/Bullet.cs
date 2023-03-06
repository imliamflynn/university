using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/*
 * Describes a simple bullet object.
 */
public class Bullet : MonoBehaviour
{
    public float speed;
    public int damage; // base amount of damage the bullet does
    public int damageDeviation; // each bullet will do damage of (damage +/- damageDeviation)
    public float criticalHitChange; // chance a bullet will do extra damage

    private Vector2 direction;

    // Initialise
    private void Start()
    {
        direction = Camera.main.ScreenToWorldPoint(Input.mousePosition) - transform.position;
    }

    // Update is called once per frame
    void Update()
    {
        // Move toward target
        transform.position = Vector2.MoveTowards
            (this.transform.position, (Vector2)transform.position + direction, speed * Time.deltaTime);

    }

    // Handle collision
    void OnCollisionEnter2D(Collision2D collision)
    {
        int d = damage; // get base amount
        d += Random.Range(-damageDeviation, damageDeviation); // apply randomness deviation
        if (Random.value < criticalHitChange) d *= 3; // apply chance for triple damage

        switch (collision.gameObject.tag)
        {
            case "Obstruction":
                Destroy(gameObject);
                break;

            case "TestEnemy":
                collision.transform.GetComponent<StaticTestEnemy>().dealDamage(d); // send damage to enemy
                Destroy(gameObject); // destroy self
                break;

            case "Enemy":
                collision.transform.GetComponent<Enemy>().dealDamage(d); // send damage to enemy
                Destroy(gameObject); // destroy self
                break;

            case "StrongEnemy":
                collision.transform.GetComponent<StrongEnemy>().dealDamage(d); // send damage to enemy
                Destroy(gameObject); // destroy self
                break;

            case "WeakSpot":
                collision.transform.GetComponent<WeakSpot>().dealDamage(d); // send damage to enemy
                Destroy(gameObject); // destroy self
                break;

            case "RangeEnemy":
                collision.transform.GetComponent<rangeEnemy>().dealDamage(d);
                Destroy(gameObject);
                break;
                


            // Ignore all other collisions
            default:
                Physics2D.IgnoreCollision(collision.transform.GetComponent<Collider2D>(), GetComponent<Collider2D>());
                break;
        }
    }
}
