// Liam Flynn - 22 May 2020 - Carousel

var images = new Array("imageA.jpg", "imageB.jpg", "imageC.jpg", "imageD.jpg");
var index = 0;

function goLeft() {
    var img = document.getElementById("pic");
    index = index - 1;
    if (index == -1) {
        index = images.length - 1;
    }
    img.src = images[index];
}

function goRight() {
    var img = document.getElementById("pic");
    index = index + 1;
    if (index == images.length) {
        index = 0;
    }
    img.src = images[index];
}

function setup() {
    var left = document.getElementById("left");
    var right = document.getElementById("right");
    left.onclick = goLeft;
    right.onclick = goRight;
}

if (document.getElementById) {
    window.onload = setup;
}
