using UnityEngine;
using System.Collections;
using UnityEngine.SceneManagement;
using TMPro;
using UnityEngine.UI;

public class GameOverManager : MonoBehaviour
{
    private TextMeshProUGUI scoreText;
    private TextMeshProUGUI highScoreText;

    private int highWave;
    private int highKills;
    private int highScore;

    public AudioSource buttonClick;

    private void Awake()
    {
        highWave = PlayerPrefs.GetInt("highwave");
        highKills = PlayerPrefs.GetInt("highkills");
        highScore = PlayerPrefs.GetInt("highscore");
        scoreText = transform.Find("ScoreText").GetComponent<TextMeshProUGUI>();
        highScoreText = transform.Find("HighScoreText").GetComponent<TextMeshProUGUI>();
    }

    private void Update()
    {
        scoreText.text = "Wave: " + Player.wave + "  |  Kills: " + Player.kills + "  |  Score: " + Player.score;
        highScoreText.text = "Wave: " + highWave + "  |  Kills: " + highKills + "  |  Score: " + highScore;
    }

    public void StartGame()
    {
        if (buttonClick != null)
        {
            buttonClick.Play();
        }
        Player.wave = 1;
        SceneManager.LoadScene("TestScene");
    }

    public void MainMenu()
    {
        if (buttonClick != null)
        {
            buttonClick.Play();
        }
        SceneManager.LoadScene("MainMenu"); ;
    }
}