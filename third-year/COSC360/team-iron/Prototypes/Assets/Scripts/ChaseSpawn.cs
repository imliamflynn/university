/*
	Created by: Lech Szymanski
				lechszym@cs.otago.ac.nz
				Dec 29, 2015			
*/

using UnityEngine;
using System.Collections;

/* This is an example script using A* pathfinding to chase a
 * target game object*/

public class ChaseSpawn : MonoBehaviour {

	// Target of the chase
	// (initialise via the Inspector Panel)
	private GameObject target;

	// Chaser's speed
	// (initialise via the Inspector Panel)
	public float speed;

	// Chasing game object must have a AStarPathfinder component - 
	// this is a reference to that component, which will get initialised
	// in the Start() method
	private AStarPathfinderSpawn pathfinder = null; 

	// Use this for initialization
	void Start () {
		
		target = GameObject.Find("Player");

		Debug.Log("player", target);
		//Get the reference to object's AStarPathfinder component
		pathfinder = transform.GetComponent<AStarPathfinderSpawn> ();
	}
	
	// Update is called once per frame
	void Update () {

		if (pathfinder != null) {
			//Travel towards the target object at certain speed.
			pathfinder.GoTowards(target, speed);
		}
	}
}
