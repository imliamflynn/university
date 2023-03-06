using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;
using UnityEngine.UI;

/*
 * Handles short range teleportation functionality for the player.
 *
 * Holding down space bar will prepare the teleporter, and cause a popup to show the range.
 * Releasing space will teleport the player to the location of the cursor.
 */
public class Teleportation : MonoBehaviour
{
    // exposed fields
    public float teleporterRange;
    public float teleporterCooldown;
    public float teleportAnimationDuration;
    public Animator animator;

    public static Texture2D xhairprev;
    public Texture2D telexhair;

    // hidden fields
    private Vector2 worldPositionOfMouse;
    private float timer;
    private Vector3 initialSize;

    // settings for line renderer to draw circle around player
    private int vertexCount = 40; // how detailed the circle is
    private LineRenderer lineRenderer;

    // UI
    private TextMeshProUGUI teleporterText;
    private Slider teleporterCooldownSlider;

    public AudioSource tpSound;

    // Set up object
    private void Awake()
    {
        lineRenderer = GetComponent<LineRenderer>();
        initialSize = transform.localScale;
        teleporterText = GameObject.Find("NewUI").transform.Find("Teleporter").Find("AmmoCountText").GetComponent<TextMeshProUGUI>();
        teleporterCooldownSlider = GameObject.Find("NewUI").transform.Find("Teleporter").Find("AmmoRegenProgressBar").GetComponent<Slider>();
    }

    // Update is called once per frame
    void Update()
    {
        // count timer
        timer += Time.deltaTime;

        // refresh circle every frame
        lineRenderer.positionCount = 0;

        // display circle when space is held down and we are able to teleport
        if (Input.GetKey(KeyCode.Space) && timer > teleporterCooldown)
        {
            drawCircle(teleporterRange);
            animator.SetBool("TeleOut", true);
            Cursor.SetCursor(telexhair, new Vector2(15, 15), CursorMode.Auto);
        }

        // update UI
        teleporterText.text = timer > teleporterCooldown ? "1" : "0";
        teleporterCooldownSlider.value = timer / teleporterCooldown;

        // when space is released
        if (Input.GetKeyUp(KeyCode.Space))
        {
            animator.SetBool("TeleOut", false);
            animator.SetBool("TeleIn", true);

            // if the cooldown is over, teleport
            if (timer > teleporterCooldown)
            {
                // reset cooldown
                timer = 0f;

                // get the world coordinates of the mouse cursor
                worldPositionOfMouse = Camera.main.ScreenToWorldPoint(
                    new Vector2(Input.mousePosition.x, Input.mousePosition.y));

                // verify the desired position is not inside an object with a collider
                Vector2 worldPoint = Camera.main.ScreenToWorldPoint(Input.mousePosition);
                RaycastHit2D hit = Physics2D.Raycast(worldPoint, Vector2.zero);
                if (hit.collider == null)
                {
                    Cursor.SetCursor(xhairprev, new Vector2(15, 15), CursorMode.Auto);
                    if (tpSound != null)
                    {
                        tpSound.Play();
                    }
                    // teleport the player to the cursor, if it is within range
                    float dist = Vector2.Distance(transform.position, worldPositionOfMouse);
                    if (dist < teleporterRange)
                    {
                        StartCoroutine(teleport(new Vector3(worldPositionOfMouse.x, worldPositionOfMouse.y, 0f)));
                    }
                    else
                    {
                        // otherwise teleport the player as far as possible in the desired direction
                        Vector2 direction = (worldPositionOfMouse - (Vector2)transform.position).normalized;
                        Vector2 newPos = teleporterRange * direction;
                        StartCoroutine(teleport(transform.position + new Vector3(newPos.x, newPos.y, 0f)));
                    }
                }
            }




        }
    }

    // Manipulates the line renderer component to draw a circle around the player
    private void drawCircle(float circleRadius)
    {
        float deltaTheta = (2f * Mathf.PI) / vertexCount;
        float theta = 0f;

        lineRenderer.positionCount = vertexCount;
        for (int i = 0; i < lineRenderer.positionCount; i++)
        {
            Vector3 pos = new Vector3(circleRadius * Mathf.Cos(theta), circleRadius * Mathf.Sin(theta), -5f);
            pos += transform.position;
            lineRenderer.SetPosition(i, pos);
            theta += deltaTheta;
        }
    }

    // Coroutine to begin teleport sequence by fading out player, moving them, then fading them back in
    IEnumerator teleport(Vector3 destination)
    {



        // // shrink player over time
        for (float f = 0; f < teleportAnimationDuration / 2; f += Time.deltaTime)
        {
            // transform.localScale = Vector3.Slerp(transform.localScale, new Vector3(0.01f, 0.01f, 0.01f), f);
            yield return null;
        }
        transform.position = destination;



        // return player to original size over time
        StartCoroutine(restoreSize());


    }

    // Helper coroutine to return player size to normal
    IEnumerator restoreSize()
    {
        for (float f = 0; f < teleportAnimationDuration / 2; f += Time.deltaTime)
        {
            transform.localScale = Vector3.Lerp(transform.localScale, initialSize, f);
            yield return null;
        }
        animator.SetBool("TeleIn", false);

    }
}