using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Grenade : MonoBehaviour
{

    private bool cook = false; //state var
    private Vector2 playerpos;
    private Vector2 throwerpos;

    public float bombdmg; //default 5
    public float cooktime; //default 2
    public float airspeed; //default 0.05f;
    public float dettime; //default 2;
    public float detradius; //default 2;


    //public GameObject explosioneffect; //none currently
    void Start()
    {
        cook = true;
        StartCoroutine(timers());
    }

    void Update()
    {
        throwerpos = transform.parent.position;
        
        if (cook)
        {
            this.transform.position = new Vector3(throwerpos.x, throwerpos.y, -1);

        }
        else
        {
            this.transform.position = Vector2.MoveTowards(transform.position, playerpos, airspeed);
        }

    }

    void explode()
    {
        Collider2D[] hitcolliders = Physics2D.OverlapCircleAll(transform.position, detradius);
        foreach (Collider2D hitCollider in hitcolliders)
        {
            //create collider on detonation - if player is in radius, deal dmg
            if (hitCollider.transform.tag == "Player")
            {
                Player.health -= bombdmg;
                Debug.Log("bomb hit player, -5");
            }
        }
        //instantiate explosion effect - does not exist currently
        Destroy(gameObject);
    }

    IEnumerator timers()
    {
        yield return new WaitForSeconds(cooktime);
        playerpos = GameObject.FindGameObjectWithTag("Player").transform.position;
        cook = false;
        yield return new WaitForSeconds(dettime);
        explode();
    }
}
