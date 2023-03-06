using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class BGMusic : MonoBehaviour
{
    public AudioSource track1;
    public AudioSource track2;
    public AudioSource track3;

    private int trackSelector;
    private int trackHistory;

    // Start is called before the first frame update
    void Start()
    {
        trackSelector = Random.Range(0, 3);

        if (trackSelector == 0)
        {
            track1.Play();
            trackHistory = 1;
        }
        else if (trackSelector == 1)
        {
            track2.Play();
            trackHistory = 2;
        }
        else if (trackSelector == 2)
        {
            track3.Play();
            trackHistory = 3;
        }
    }

    // Update is called once per frame
    void Update()
    {
        if (track1.isPlaying == false && track2.isPlaying == false && track3.isPlaying == false)
        {
            if (trackSelector == 0 && trackHistory != 1)
            {
                track1.Play();
                trackHistory = 1;
            }
            else if (trackSelector == 1 && trackHistory != 2)
            {
                track2.Play();
                trackHistory = 2;
            }
            else if (trackSelector == 2 && trackHistory != 3)
            {
                track3.Play();
                trackHistory = 3;
            }
        }
    }
}
