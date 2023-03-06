let Reviews = (function() {
    let pub = {};

    function parseReviews(data, target){
        $(target).empty();

        if($(data).find("review").length === 0){
            target.append("No reviews.");
        }

        $(data).find("review").each(function (){
           let rating = $(this).find("rating")[0].textContent;
           let user = $(this).find("user")[0].textContent;
           target.append(user + ": " + rating + "\n");
        });
    }

    function noXml(target){
        $(target).empty();
        $(target).append("No reviews.");
    }

    function showReviews() {
        let target = $(this).parent().find(".review")[0];
        let source = $(this).parent().find("img")[0].src;
        source = source.replace("images", "reviews").replace("jpg", "xml");

        $.ajax({
            type: "GET",
            url: source,
            cache: false,
            success: function(data){
                parseReviews(data, target);
            },
            error: function (){
                noXml(target);
            }
        });
    }
    pub.setup = function() {
        $(".film").append("<input type=\"button\" class=\"showReviews\" value=\"Show Reviews\">\n" +
            "<div class=\"review\"></div>");
        $(".showReviews").click(showReviews);
    }

    return pub;
}());

$(document).ready(Reviews.setup);