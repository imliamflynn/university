let ViewCart = (function () {
    let pub = {};

    /*displays all items in the cart*/
    function displayCart() {
        let target, i, cartArray;
        let total = 0.0;

        cartArray = JSON.parse(window.localStorage.getItem("cart"));
        target = document.getElementById("cartList");

        if (window.localStorage.getItem("cart") === null) {
            target.innerHTML = "<li>No dogs in cart.</li>";
            document.getElementById("checkoutForm").style.display = "none";
        } else {
            for (i = 0; i < cartArray.length; i++) {
                target.innerHTML += "<li>" + (i + 1) + ". " + cartArray[i].title
                    + " - " + cartArray[i].price + "</li>";
                total += parseFloat(cartArray[i].price);
            }
            target.innerHTML += "<li>----------------</li>";
            target.innerHTML += "<li>Total: " + total + "</li>";
        }
    }

    /*calls displayCart*/
    pub.setup = function () {
        displayCart();
    };

    return pub;
}());

$(document).ready(ViewCart.setup);