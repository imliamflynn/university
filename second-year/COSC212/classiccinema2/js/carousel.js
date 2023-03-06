let MovieCategories = (function () {
    let pub = {};
    let categoryList, categoryIndex, classic, scifi, hitchcock;

    function nextCategory() {
        let target;
        if (categoryIndex === 3) {
            categoryIndex = 0;
        }
        target = document.getElementById("spin");
        target.innerHTML = categoryList[categoryIndex].makeHTML();
        $("img").animate({paddingLeft: "300px", height: "400px"},3000, "swing");
        $("figcaption").animate({fontSize: "70px"}, 3000, "linear");
        categoryIndex += 1;
    }

    function MovieCategory(title, image, page) {
        this.title = title;
        this.image = image;
        this.page = page;
        this.makeHTML = function () {
            return ("<a href=\"" + page + "\"><figure><img alt=\"\" src=\"" + image + "\">" +
                "<figcaption>" + title + "</figcaption></figure></a>");
        }
    }

    pub.setup = function() {
        categoryList = [];
        categoryList.push(classic = new MovieCategory("Classic Movies", "../images/The_Jazz_Singer.jpg", "../php/classic.php"));
        categoryList.push(scifi = new MovieCategory("Sci Fi Movies", "../images/King_Kong.jpg", "../php/scifi.php"));
        categoryList.push(hitchcock = new MovieCategory("Hitchcock Movies", "../images/Vertigo.jpg", "../php/hitchcock.php"));
        categoryIndex = 0;
        nextCategory();
        setInterval(nextCategory, 3000);
    };
    return pub;
}());

$(document).ready(MovieCategories.setup);