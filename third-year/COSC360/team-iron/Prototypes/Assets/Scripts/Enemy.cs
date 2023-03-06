using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Enemy : MonoBehaviour
{

    public float health;
    public GameObject damageTextPrefab;

    public float attackDamage;
    public float attackDistance;
    public float attackCooldown;

    private float distanceToPlayer;
    private float timer;

    void Update()
    {
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
    }

    // called when shot
    public void dealDamage(int amount)
    {
        DamageText txt = Instantiate(damageTextPrefab, transform.Find("Canvas")).GetComponent<DamageText>();
        txt.setText(amount + "");
        health -= amount;
        if (health < 1) Destroy(gameObject);
    }
}
