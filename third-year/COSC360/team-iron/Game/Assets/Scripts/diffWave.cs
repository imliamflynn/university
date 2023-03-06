using UnityEngine;
using System.Collections.Generic;
using System.Collections;
using TMPro;
using UnityEngine.SceneManagement;
using UnityEngine.UI;

// [System.Serializable]
public class diffWave : MonoBehaviour
{
    public static int waveDiff;

    public GameObject[] enemyTypes;
    public List<GameObject> enemies;
    public float timeToSpawn;

    private int numEnemies;
    private GameObject[] spawnPoints;
    private float nextSpawnTime;
    private float spawnInterval;
    private TextMeshProUGUI enemyNum;

    private bool finished;
    private float timer;

    private Image fadeImage;
    private bool fadeImageCoroutineRunning;
    private float fadeDelayTimer;

    private void Start()
    {
        if (Player.wave == 1) waveDiff = 10; // normal is 10
        timer = 0;

        spawnPoints = GameObject.FindGameObjectsWithTag("Spawner");
        enemyNum = GameObject.Find("NewUI").transform.Find("EnemyNum").GetComponent<TextMeshProUGUI>();
        fadeImage = GameObject.Find("FadeImage").GetComponent<Image>();
        fadeImage.color = new Color(0, 0, 0, 0);
        fadeImageCoroutineRunning = false;

        LoadWave();
    }
    private void Update()
    {
        if (finished)
        {
            timer += Time.deltaTime;
        }

        fadeDelayTimer += Time.deltaTime;

        CheckDone();

        enemyNum.text = numEnemies + " Enemies Left";
    }

    void CheckDone()
    {
        List<GameObject> leftAlive = new List<GameObject>();
        GameObject[] allEnemies = GameObject.FindGameObjectsWithTag("Enemy");

        foreach(GameObject g in allEnemies)
        {
            Enemy e = g.GetComponent<Enemy>();
            if (e.IsAlive()) leftAlive.Add(g);
        }

        allEnemies = GameObject.FindGameObjectsWithTag("RangeEnemy");

        foreach (GameObject g in allEnemies)
        {
            rangeEnemy e = g.GetComponent<rangeEnemy>();
            if (e.IsAlive()) leftAlive.Add(g);
        }

        allEnemies = GameObject.FindGameObjectsWithTag("StrongEnemy");

        foreach (GameObject g in allEnemies)
        {
            StrongEnemy e = g.GetComponent<StrongEnemy>();
            if (e.IsAlive()) leftAlive.Add(g);
        }

        numEnemies = leftAlive.Count;

        // if player kills all enemies
        if(leftAlive.Count == 0)
        {
            finished = true;
            if (timer > 1 && !fadeImageCoroutineRunning) {
                
                finished = false;
                fadeImageCoroutineRunning = true;
                StartCoroutine(fadeBlackImage(1.2f));
                
            }
        }

    }

    IEnumerator fadeBlackImage(float duration)
    {
        for(float f = 0; f < duration; f += Time.deltaTime)
        {
            fadeImage.color = new Color(fadeImage.color.r, fadeImage.color.g, fadeImage.color.b, f / duration);
            yield return null;
        }
        Player.wave += 1;
        SceneManager.LoadScene("Upgrades");
    }

    void LoadWave()
    {
        //Debug.Log("Wave Difficulty: " + waveDiff);

        int rand;
        int numToSpawn;
        int startingDiff = waveDiff;

        while(waveDiff > 0)
        {
            rand = Random.Range(0, 10);

            if (rand <= 5 && waveDiff >= 1)
            {
                enemies.Add(enemyTypes[0]);
                numEnemies++;
                waveDiff -= 1;
            }
            else if (rand >= 6 && rand <= 8 && waveDiff >= 2)
            {
                enemies.Add(enemyTypes[1]);
                numEnemies++;
                waveDiff -= 2;
            }
            else if (waveDiff >= 3)
            {
                enemies.Add(enemyTypes[2]);
                numEnemies++;
                waveDiff -= 3;
            }            
        }

        waveDiff = startingDiff;

        spawnInterval = timeToSpawn/numEnemies;

        numToSpawn = numEnemies;

        StartCoroutine(SpawnWave(spawnInterval, numToSpawn));

    }

    IEnumerator SpawnWave(float interval, int num)
    {
        if(num > 0)
        {
            Instantiate(enemies[num-1], spawnPoints[Random.Range(0, spawnPoints.Length)].transform.position, Quaternion.identity);
            yield return new WaitForSeconds(interval);
            StartCoroutine(SpawnWave(interval, --num));
        }
    }
}