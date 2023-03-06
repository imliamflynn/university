using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;
using UnityEngine.UI;

/*
 * Spawns in the desired weapon as selected in the inspector when the game starts. 
 * Gets the weapons ammo etc values and sends them to be displayed on the UI
 */
public class PlayerWeapon : MonoBehaviour
{
    public static WeaponTypes weapon; // The selected weapon type
    public GameObject alienMachineGunPrefab, laserBowAndArrowPrefab, swordAndShieldPrefab;

    private GameObject UIContainer;
    private TextMeshProUGUI primaryAmmoText, secondaryAmmoText, primaryName, secondaryName;
    private Slider primarySlider, secondarySlider;    
    Animator playerAnimator;


    // Different weapons
    public enum WeaponTypes
    {
        AlienMachineGun,
        LaserBowAndArrow,
        SwordAndShield
    }
    private void Awake(){
        playerAnimator = GameObject.FindWithTag("Player").GetComponent<Animator> ();

    }
    // Start is called before the first frame update
    void Start()
    {
        // cache the UI objects
        UIContainer = GameObject.Find("NewUI");
        primaryAmmoText = UIContainer.transform.Find("PrimaryWeapon").Find("AmmoCountText").GetComponent<TextMeshProUGUI>();
        secondaryAmmoText = UIContainer.transform.Find("SecondaryWeapon").Find("AmmoCountText").GetComponent<TextMeshProUGUI>();
        primarySlider = UIContainer.transform.Find("PrimaryWeapon").Find("AmmoRegenProgressBar").GetComponent<Slider>();
        secondarySlider = UIContainer.transform.Find("SecondaryWeapon").Find("AmmoRegenProgressBar").GetComponent<Slider>();
        primaryName = UIContainer.transform.Find("PrimaryWeapon").Find("WeaponNameText").GetComponent<TextMeshProUGUI>();
        secondaryName = UIContainer.transform.Find("SecondaryWeapon").Find("WeaponNameText").GetComponent<TextMeshProUGUI>();

        // spawn in the desired weapon
        switch (weapon)
        {
            case WeaponTypes.AlienMachineGun:
                playerAnimator.SetBool("gun", true);
                
                Instantiate(alienMachineGunPrefab, transform);
                break;
            case WeaponTypes.LaserBowAndArrow:
                Instantiate(laserBowAndArrowPrefab, transform);
                playerAnimator.SetBool("bow", true);
                                
                break;
            case WeaponTypes.SwordAndShield:
                Instantiate(swordAndShieldPrefab, transform);
                break;
        }
    }

    // Update is called once per frame
    void Update()
    {
        // update ammo values etc in the UI depending on which weapon we have
        switch (weapon)
        {
            case WeaponTypes.AlienMachineGun:

                AlienMachineGun gun = GetComponentInChildren<AlienMachineGun>();
                AlienGrenadeLauncher launcher = GetComponentInChildren<AlienGrenadeLauncher>();

                secondaryAmmoText.text = launcher.canShoot ? "1" : "0";
                primaryAmmoText.text = "" + gun.currentAmmo;

                primarySlider.value = gun.currentAmmo == gun.maxAmmoCapacity ? 1 : gun.ammoRegenTimer / gun.ammoResetTime;
                secondarySlider.value = launcher.canShoot ? 1 : launcher.timer / launcher.ammoResetTime;

                primaryName.text = "Machine Gun";
                secondaryName.text = "Grenade";

                break;

            case WeaponTypes.LaserBowAndArrow:

                ArrowAttack arrow = GetComponentInChildren<ArrowAttack>();
                LaserArrowAttack laser = GetComponentInChildren<LaserArrowAttack>();

                secondaryAmmoText.text = laser.currentAmmo + "";
                primaryAmmoText.text = arrow.currentAmmo + "";

                primarySlider.value = arrow.currentAmmo == arrow.maxAmmoCapacity ? 1 : arrow.ammoRegenTimer / arrow.ammoResetTime;
                secondarySlider.value = laser.currentAmmo == laser.maxAmmoCapacity ? 1 : laser.ammoRegenTimer / laser.ammoResetTime;

                primaryName.text = "Arrow";
                secondaryName.text = "Laser Arrow";

                break;

            case WeaponTypes.SwordAndShield:

                SwordAttack sword = GetComponentInChildren<SwordAttack>();
                Shield shield = GetComponentInChildren<Shield>();

                secondaryAmmoText.text = "";
                primaryAmmoText.text = "";

                primarySlider.value = sword.cooldownTimer / sword.attackCooldown;
                secondarySlider.value = shield.timer / shield.cooldown;

                primaryName.text = "Laser Sword";
                secondaryName.text = "Shield";

                break;
        }
    }
}
