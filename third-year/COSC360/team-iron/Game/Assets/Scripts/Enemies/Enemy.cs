using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Enemy : MonoBehaviour
{

    public float health;
    public GameObject damageTextPrefab;
    public int points;

    public float attackDamage;
    public float attackDistance;
    public float attackCooldown;

    private float distanceToPlayer;
    private float timer;
    private float prevHealth;
    private Coroutine coroutine = null;

    public int weakHazardDamage;

    private Vector3 scale;

    private bool alive;

    public AudioSource attackSound;

    private void Start()
    {
        alive = true;
        scale = transform.localScale;
        prevHealth = health;
    }

    void Update()
    {
        if (health <= 0)
        {
            Destroy(gameObject);
            Player.score += points;
            Player.kills += 1;
            alive = false;
            return;
        }

        timer += Time.deltaTime;

        Vector3 playerPosition = GameObject.FindGameObjectWithTag("Player").transform.position;

        // gets the distance between enemy and player
        distanceToPlayer = Vector2.Distance(this.transform.position, playerPosition);

        // if the player is within attack range of enemy AND the cooldown has finished
        if (distanceToPlayer <= attackDistance && timer > attackCooldown)
        {
            // attack player and reset timer
            Player.health -= attackDamage;
            timer = 0f;

            if (attackSound != null)
            {
                attackSound.Play();
            }
        }

        // if player is to the right of enemy
        if (playerPosition.x > transform.position.x)
        {
            transform.localScale = new Vector3(System.Math.Abs(scale[0]), scale[1], scale[2]);
        }
        else if (playerPosition.x < transform.position.x)
        {
            transform.localScale = new Vector3(-scale[0], scale[1], scale[2]);
        }
    }

    // called when shot
    public void dealDamage(int amount)
    {
        DamageText txt = Instantiate(damageTextPrefab, transform.Find("Canvas")).GetComponent<DamageText>();
        txt.setText(amount + "");
        health -= amount;
        if (health <= 0)
        {
            Destroy(gameObject);
            Player.score += points;
            Player.kills += 1;
            alive = false;
            return;
        }
    }

    private void OnTriggerEnter2D(Collider2D other)
    {
        if (other.CompareTag("KillHazard"))
        {
            Destroy(gameObject);
            Player.score += points;
            Player.kills += 1;
            alive = false;
            return;
        }
        if (other.CompareTag("WeakHazard"))
        {
            health -= weakHazardDamage;
            if (health <= 0)
            {
                Destroy(gameObject);
                Player.score += points;
                Player.kills += 1;
                alive = false;
                return;
            }
        }
    }

    // flash enemy red if we have taken damage
    private void LateUpdate()
    {
        // this stops the enemies from going invisible when they die
        if (health <= 0) return;

        if (prevHealth != health)
        {
            if (coroutine != null) StopCoroutine(coroutine);
            coroutine = StartCoroutine(flashRed(.6f));
        }
        prevHealth = health;
    }

    IEnumerator flashRed(float duration)
    {
        SpriteRenderer s = GetComponent<SpriteRenderer>();
        Color c = s.color;

        s.color = Color.red;

        for (float timer = 0f; timer < duration; timer += Time.deltaTime)
        {
            s.color = Color.Lerp(s.color, c, timer / duration);
            yield return null;
        }
    }

    public bool IsAlive()
    {
        return alive;
    }
}
