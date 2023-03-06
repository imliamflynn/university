let MovieCategories = (function () {
    let pub = {};
    let categoryList, categoryIndex, classic, scifi, hitchcock;

    function MovieCategory(title, image, page) {
        this.title = title;
        this.image = image;
        this.page = page;
        this.makeHTML = function () {
            return ("<a href=\"" + page + "\"><figure><img alt=\"\" src=\"" + image + "\">" +
                "<figcaption>" + title + "</figcaption></figure></a>");
        }
    }

    function nextCategory() {
        let target;
        if (categoryIndex === 3) {
            categoryIndex = 0;
        }
        target = document.getElementById("spin");
        target.innerHTML = categoryList[categoryIndex].makeHTML();
        categoryIndex += 1;
    }

    pub.setup = function() {
        categoryList = [];
        categoryList.push(classic = new MovieCategory("Classic Movies", "images/The_Jazz_Singer.jpg", "classic.html"));
        categoryList.push(scifi = new MovieCategory("Sci Fi Movies", "images/King_Kong.jpg", "scifi.html"));
        categoryList.push(hitchcock = new MovieCategory("Hitchcock Movies", "images/Vertigo.jpg", "hitchcock.html"));
        categoryIndex = 0;
        nextCategory();
        setInterval(nextCategory, 1000);
    };
    return pub;
}());

if (window.addEventListener) {
    window.addEventListener('load', MovieCategories.setup);
} else if (window.attachEvent) {
    window.attachEvent('onload', MovieCategories.setup);
} else {
    alert("Could not attach 'MovieCategories.setup' to the 'window.onload' event");
}