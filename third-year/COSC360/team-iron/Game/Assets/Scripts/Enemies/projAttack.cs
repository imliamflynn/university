using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class projAttack : MonoBehaviour
{
    public GameObject bombfab;
    public float bombcd;

    public AudioSource orbThrow;
    public AudioSource orbHit;
    public static AudioSource orbHit2;

    void Start()
    {
        orbHit2 = orbHit;
        StartCoroutine(throwBomb());
    }

    IEnumerator throwBomb()
    {
        //will throw on cd - can add randomness here to throw faster/slower
        yield return new WaitForSeconds(bombcd);
        //cook = true;
        GameObject bomb = Instantiate(bombfab);
        bomb.transform.parent = gameObject.transform;
        bomb.transform.localPosition = bomb.transform.up * 10;
        //print(bomb.transform.localPosition.y);

        if (orbThrow != null)
        {
            orbThrow.Play();
        }

        StartCoroutine(throwBomb()); //loop again
    }

    // makes orb hit sound
    public static void Hit()
    {
        if (orbHit2 != null)
        {
            orbHit2.Play();
        }
    }
}
