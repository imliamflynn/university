using UnityEngine;
using System.Collections;
using UnityEngine.SceneManagement;

public class ControlsManager : MonoBehaviour
{
    public AudioSource buttonClick;

    public void Continue()
    {
        if (buttonClick != null)
        {
            buttonClick.Play();
        }

        SceneManager.LoadScene("WeaponSelect");
    }

}