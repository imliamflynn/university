using UnityEngine;
using System.Collections;
using UnityEngine.SceneManagement;

public class CreditsManager : MonoBehaviour
{
    public AudioSource buttonClick;

    public void Back()
    {
        if (buttonClick != null)
        {
            buttonClick.Play();
        }

        SceneManager.LoadScene("MainMenu");
    }

}