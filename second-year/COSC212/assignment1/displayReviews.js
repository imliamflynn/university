let DisplayReviews = (function (){
    let pub = {};

    /*displays reviews*/
    function displayReviews(data, target){
        let reviews = "";

        for(let i = 0; i < data.length; i++){
            let title = data[i].title;
            let author = data[i].author;
            let review = data[i].reviewcontent;

            reviews += "<h3>" + title + "</h3>";
            reviews += "<p>Author: " + author + "</p>";
            reviews += "<p>" + review + "</p>";
        }

        $(target).html(reviews);
    }

    /*gets reviews.json data and calls displayReviews*/
    function getJSON(){
        let target = $("#reviewsList");

        $.ajax({
            type: "GET",
            url: "./json/reviews.json",
            cache: false,
            success: function(data){
                displayReviews(data, target);
            }, error: function(){
                alert("error");
            }
        });
    }

    /*calls getJSON*/
    pub.setup = function(){
        getJSON();
    }

    return pub;
}());

$(document).ready(DisplayReviews.setup);