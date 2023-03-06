using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public class DamageText : MonoBehaviour
{
    private TextMeshProUGUI textField;

    // Start is called before the first frame update
    void Start()
    {
        // set position of text to above enemy head
        Vector3 enemyPos = Camera.main.WorldToScreenPoint(transform.parent.parent.position);
        transform.position = new Vector3(enemyPos.x, enemyPos.y + 30, enemyPos.z);
    }

    // Allow other scripts to set the text and begin animation
    public void setText(string text)
    {
        textField = GetComponent<TextMeshProUGUI>();
        textField.text = text;
        StartCoroutine(animate());
    }

    // animates the text and destroys it
    private IEnumerator animate()
    {
        for(float f = 0; f < 1; f += Time.deltaTime)
        {
            Vector3 enemyPos = Camera.main.WorldToScreenPoint(transform.parent.parent.position);
            transform.position = new Vector3(enemyPos.x, enemyPos.y + 30 + (60*f), enemyPos.z);
            if(f > .4f) textField.alpha -= f/70;
            yield return null;
        }

        Destroy(gameObject);
    }
}
