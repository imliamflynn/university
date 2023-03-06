let Cart = (function () {
    let pub = {};

    function cart() {
        let target, i, cartArray;
        let total = 0.0;

        cartArray = JSON.parse(window.localStorage.getItem("cart"));
        target = $("#cartList");

        if (window.localStorage.getItem("cart") === null){
            target.append("<li>No items in cart.</li>");
        }else {
            for(i = 0; i < cartArray.length; i++) {
                target.append("<li>" + (i+1) + ". " + cartArray[i].title
                    + " - " + cartArray[i].price + "</li>");
                total += parseFloat(cartArray[i].price);
            }
            target.append("<li>----------------</li>");
            target.append("<li>Total: " + total + "</li>");
        }
    }

    pub.setup = function () {
        cart();
    };

    return pub;
}());

$(document).ready(Cart.setup);