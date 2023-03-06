using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/*
 * Handles simple WASD movement for the player.
 * Copied from stuartspixelgames.com
 */
public class PlayerMovement : MonoBehaviour
{
    Rigidbody2D body;

    public static float moveSpeed = 5; //5
    public static float maxMoveSpeed;
    public float diagMoveLimiter;

    public Animator animator;

    float horizontal;
    float vertical;

    private Coroutine speeedCoroutine;
    private bool speedBoostActive;

    // Perform object setup
    void Awake()
    {
        //moveSpeed = 5;
        body = GetComponent<Rigidbody2D>();
    }

    private void Start()
    {
        maxMoveSpeed = moveSpeed;
    }

    void Update()
    {
        // Gives a value between -1 and 1
        horizontal = Input.GetAxisRaw("Horizontal"); // -1 is left
        vertical = Input.GetAxisRaw("Vertical"); // -1 is down
        /*
        // Look left or right depending on movement direction
        if (horizontal < 0)
        {
            
            transform.localRotation = Quaternion.Euler(0, 180, 0);
        }
        else if (horizontal > 0)
        {
            transform.localRotation = Quaternion.Euler(0, 0, 0);
        }
        */
        // print(horizontal);
        // if(vertical == 1){
        //     animator.SetBool("sides", false);
        //     animator.SetBool("down", false);

        //     animator.SetBool("up", true);
        // }else if(vertical == -1){
        //     animator.SetBool("sides", false);
        //     animator.SetBool("up", false);

        //     animator.SetBool("down", true);
        // }else{
        //     animator.SetBool("up", false);
        //     animator.SetBool("down", false);

        //     animator.SetBool("sides", true);

        // }
    }

    void FixedUpdate()
    {

        if (horizontal != 0 && vertical != 0) // Check for diagonal movement
        {
            // limit movement speed diagonally, so you move at 70% speed
            horizontal *= diagMoveLimiter;
            vertical *= diagMoveLimiter;
        }

        body.velocity = new Vector2(horizontal * moveSpeed, vertical * moveSpeed);
    }

    // coroutine to temporarily increase speed
    private IEnumerator speedBoostCoroutune(float multiplier, float duration)
    {
        float initialSpeed = moveSpeed;
        moveSpeed *= multiplier;

        yield return new WaitForSeconds(duration);

        moveSpeed = initialSpeed;
        speedBoostActive = false;
    }

    // exposed method to start the coroutine
    public void speedBoost(float multiplier, float duration)
    {
        if (speeedCoroutine != null) StopCoroutine(speeedCoroutine);
        if (!speedBoostActive)
        {
            speedBoostActive = true;
            speeedCoroutine = StartCoroutine(speedBoostCoroutune(multiplier, duration));
        }
    }
}
