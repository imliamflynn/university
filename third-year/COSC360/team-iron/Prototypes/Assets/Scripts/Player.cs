using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class Player : MonoBehaviour
{
    public static float health = 100;

    // Update is called once per frame
    void Update()
    {
        if (health == 0)
        {
            // kill player
            Debug.Log("DEAD");
            Destroy(gameObject);
            SceneManager.LoadScene(SceneManager.GetActiveScene().buildIndex);
            health = 100;
        }
    }
}
