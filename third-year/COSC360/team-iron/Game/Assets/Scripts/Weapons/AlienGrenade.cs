using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/*
 * Grenade launched from weapon.
 * Explodes on contacting an enemy or obstacle, or after a certain amount of time.
 * Spawns an ExplosionEffect, which is what damages enemies.
 */
public class AlienGrenade : MonoBehaviour
{
    public float speed;
    public float drag = 6;
    public float timeToExplosion;
    public GameObject explosionEffect;

    private Rigidbody2D rb;
    private Vector2 worldPositionOfMouse, direction;
    private float timer;

    // Start is called before the first frame update
    void Start()
    {
        rb = GetComponent<Rigidbody2D>();

        // get direction of projectile
        worldPositionOfMouse = Camera.main.ScreenToWorldPoint
            (new Vector2(Input.mousePosition.x, Input.mousePosition.y));
        direction = (worldPositionOfMouse - (Vector2)transform.position).normalized;

        // add initial force
        rb.AddForce(direction * 100 * speed);
        rb.drag = drag;
    }

    // Explode after a certain amount of time
    private void Update()
    {
        timer += Time.deltaTime;
        if(timer > timeToExplosion)
        {
            explode();
        }
    }

    // Explode on collision with certain objects.
    void OnCollisionEnter2D(Collision2D collision)
    {
        switch (collision.gameObject.tag)
        {
            case "Obstruction":
                explode();
                break;

            case "TestEnemy":
                explode();
                break;

            case "Enemy":
                explode();
                break;

            case "StrongEnemy":
                explode();
                break;

            case "WeakSpot":
                explode();
                break;

            case "RangeEnemy":
                explode();
                break;

            // Ignore all other collisions e.g. player
            default:
                Physics2D.IgnoreCollision(collision.transform.GetComponent<Collider2D>(), GetComponent<Collider2D>());
                break;
        }
    }

    // Create an explosion effect, and destroy self
    private void explode()
    {
        AlienGrenadeLauncher.Boom();

        Instantiate(explosionEffect, transform.position, Quaternion.identity);
        Destroy(gameObject);
    }

}
