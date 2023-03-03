using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public class Score : MonoBehaviour
{
    public static string text;
    private TextMeshProUGUI textfield;

    // Start is called before the first frame update
    void Start()
    {
    }

    // Update is called once per frame
    void Update()
    {
        if (text != null){
            textfield = GetComponent<TextMeshProUGUI>();
            textfield.text = text;
            text = null;
        }
        
    }
}
