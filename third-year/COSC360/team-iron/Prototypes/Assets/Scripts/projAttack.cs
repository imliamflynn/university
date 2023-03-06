using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class projAttack : MonoBehaviour
{
    public GameObject bombfab;
    public float bombcd;

    void Start()
    {
        StartCoroutine(throwBomb());
    }

    IEnumerator throwBomb()
    {
        //will throw on cd - can add randomness here to throw faster/slower
        yield return new WaitForSeconds(bombcd);
        //cook = true;
        GameObject bomb = Instantiate(bombfab);
        bomb.transform.parent = gameObject.transform;
        StartCoroutine(throwBomb()); //loop again
    }
}
