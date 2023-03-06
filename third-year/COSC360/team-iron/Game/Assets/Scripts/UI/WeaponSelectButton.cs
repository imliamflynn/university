using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class WeaponSelectButton : MonoBehaviour
{
    public Texture2D gunxhair;
    public PlayerWeapon.WeaponTypes weaponType;
    private Button btn;

    public AudioSource buttonClick;

    // Start is called before the first frame update
    void Start()
    {
        btn = GetComponent<Button>();
        btn.onClick.AddListener(pressed);
    }

    void pressed()
    {
        if (buttonClick != null)
        {
            buttonClick.Play();
        }
        PlayerWeapon.weapon = weaponType;
        SceneManager.LoadSceneAsync("TestScene");
        Cursor.SetCursor(gunxhair,new Vector2(15,15),CursorMode.Auto);
        Teleportation.xhairprev = gunxhair;
    }
}
