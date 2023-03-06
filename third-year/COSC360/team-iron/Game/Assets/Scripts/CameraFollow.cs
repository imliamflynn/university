using System.Collections;
using System.Collections.Generic;
using UnityEngine;

/*
 * Allows camera to smoothly follow a Transform.
 */
public class CameraFollow : MonoBehaviour
{
    public Transform followTransform;
    public float cameraMoveSpeed;

    private float initialZ;

    private float shakeDuration;
    private float shakeMagnitude = 0.02f;
    private float dampingSpeed = 1f;

    private void Awake()
    {
        initialZ = transform.position.z;
    }

    void FixedUpdate()
    {
        // get position of object to follow
        Vector3 desiredPosition = followTransform.position;

        // interpolate our position toward the follow position
        this.transform.position =
            Vector3.Lerp(this.transform.position, desiredPosition, cameraMoveSpeed * Time.deltaTime);

        // clamp our z position, to prevent camera from falling through floor
        this.transform.position = new Vector3(transform.position.x, transform.position.y, initialZ);

        // screen shake
        if(shakeDuration > 0)
        {
            transform.localPosition += Random.insideUnitSphere * shakeMagnitude;
            shakeDuration -= Time.deltaTime * dampingSpeed;
        }
    }

    // exposed method to begin screen shake
    public void shakeScreen(float duration)
    {
        shakeDuration = duration;
    }
}
