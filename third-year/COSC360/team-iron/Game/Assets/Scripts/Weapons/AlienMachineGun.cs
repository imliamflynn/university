using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

/*
 * Functionality for an automatic weapon controlled with left mouse button.
 */
public class AlienMachineGun : MonoBehaviour
{
    // Exposed fields for tuning
    public GameObject bulletPrefab;
    public int maxAmmoCapacity; // max ammo gun can store at a time
    public float fireRate; // interval between shots
    public float ammoResetTime;// regenerates one bullet per time interval

    // Internal fields
    [HideInInspector] public int currentAmmo;
    [HideInInspector] public float ammoRegenTimer;
    private float fireCooldownTimer;
    private bool canShoot = true;

    public AudioSource shotSound;
    public AudioSource laserHit;
    public static AudioSource laserHit2;

    // Start is called before the first frame update
    void Start()
    {
        laserHit2 = laserHit;

        currentAmmo = maxAmmoCapacity;
    }

    // Update is called once per frame
    void Update()
    {
        // Handle fire rate of automatic weapon
        fireCooldownTimer += Time.deltaTime;
        if(fireCooldownTimer > fireRate)
        {
            fireCooldownTimer = 0;
            canShoot = true;
        }

        // Handle shooting
        if (Input.GetMouseButton(0))
        {
            if(currentAmmo > 0 && canShoot)
            {
                // shoot
                currentAmmo--;
                canShoot = false;
                Instantiate(bulletPrefab, transform.position, Quaternion.identity);

                // recoil
                Vector2 worldPositionOfMouse = Camera.main.ScreenToWorldPoint(
                    new Vector2(Input.mousePosition.x, Input.mousePosition.y));
                Vector2 direction = -(worldPositionOfMouse - (Vector2)transform.position).normalized;
                transform.parent.GetComponent<Rigidbody2D>().AddForce(direction * 200);

                // screen shake
                Camera.main.GetComponent<CameraFollow>().shakeScreen(.2f);

                // sound
                if (shotSound != null)
                {
                    shotSound.Play();
                }
            }
        }

        // Handle ammo regeneration of primary weapon
        ammoRegenTimer += Time.deltaTime;
        if(ammoRegenTimer > ammoResetTime)
        {
            ammoRegenTimer = 0;
            if (currentAmmo < maxAmmoCapacity) currentAmmo++;
        }
    }

    // makes laser hit sound
    public static void Hit()
    {
        if (laserHit2 != null)
        {
            laserHit2.Play();
        }
    }
}