using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/*
 * Created by exploding AlienGrenade objects.
 * Is what deals damage to enemies.
 */
public class ExplosionEffect : MonoBehaviour
{
    public int damage = 100;

    private float timer;

    private void OnTriggerEnter2D(Collider2D collision)
    {
        switch (collision.gameObject.tag)
        {
            case "TestEnemy":
                collision.transform.GetComponent<StaticTestEnemy>().dealDamage(damage); // send damage to enemy
                break;

            case "Enemy":
                collision.transform.GetComponent<Enemy>().dealDamage(damage); // send damage to enemy
                break;

            case "StrongEnemy":
                collision.transform.GetComponent<StrongEnemy>().dealDamage(damage); // send damage to enemy
                break;

            case "WeakSpot":
                collision.transform.GetComponent<WeakSpot>().dealDamage(damage); // send damage to enemy
                break;

            case "RangeEnemy":
                collision.transform.GetComponent<rangeEnemy>().dealDamage(damage);
                break;



            // Ignore all other collisions
            default:
                Physics2D.IgnoreCollision(collision.transform.GetComponent<Collider2D>(), GetComponent<Collider2D>());
                break;
        }
    }

    private void Update()
    {
        timer += Time.deltaTime;
        if (timer > .3f) Destroy(gameObject);
    }

}
