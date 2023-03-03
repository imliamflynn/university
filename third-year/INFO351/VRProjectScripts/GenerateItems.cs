using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GenerateItems : MonoBehaviour
{
    public GameObject cubePrefab;
    public float lobTimer;

    private float timer;
    private System.Random rand = new System.Random();

    // Start is called before the first frame update
    void Start(){}

    // Update is called once per frame
    void FixedUpdate()
    {
        timer += Time.fixedDeltaTime;

        if(timer > lobTimer){
            var x = rand.Next(-8, 8) * .5;
            var z = rand.Next(6, 8) * .5;

            var cube = Instantiate(cubePrefab, new Vector3((float)x , (float).1, (float)z), Quaternion.identity);
            cube.GetComponent<Lob>().Huck();

            timer = 0f;
        }
    }
}
