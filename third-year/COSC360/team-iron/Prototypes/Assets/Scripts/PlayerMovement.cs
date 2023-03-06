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

    float horizontal;
    float vertical;
    float moveLimiter = 0.7f;

    public float moveSpeed = 20.0f;

    // Perform object setup
    void Awake()
    {
        body = GetComponent<Rigidbody2D>();
    }

    void Update()
    {
        // Gives a value between -1 and 1
        horizontal = Input.GetAxisRaw("Horizontal"); // -1 is left
        vertical = Input.GetAxisRaw("Vertical"); // -1 is down

        // Look left or right depending on movement direction
        if (horizontal < 0)
        {
            transform.localRotation = Quaternion.Euler(0, 180, 0);
        }
        else if (horizontal > 0)
        {
            transform.localRotation = Quaternion.Euler(0, 0, 0);
        }

    }

    void FixedUpdate()
    {
        if (horizontal != 0 && vertical != 0) // Check for diagonal movement
        {
            // limit movement speed diagonally, so you move at 70% speed
            horizontal *= moveLimiter;
            vertical *= moveLimiter;
        }

        body.velocity = new Vector2(horizontal * moveSpeed, vertical * moveSpeed);
    }
}
