/*
	Created by: Lech Szymanski
				lechszym@cs.otago.ac.nz
				Dec 29, 2015			
*/

using UnityEngine;
using System.Collections;

/* This is an example script using A* pathfinding to chase a
 * target game object*/

public class Chase : MonoBehaviour {

	// Target of the chase
	// (initialise via the Inspector Panel)
	public GameObject target = null;

	// Chaser's speed
	// (initialise via the Inspector Panel)
	public float speed;

	// Chasing game object must have a AStarPathfinder component - 
	// this is a reference to that component, which will get initialised
	// in the Start() method

	private float offsetx;
	private float offsety;

	// Used to stagger the starts of each enemy so their pathfinding updates don't all fall on the same frame.
	private float randomTimer;

	// Use this for initialization
	void Start () {
		randomTimer = Random.Range(0, 0.5f);
		target = GameObject.FindGameObjectWithTag("Player");
		//StartCoroutine(setOffset());
		//Get the reference to object's AStarPathfinder component
		//pathfinder = transform.GetComponent<AStarPathfinder>();
	}
	/*
    // Update is called once per frame
    void FixedUpdate () {
		
		if(randomTimer > 0)
        {
			randomTimer -= Time.fixedDeltaTime;
			return;
        }

		if(pathfinder != null)
		{
			//Travel towards the target object at certain speed.
			pathfinder.GoTowards(new Vector2(target.transform.position.x + offsetx, target.transform.position.y + offsety), speed);
			//transform.position = Vector2.MoveTowards(transform.position, target.transform.position, speed);
		}
		
	}
	
	IEnumerator setOffset()
    {
		
		offsetx = Random.Range(-15, 16) / 10;
		offsety = Random.Range(-15, 16) / 10;
		yield return new WaitForSeconds(1);
		StartCoroutine(setOffset());
		
    }*/
}
