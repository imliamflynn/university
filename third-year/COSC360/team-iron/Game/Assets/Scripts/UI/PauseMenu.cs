using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

public class PauseMenu : MonoBehaviour
{
    bool pauseGame;

    public AudioSource buttonClick;

    // Show the pause menu in pause mode
    public void ShowPause()
    {
        // Pause the game
        pauseGame = true;
        // Show the panel
        gameObject.SetActive(true);
    }

    // Hide the menu panel
    public void Hide()
    {
        // Deactivate the panel
        gameObject.SetActive(false);
        // Resume the game (if paused)
        pauseGame = false;
        Time.timeScale = 1f;
    }

    // Resumes game
    public void ResumeGame()
    {
        if (buttonClick != null)
        {
            buttonClick.Play();
        }
        Hide();
    }

    // Quit to main menu
    public void MainMenu()
    {
        if (buttonClick != null)
        {
            buttonClick.Play();
        }
        SceneManager.LoadScene("MainMenu");
    }

    // Update is called once per frame
    void Update()
    {
        // If game is in pause mode, stop the timeScale value to 0
        if (pauseGame)
        {
            Time.timeScale = 0;
        }
    }
}
