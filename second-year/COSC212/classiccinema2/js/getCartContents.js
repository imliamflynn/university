let GetCartContents = (function () {
    let pub = {};

    pub.setup = function () {
        let cartData = JSON.parse(localStorage.getItem("cart"));
        $.ajax({
            type: "POST",
            url: 'processCartContents.php',
            cache: false,
            data: JSON.stringify(cartData),
            datatype: 'JSON',
            contentType: "application/json; charset=utf-8",
            success: function(data) {
                /**window.location.href = "../php/processCartContents.php";*/
                $("#cart").append("<table><tr><th>Title</th><th>Price</th></tr>");
                for (const movie of cartData){
                    $("#cart").append("<tr><td>" + movie.title + "</td><td>" + movie.price + "</td>");
                }
                $("#cart").append("</table>");

                window.localStorage.clear();
            },
            error: function(data){
                alert("Ajax Failed");
            }
        });
    };

    return pub;
}());

$(document).ready(GetCartContents.setup);