using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

/*
 * Attaches to player object and controls behaviour when colliding with power up objects.
 */
public class PlayerPowerupManager : MonoBehaviour
{
    private TextMeshProUGUI powerupText;

    private void Awake()
    {
        powerupText = GameObject.Find("PowerUpCollectedText").GetComponent<TextMeshProUGUI>();
        powerupText.text = "";
    }

    private void OnTriggerEnter2D(Collider2D collision)
    {
        Powerup p;
        if (collision.gameObject.TryGetComponent<Powerup>(out p))
        {
            switch (p.type)
            {
                case Powerup.PowerupType.Ammo:
                    StopCoroutine("showPowerupText");
                    StartCoroutine(showPowerupText("Max Ammo!", 3f));

                    // give max ammo
                    PlayerWeapon.WeaponTypes weapon = PlayerWeapon.weapon;
                    switch (weapon)
                    {
                        case PlayerWeapon.WeaponTypes.AlienMachineGun:
                            GetComponentInChildren<AlienMachineGun>().currentAmmo = GetComponentInChildren<AlienMachineGun>().maxAmmoCapacity;
                            GetComponentInChildren<AlienGrenadeLauncher>().canShoot = true;
                            break;
                        case PlayerWeapon.WeaponTypes.LaserBowAndArrow:
                            GetComponentInChildren<ArrowAttack>().currentAmmo = GetComponentInChildren<ArrowAttack>().maxAmmoCapacity;
                            GetComponentInChildren<LaserArrowAttack>().currentAmmo = GetComponentInChildren<LaserArrowAttack>().maxAmmoCapacity;
                            break;
                        case PlayerWeapon.WeaponTypes.SwordAndShield:
                            break;
                    }

                    break;

                case Powerup.PowerupType.Speed:
                    StopCoroutine("showPowerupText");
                    StartCoroutine(showPowerupText("Speed Boost!", 3f));

                    // give temporary speed boost
                    PlayerMovement movement = GetComponent<PlayerMovement>();
                    movement.speedBoost(1.5f, 6f);

                    break;

                case Powerup.PowerupType.Health:
                    StopCoroutine("showPowerupText");
                    StartCoroutine(showPowerupText("Max Health!", 3f));

                    // give max health
                    Player.health = Player.maxHealth;
                    

                    break;
            }

            Destroy(p.gameObject);
        }
    }

    /*
     * Displays and then fades out text;
     */
    IEnumerator showPowerupText(string s, float duration)
    {
        powerupText.text = s;
        powerupText.alpha = 1;

        for(float f = duration; f > 0; f -= Time.deltaTime)
        {
            powerupText.alpha = f / duration;
            yield return null;
        }

        powerupText.alpha = 0;
        powerupText.text = "";
    }
}
