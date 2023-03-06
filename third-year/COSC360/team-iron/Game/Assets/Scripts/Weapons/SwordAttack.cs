using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/*
 * Checks for colliders within a radius in front of the player when LMB is clicked.
 * Any colliders within that radius are damaged.
 */
public class SwordAttack : MonoBehaviour
{
    public static int damage; // base amount of damage the bullet does - default 40
    public int damageDeviation; // each bullet will do damage of (damage +/- damageDeviation)
    public float criticalHitChange; // chance a bullet will do extra damage
    public float range; // how far in front of the player does the attack sphere originate
    public float attackRadius; // how far around the attack sphere should enemies be damaged
    public float attackCooldown;

    [HideInInspector] public float cooldownTimer;
    private Vector2 swordAttackPoint;

    public AudioSource swordSwipe;
    public AudioSource stab;
    Animator playerAnimator;

    private void Awake(){
        playerAnimator = GameObject.FindWithTag("Player").GetComponent<Animator> ();

    }

    private void Start()
    {
        damage = 70;
    }

    // Update is called once per frame
    void Update()
    {
        cooldownTimer += Time.deltaTime;


        if(Input.GetMouseButton(0) && cooldownTimer > attackCooldown)
        {
            if (swordSwipe != null)
            {
                swordSwipe.Play();
               
            }
            if(playerAnimator.GetInteger("combo_score")<3){
                playerAnimator.SetInteger("combo_score", playerAnimator.GetInteger("combo_score")+1);
                            playerAnimator.SetTrigger("attack");


            }else{
                playerAnimator.SetInteger("combo_score", 1);
                            playerAnimator.SetTrigger("attack");


            }

            cooldownTimer = 0;

            // get direction player is aiming
            Vector2 worldPositionOfMouse = Camera.main.ScreenToWorldPoint(
                    new Vector2(Input.mousePosition.x, Input.mousePosition.y));
            Vector2 direction = (worldPositionOfMouse - (Vector2)transform.position).normalized;

            // set offset of sword collision detection to be in front of where the player is aiming
            swordAttackPoint = (Vector2)transform.position + (direction * range);

            // damage any relevant colliders caught in the area
            Collider2D[] results = new Collider2D[10];
            ContactFilter2D f = new ContactFilter2D();
            f.NoFilter();
            Physics2D.OverlapCircle(swordAttackPoint, attackRadius, f, results);

            foreach (Collider2D collision in results)
            {
                if (collision != null)
                {
                    int d = damage; // get base amount
                    d += Random.Range(-damageDeviation, damageDeviation); // apply randomness deviation
                    if (Random.value < criticalHitChange) d *= 3; // apply chance for triple damage

                    switch (collision.gameObject.tag)
                    {
                        case "Enemy":
                            collision.transform.GetComponent<Enemy>().dealDamage(d); // send damage to enemy
                            if (stab != null)
                            {
                                stab.Play();
                            }
                            break;

                        case "StrongEnemy":
                            collision.transform.GetComponent<StrongEnemy>().dealDamage(d); // send damage to enemy
                            if (stab != null)
                            {
                                stab.Play();
                            }
                            break;

                        case "WeakSpot":
                            collision.transform.GetComponent<WeakSpot>().dealDamage(d); // send damage to enemy
                            break;

                        case "RangeEnemy":
                            collision.transform.GetComponent<rangeEnemy>().dealDamage(d);
                            if (stab != null)
                            {
                                stab.Play();
                            }
                            break;
                    }
                }
            }
        }
    }

}
