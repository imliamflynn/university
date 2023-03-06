using UnityEngine;
using System.Collections;
using UnityEngine.SceneManagement;

public class MainMenuManager : MonoBehaviour
{
    public AudioSource buttonClick;

    public void StartGame()
    {
        if (buttonClick != null)
        {
            buttonClick.Play();
        }
        Player.wave = 1;
        SceneManager.LoadScene("Controls");
    }

    public void Credits()
    {
        if (buttonClick != null)
        {
            buttonClick.Play();
        }

        SceneManager.LoadScene("Credits");
    }
}