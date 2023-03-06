using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/*
 * Describes a stationary enemy used to test weapons on.
 */
public class StaticTestEnemy : MonoBehaviour
{
    public int health = 100;
    public GameObject damageTextPrefab;

    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        
    }

    // Public method bullets can use to deal damage
    public void dealDamage(int amount)
    {
        DamageText txt = Instantiate(damageTextPrefab,transform.Find("Canvas")).GetComponent<DamageText>();
        txt.setText(amount + "");
        health -= amount;
        if (health < 1) Destroy(gameObject);
    }
}
