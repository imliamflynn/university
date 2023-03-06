using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class rangeEnemy : MonoBehaviour
{
	public GameObject target = null;

	public float speed; //default 2
	public float health; //default 50
	public float avoidRange; //default 8-10
	public GameObject damageTextPrefab;

	private AStarPathfinder pathfinder = null;

	
	void Start()
	{
		pathfinder = transform.GetComponent<AStarPathfinder>();
		target = GameObject.FindGameObjectWithTag("Player");
	}

	void Update()
	{

		float delta = Vector2.Distance(target.transform.position, transform.position);
		if(delta < avoidRange)
        {
			pathfinder.GoTowards(target, -speed);
        }
		else
        {
			pathfinder.GoTowards(target, speed);
        }
	}

	public void dealDamage(int amount)
    {
		DamageText txt = Instantiate(damageTextPrefab, transform.Find("Canvas")).GetComponent<DamageText>();
		txt.setText(amount + "");
		health -= amount;
		if (health < 1) Destroy(gameObject);
	}
}
