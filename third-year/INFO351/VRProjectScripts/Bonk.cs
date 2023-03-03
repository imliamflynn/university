using System.Collections;
using System.Collections.Generic;
using UnityEngine;
//using OVRInput;

public class Bonk : MonoBehaviour
{
    public GameObject explosionPrefab;
    public int score;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    void OnCollisionEnter(Collision collision)
    {
        var cube = collision.gameObject;

        //Check for a match with the specified name on any GameObject that collides with your GameObject
        if (cube.name == "Cube(Clone)")
        {
            Instantiate(explosionPrefab, new Vector3(cube.transform.position.x, cube.transform.position.y, cube.transform.position.z), Quaternion.identity);
            Destroy(cube);

            //OVRInput.SetControllerVibration(1, 1, OVRInput.Controller.RTouch);
            //OVRInput.SetControllerVibration(1, 1, OVRInput.Controller.LTouch);

            score += 1;
            
            Score.text = "Score: " + score.ToString();
        }
    }
}
