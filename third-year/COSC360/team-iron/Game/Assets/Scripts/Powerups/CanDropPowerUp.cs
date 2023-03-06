using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/*
 * Goes on enemies that can drop powerups when destroyed.
 */
public class CanDropPowerUp : MonoBehaviour
{
    public GameObject[] powerups;
    public float dropChance;

    private void OnDestroy()
    {
        if(Random.value <= dropChance)
        {
            Instantiate(powerups[Random.Range(0, powerups.Length)], transform.position, Quaternion.identity);
        }
    }
}
