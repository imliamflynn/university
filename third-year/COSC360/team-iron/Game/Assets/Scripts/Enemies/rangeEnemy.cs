using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class rangeEnemy : MonoBehaviour
{
	Transform target;
	NavMeshAgent agent;

	public float speed; //default 2
	public float health; //default 50
	public float avoidRange; //default 8-10
	public int points;
	public GameObject damageTextPrefab;

	private float prevHealth;
	private Coroutine coroutine = null;

	public int weakHazardDamage;

	private Vector3 scale;
	private Quaternion rotation;

	private bool alive;

	void Start()
	{
		scale = transform.localScale;
		rotation = new Quaternion(0, 0, 0, 1.0f);

		alive = true;
		prevHealth = health;

		agent = GetComponent<NavMeshAgent>();
		agent.updateRotation = false;
		agent.updateUpAxis = false;
		target = GameObject.FindGameObjectWithTag("Player").transform;
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

		Vector3 playerPosition = GameObject.FindGameObjectWithTag("Player").transform.position;

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

    void FixedUpdate()
	{
		//Debug.Log(transform.localRotation);
		transform.localRotation = rotation;

		float delta = Vector2.Distance(target.position, transform.position);
		if (delta < avoidRange)
		{
			// avoid code
			agent.speed = 3;
			agent.SetDestination(new Vector3(transform.position.x + (transform.position.x - target.position.x), transform.position.y + (transform.position.y - target.position.y)));
		}
		else
		{
			agent.speed = 2.5f;
			agent.SetDestination(target.position);
		}
	}

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
