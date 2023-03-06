let Cart = (function () {
    let pub = {};


    function cart() {
        let target, i, cartArray;
        let total = 0.0;

        cartArray = JSON.parse(window.sessionStorage.getItem("cart"));
        target = document.getElementById("cartList");

        if (window.sessionStorage.getItem("cart") === null){
            target.innerHTML = "<li>No items in cart.</li>";
            document.getElementById("checkoutForm").style.display="none";
        }else {
            for(i = 0; i < cartArray.length; i++) {
                target.innerHTML += "<li>" + (i+1) + ". " + cartArray[i].title
                    + " - " + cartArray[i].price + "</li>";
                total += parseFloat(cartArray[i].price);
            }
            target.innerHTML += "<li>----------------</li>";
            target.innerHTML += "<li>Total: " + total + "</li>";
        }
    }

    pub.setup = function () {
        cart();
    };

    return pub;
}());

if (window.addEventListener) {
    window.addEventListener('load', Cart.setup);
} else if (window.attachEvent) {
    window.attachEvent('onload', Cart.setup);
} else {
    alert("Could not attach 'Cart.setup' to the 'window.onload' event");
}