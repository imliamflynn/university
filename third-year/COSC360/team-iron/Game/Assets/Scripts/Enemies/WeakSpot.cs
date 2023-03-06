using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class WeakSpot : MonoBehaviour
{
    public int damageMultiplier;
    public GameObject damageTextPrefab;

    // Public method bullets can use to deal damage
    public void dealDamage(int amount)
    {
        int damage = amount * damageMultiplier;

        // send damage to parent strong enemy???
        transform.parent.GetComponent<StrongEnemy>().dealDamageWeakSpot(damage, damageTextPrefab);
    }
}
