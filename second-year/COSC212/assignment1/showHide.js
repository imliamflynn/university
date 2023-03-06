let ShowHide = (function () {
    let pub = {};

    function showHideDetails() {
        let paragraphs, p, images, i;
        paragraphs = this.parentNode.getElementsByTagName("p");
        for (p = 0; p < paragraphs.length; p += 1) {
            if (paragraphs[p].style.display === "none") {
                paragraphs[p].style.display = "block";
            } else {
                paragraphs[p].style.display = "none";
            }
        }
        images = this.parentNode.getElementsByTagName("img");
        for (i = 0; i < images.length; i += 1) {
            if (images[i].style.display === "none") {
                images[i].style.display = "block";
            } else {
                images[i].style.display = "none";
            }
        }
    }

    pub.setup = function () {
        let dogs, i, name;
        dogs = document.getElementsByClassName("dogClass");
        for (i = 0; i < dogs.length; i++) {
            name = dogs[i].getElementsByTagName("h3")[0];
            name.onclick = showHideDetails;
            name.style.cursor = "pointer";
        }
    }
    return pub;
}());

$(document).ready(ShowHide.setup);