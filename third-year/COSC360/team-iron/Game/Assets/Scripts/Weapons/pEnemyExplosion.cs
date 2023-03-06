using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class pEnemyExplosion : MonoBehaviour
{

    private float timer;

    void Update()
    {
        timer += Time.deltaTime;
        if (timer > .3f) Destroy(gameObject);
    }
}
