using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public class Gun : MonoBehaviour
{
    public GameObject bulletPrefab;
    public int maxAmmoCapacity; // max ammo gun can store at a time
    public float ammoResetTime; // regenerates one bullet per time interval
    public int currentAmmo;

    private float timer;

    private TextMeshProUGUI textBox;

    // Start is called before the first frame update
    void Start()
    {
        currentAmmo = maxAmmoCapacity;
        textBox = GameObject.Find("AmmoCountText").GetComponent<TextMeshProUGUI>();
    }

    // Update is called once per frame
    void Update()
    {
        // Handle shooting
        if (Input.GetMouseButtonDown(0))
        {
            if(currentAmmo > 0)
            {
                // shoot
                currentAmmo--;
                Instantiate(bulletPrefab, transform.position, Quaternion.identity);

                // recoil
                Vector2 worldPositionOfMouse = Camera.main.ScreenToWorldPoint(
                    new Vector2(Input.mousePosition.x, Input.mousePosition.y));
                Vector2 direction = -(worldPositionOfMouse - (Vector2)transform.position).normalized;
                transform.parent.GetComponent<Rigidbody2D>().AddForce(direction * 200);

                // screen shake
                Camera.main.GetComponent<CameraFollow>().shakeScreen(.2f);
            }
        }

        // Update UI
        textBox.text = "Ammo:\n" + currentAmmo;

        // Handle ammo regeneration
        timer += Time.deltaTime;
        if(timer > ammoResetTime)
        {
            timer = 0;
            if (currentAmmo < maxAmmoCapacity) currentAmmo++;
        }
    }
}