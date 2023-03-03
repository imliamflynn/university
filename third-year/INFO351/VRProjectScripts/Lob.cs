using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.XR;

public class Lob : MonoBehaviour{

    public float thrust;
    public float destroyTimer;
    public float heightMult;
    public float distanceMult;


    private Rigidbody rigid;
    private GameObject player;
    private bool startTimer;
    private float timer;
    private System.Random rand = new System.Random();

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void FixedUpdate()
    {
        if (startTimer){
            timer += Time.fixedDeltaTime;
        }

        if (timer > destroyTimer){
            Destroy(gameObject);
        }
    }

    public void Huck()
    {   
        startTimer = true;
        rigid = GetComponent<Rigidbody>();
        if (player == null){
            player = GameObject.Find("Main Camera");
        }

        var direction = (player.transform.position - transform.position).normalized;

        var x = direction.x;
        var y = direction.y;
        var z = direction.z;
        

        var multipler = rand.Next(0, 5);
        var boost = rand.NextDouble() * 2;

        if(multipler == 1){
            y *= (float)heightMult * (float)boost;
        }else{
            y *= heightMult;
        }
        

        if (transform.position.x < -2 || transform.position.x > 2){
            x *= distanceMult * 2f;
            z *= distanceMult * 2f;
        }else{
            x *= distanceMult;
            z *= distanceMult;
        }

        direction = new Vector3(x,y,z);

        rigid.AddForce(direction * thrust);
    }
    
}

