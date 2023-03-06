using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using TMPro;
using UnityEngine.UI;

public class Player : MonoBehaviour
{
    public static float health;
    public static float maxHealth;

    public static int wave = 1; // get rid of 1 before release
    public static int kills;
    public static int score;

    public float hazardKillTime;
    private bool kill;
    private float killTimer = 0;
    private float prevHealth; // used to track whether or not we have taken damage

    public int weakHazardDamage;

    private TextMeshProUGUI healthText;
    private TextMeshProUGUI waveText;
    private Coroutine flashCoroutine;
    private Image deathImage;

    private Vector3 scale;

    public AudioSource oof;
    public AudioSource crowdCheer;

    private int lastKills;
    private int comboKills;
    private float comboTimer;
    private bool combo;
    private bool cheering;

    private void Start()
    {
        // only called at the very start of the game
        if (wave <= 1)
        {
            health = 100;
            maxHealth = 100;
            score = 0;
            kills = 0;
            PlayerMovement.moveSpeed = 5;
        }

        prevHealth = health;
        scale = transform.localScale;
        comboTimer = 0;
        combo = false;
        cheering = false;
        lastKills = kills;
        comboKills = kills;
    }

    private void Awake()
    {
        deathImage = GameObject.Find("DeathImage").GetComponent<Image>();
        healthText = GameObject.Find("NewUI").transform.Find("HealthText").GetComponent<TextMeshProUGUI>();
        waveText = GameObject.Find("NewUI").transform.Find("WaveCounterText").GetComponent<TextMeshProUGUI>();
    }

    // Update is called once per frame
    void Update()
    {
        if (comboTimer >= 5)
        {
            combo = false;
            comboTimer = 0;
            comboKills = kills;
            cheering = false;
        }

        if (combo) comboTimer += Time.deltaTime;

        if (kills > lastKills && comboTimer < 5)
        {
            if (comboTimer == 0)
            {
                comboKills = lastKills;
                combo = true;
            }

            if (kills > (comboKills + 5))
            {
                if (crowdCheer != null && cheering == false)
                {
                    crowdCheer.Play();
                    cheering = true;
                }
            }
        }

        Vector2 mousePosition = Camera.main.ScreenToWorldPoint(
                    new Vector2(Input.mousePosition.x, Input.mousePosition.y));

        // if player is to the right of enemy
        if (mousePosition[0] > transform.position.x)
        {
            transform.localScale = new Vector3(System.Math.Abs(scale[0]), scale[1], scale[2]);
        }
        else if (mousePosition[0] < transform.position.x)
        {
            transform.localScale = new Vector3(-scale[0], scale[1], scale[2]);
        }

        if (kill) killTimer += Time.deltaTime;

        // kills player slightly after they collide with fatal traps, looks better
        if (killTimer >= hazardKillTime) health = 0;

        healthText.text = health + "%";
        waveText.text = "Wave " + wave;

        //Debug.Log(health);

        // kill player if true
        if (health <= 0)
        {
            if (wave > PlayerPrefs.GetInt("highwave"))
            {
                PlayerPrefs.SetInt("highwave", wave);
            }
            if (kills > PlayerPrefs.GetInt("highkills"))
            {
                PlayerPrefs.SetInt("highkills", kills);
            }
            if (score > PlayerPrefs.GetInt("highscore"))
            {
                PlayerPrefs.SetInt("highscore", score);
            }

            StartCoroutine(die());
            kill = false;
            killTimer = 0;
            PlayerMovement.moveSpeed = PlayerMovement.maxMoveSpeed;
        }

        lastKills = kills;
    }

    private void OnTriggerEnter2D(Collider2D other)
    {
        if (other.CompareTag("KillHazard"))
        {
            kill = true;
        }
        if (other.CompareTag("WeakHazard"))
        {
            health -= weakHazardDamage;
        }
    }

    // flash player red if we have taken damage
    private void LateUpdate()
    {
        if (health < 1) return;

        if (prevHealth != health)
        {
            if (flashCoroutine != null) StopCoroutine(flashCoroutine);
            flashCoroutine = StartCoroutine(flashRed(.6f));

            if (oof != null)
            {
                oof.Play();
            }
        }
        prevHealth = health;
    }

    IEnumerator flashRed(float duration)
    {
        SpriteRenderer s = GetComponent<SpriteRenderer>();
        Color c = s.color;

        s.color = Color.red;

        for(float timer = 0f; timer < duration; timer += Time.deltaTime)
        {
            s.color = Color.Lerp(s.color, c, timer / duration);
            yield return null;
        }
    }

    IEnumerator die()
    {
        for (float f = 0; f < 1f; f += Time.deltaTime)
        {
            deathImage.color = new Color(deathImage.color.r, deathImage.color.g, deathImage.color.b, f);
            yield return null;
        }

        Destroy(gameObject);
        SceneManager.LoadScene("GameOver");
    }
}
