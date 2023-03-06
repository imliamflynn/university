using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/*
 * Allows periodic firing of a grenade launcher with RMB.
 */
public class AlienGrenadeLauncher : MonoBehaviour
{
    // Exposed fields
    public GameObject grenadePrefab;
    public float ammoResetTime; // time before able to shoot again

    // Internal field
    [HideInInspector] public float timer;
    [HideInInspector] public bool canShoot = true;

    public AudioSource shotSound;
    public AudioSource grenadeSound;
    public static AudioSource grenadeSound2;

    private void Start()
    {
        grenadeSound2 = grenadeSound;
    }

    // Update is called once per frame
    void Update()
    {
        // Handle cooldown
        timer += Time.deltaTime;
        if(timer > ammoResetTime)
        {
            timer = 0;
            canShoot = true;
        }

        // Fire when RMB is released
        if (Input.GetMouseButtonUp(1) && canShoot)
        {
            canShoot = false;
            timer = 0;
            Instantiate(grenadePrefab, transform.position, Quaternion.identity);

            if (shotSound != null)
            {
                shotSound.Play();
            }
        }
    }

    // makes grenade explosion sound
    public static void Boom()
    {
        if (grenadeSound2 != null)
        {
            grenadeSound2.Play();
        }
    }
}
