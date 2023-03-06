using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/*
 * Holding down the mouse charges up the bow (shown as camera zoom effect)
 * Releasing mouse after bow is charged shoots an arrow.
 */
public class ArrowAttack : MonoBehaviour
{
    public GameObject arrowPrefab;
    public int maxAmmoCapacity; // max ammo gun can store at a time
    public float lengthOfMouseHoldToShoot; // mouse must be held down for this long before bow will shoot
    public float ammoResetTime;// regenerates one bullet per time interval

    // Internal fields
    [HideInInspector] public int currentAmmo;
    [HideInInspector] public float ammoRegenTimer;
    private float fireCooldownTimer;
    private float zoomTimer;
    private float initialCameraScale;
    private float zoomedInCameraScale;

    public AudioSource bowDraw;
    public AudioSource bowRelease;
    public AudioSource arrowHit;
    public static AudioSource arrowHit2;
    public Animator animator;

    private void Awake(){
        animator = GameObject.FindWithTag("Player").GetComponent<Animator> ();

    }

    // Start is called before the first frame update
    void Start()
    {
        arrowHit2 = arrowHit;

        currentAmmo = maxAmmoCapacity;
        initialCameraScale = Camera.main.orthographicSize;
        zoomedInCameraScale = initialCameraScale - 1;
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetMouseButtonDown(0))
        {
            if (bowDraw != null)
            {
                bowDraw.Play();

            }

        }

        // Charge up arrow
        if (Input.GetMouseButton(0))
        {
            animator.SetBool("draw", true);

            fireCooldownTimer += Time.deltaTime;
            if (currentAmmo > 0) zoomTimer += Time.deltaTime;
            
        }

        // Zoom in camera to show how charged up the shot is if we can shoot
        if (currentAmmo > 0)
        {

            float zoomAmount = zoomTimer / lengthOfMouseHoldToShoot;
            Camera.main.orthographicSize = Mathf.Lerp(initialCameraScale, zoomedInCameraScale, zoomAmount);
        }
        else
        {
            Camera.main.orthographicSize = initialCameraScale;
        }

        // Handle shooting
        if (Input.GetMouseButtonUp(0))
        {
            animator.SetBool("draw", false);

            if (currentAmmo > 0 && fireCooldownTimer > lengthOfMouseHoldToShoot)
            {
                if (bowRelease != null)
                {
                    bowRelease.Play();
                }

                // shoot
                currentAmmo--;
                Bullet b = Instantiate(arrowPrefab, transform.position, Quaternion.identity).GetComponent<Bullet>();
            }

            fireCooldownTimer = 0;
            zoomTimer = 0;
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
