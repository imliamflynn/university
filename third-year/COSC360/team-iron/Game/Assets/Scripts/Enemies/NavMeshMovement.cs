using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.AI;

public class NavMeshMovement : MonoBehaviour
{
    Transform target;
    NavMeshAgent agent;

    Quaternion rotation;

    // Start is called before the first frame update
    void Start()
    {
        rotation = new Quaternion(0, 0, 0, 1.0f);

        agent = GetComponent<NavMeshAgent>();
        agent.updateRotation = false;
        agent.updateUpAxis = false;
        target = GameObject.FindGameObjectWithTag("Player").transform;
    }

    // Update is called once per frame
    void FixedUpdate()
    {
        //Debug.Log(transform.localRotation);
        transform.localRotation = rotation;

        agent.SetDestination(target.position);
    }
}
