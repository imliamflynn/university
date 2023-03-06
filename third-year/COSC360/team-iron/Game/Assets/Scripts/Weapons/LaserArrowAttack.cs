using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/*
 * Shoots an arrow on RMB that can cut through multiple enemies.
 */
public class LaserArrowAttack : MonoBehaviour
{
    public GameObject laserArrowPrefab;
    public int maxAmmoCapacity; // max ammo gun can store at a time
    public float fireRate; // interval between shots
    public float ammoResetTime;// regenerates one bullet per time interval
    public float zoomedOutCameraScale;

    // Internal fields
    [HideInInspector] public int currentAmmo;
    [HideInInspector] public float ammoRegenTimer;
    private float fireCooldownTimer;
    private bool canShoot = true;

    public AudioSource shoot;
    public AudioSource arrowHit;
    public static AudioSource arrowHit2;

    // Start is called before the first frame update
    void Start()
    {
        arrowHit2 = arrowHit;

        currentAmmo = maxAmmoCapacity;
    }

    // Update is called once per frame
    void Update()
    {
        // Handle fire rate
        fireCooldownTimer += Time.deltaTime;
        if (fireCooldownTimer > fireRate)
        {
            fireCooldownTimer = 0;
            canShoot = true;
        }

        // Handle shooting
        if (Input.GetMouseButtonUp(1))
        {
            if (currentAmmo > 0 && canShoot)
            {
                if (shoot != null)
                {
                    shoot.Play();
                }

                // shoot
                currentAmmo--;
                canShoot = false;
                Instantiate(laserArrowPrefab, transform.position, Quaternion.identity);

                // recoil
                Vector2 worldPositionOfMouse = Camera.main.ScreenToWorldPoint(
                    new Vector2(Input.mousePosition.x, Input.mousePosition.y));
                Vector2 direction = -(worldPositionOfMouse - (Vector2)transform.position).normalized;
                transform.parent.GetComponent<Rigidbody2D>().AddForce(direction * 200);
            }
        }

        // Handle ammo regeneration of primary weapon
        ammoRegenTimer += Time.deltaTime;
        if (ammoRegenTimer > ammoResetTime)
        {
            ammoRegenTimer = 0;
            if (currentAmmo < maxAmmoCapacity) currentAmmo++;
        }
    }

    // makes arrow hit sound
    public static void Hit()
    {
        if (arrowHit2 != null)
        {
            arrowHit2.Play();
        }
    }
}
