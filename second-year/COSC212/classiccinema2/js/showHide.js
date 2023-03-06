let ShowHide = (function() {
    let pub = {};

    function showHideDetails() {
        $(this).siblings().toggle();
    }

    pub.setup = function() {
        let films, f, title;
        films = $(".film");
        for (f = 0; f < films.length; f++) {
            title = films[f].getElementsByTagName("h3")[0];
            title.onclick = showHideDetails;
            title.style.cursor = "pointer";
        }
    }
    return pub;
}());

$(document).ready(ShowHide.setup);