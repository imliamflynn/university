using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class StrongEnemy : MonoBehaviour
{

    public float health;
    public GameObject damageTextPrefab;

    public float attackDamage;
    public float attackDistance;
    public float attackCooldown;

    private float distanceToPlayer;
    private float timer;

    private Vector3 lastPosition;
    private bool goingRight;

    void Update()
    {
        Vector3 position = gameObject.transform.position;

        // if enemy is facing the right
        if (position[0] > lastPosition[0] && goingRight == false)
        {
            transform.Rotate(0, 0, 180);
            goingRight = true;
        }
        else if (position[0] < lastPosition[0] && goingRight == true)
        {
            transform.Rotate(0, 0, 180);
            goingRight = false;
        }

        timer += Time.deltaTime;

        // gets the distance between enemy and player
        distanceToPlayer = Vector3.Distance(this.transform.position, GameObject.FindGameObjectWithTag("Player").transform.position);

        // if the player is within attack range of enemy AND the cooldown has finished
        if (distanceToPlayer <= attackDistance && timer > attackCooldown)
        {
            // attack player and reset timer
            Player.health -= attackDamage;
            timer = 0f;
            Debug.Log("Enemy attacked the player!");
        }

        lastPosition = gameObject.transform.position;
    }

    // called when shot
    public void dealDamage(int amount)
    {
        DamageText txt = Instantiate(damageTextPrefab, transform.Find("Canvas")).GetComponent<DamageText>();
        txt.setText(amount + "");
        health -= amount;
        if (health < 1) Destroy(gameObject);
    }

    // called when weak spot is shot
    public void dealDamageWeakSpot(int amount, GameObject textPrefab)
    {
        DamageText txt = Instantiate(textPrefab, transform.Find("Canvas")).GetComponent<DamageText>();
        txt.setText(amount + "");
        health -= amount;
        if (health < 1) Destroy(gameObject);
    }
}
