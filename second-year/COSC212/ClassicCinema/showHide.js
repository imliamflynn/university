let ShowHide = (function() {
    let pub = {};

    function showHideDetails() {
        let paragraphs, p, images, i;
        /* jshint -W040 */
        paragraphs = this.parentNode.getElementsByTagName("p");
        /* jshint +W040 */
        for (p = 0; p < paragraphs.length; p += 1) {
            if (paragraphs[p].style.display === "none") {
                paragraphs[p].style.display = "block";
            } else {
                paragraphs[p].style.display = "none";
            }
        }
        /* jshint -W040 */
        images = this.parentNode.getElementsByTagName("img");
        /* jshint +W040 */
        for (i = 0; i < images.length; i += 1) {
            if (images[i].style.display === "none") {
                images[i].style.display = "block";
            } else {
                images[i].style.display = "none";
            }
        }
    }

    pub.setup = function() {
        let films, f, title;
        films = document.getElementsByClassName("film");
        for (f = 0; f < films.length; f++) {
            title = films[f].getElementsByTagName("h3")[0];
            title.onclick = showHideDetails;
            title.style.cursor = "pointer";
        }
    }
    return pub;
}());

if (window.addEventListener) {
    window.addEventListener('load', ShowHide.setup);
} else if (window.attachEvent) {
    window.attachEvent('onload', ShowHide.setup);
} else {
    alert("Could not attach 'ShowHide.setup' to the 'window.onload' event");
}