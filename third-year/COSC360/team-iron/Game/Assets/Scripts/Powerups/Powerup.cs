using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/*
 * Placed on different power up objects, used by player to identify type of powerup.
 */
public class Powerup : MonoBehaviour
{
    public PowerupType type;

    public enum PowerupType
    {
        Speed,
        Ammo,
        Health
    }
}
