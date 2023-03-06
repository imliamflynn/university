using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/*
 * Checks for colliders around player when RMB is clicked and pushes those enemies back.
 */
public class Shield : MonoBehaviour
{
    public float pushbackRange;
    public float pushbackAmount;
    public float cooldown;
    private Animator playerAnimator;

    [HideInInspector] public float timer;

    public AudioSource shieldBump;
    private void Awake(){
        playerAnimator = GameObject.FindWithTag("Player").GetComponent<Animator> ();

    }

    // Update is called once per frame
    void Update()
    {
        timer += Time.deltaTime;

        if (Input.GetMouseButtonDown(1) && timer > cooldown)
        {
            if (shieldBump != null)
            {
                shieldBump.Play();
            }
                    playerAnimator.SetTrigger("block");
            timer = 0;

            // damage any relevant colliders caught in the area
            Collider2D[] results = new Collider2D[10];
            ContactFilter2D f = new ContactFilter2D();
            f.NoFilter();
            Physics2D.OverlapCircle(transform.position, pushbackRange, f, results);

            foreach (Collider2D collision in results)
            {
                if (collision != null)
                {
                    // calculate position to push enemy back to
                    Vector2 direction = (collision.transform.position - transform.position).normalized;
                    Vector2 pushbackPosition = (Vector2)collision.transform.position + (direction * pushbackRange);

                    switch (collision.gameObject.tag)
                    {
                        case "TestEnemy":
                        case "Enemy":
                        case "StrongEnemy":
                        case "RangeEnemy":
                            collision.transform.position = pushbackPosition;
                            break;
                    }
                }
            }
        }else{

        }

    }
}
