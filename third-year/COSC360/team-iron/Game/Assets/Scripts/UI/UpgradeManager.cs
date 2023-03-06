using UnityEngine;
using System.Collections;
using UnityEngine.SceneManagement;

public class UpgradeManager : MonoBehaviour
{
    int healthBonus = 20; //default 20
    int dmgBonus = 5; //default 5
    float speedBonus = 0.5f; //default 1.5
    float maxSpeed = 10f;

    public AudioSource buttonClick;

    public void Health()
    {
        if (buttonClick != null)
        {
            buttonClick.Play();
        }
        // increase health
        SceneManager.LoadScene("TestScene");
        Player.maxHealth += healthBonus;
        healthBonus += 20;

        diffWave.waveDiff += 5;
        Player.health = Player.maxHealth;
        PlayerMovement.moveSpeed = PlayerMovement.maxMoveSpeed;

    }

    public void Damage()
    {
        if (buttonClick != null)
        {
            buttonClick.Play();
        }
        // increase damage
        SceneManager.LoadScene("TestScene");
        PlayerWeapon.WeaponTypes weapon = PlayerWeapon.weapon;

        Bullet.damage += dmgBonus;
        dmgBonus += 10;
        
        switch (weapon)
        {
            case PlayerWeapon.WeaponTypes.AlienMachineGun:
                Bullet.damage += 5;
                break;
            case PlayerWeapon.WeaponTypes.LaserBowAndArrow:
                Bullet.damage += 10;
                break;
            case PlayerWeapon.WeaponTypes.SwordAndShield:
                SwordAttack.damage += 10;
                break;

        }

        
        diffWave.waveDiff += 10;
        Player.health = Player.maxHealth;
        PlayerMovement.moveSpeed = PlayerMovement.maxMoveSpeed;

    }

    public void Speed()
    {
        if (buttonClick != null)
        {
            buttonClick.Play();
        }
        // increase speed
        SceneManager.LoadScene("TestScene");
        diffWave.waveDiff += 10;

        if (PlayerMovement.moveSpeed < maxSpeed)
        {
            PlayerMovement.maxMoveSpeed += speedBonus;
            speedBonus += 0.5f;
            PlayerMovement.moveSpeed = PlayerMovement.maxMoveSpeed;
        }

        Player.health = Player.maxHealth;
    }

}