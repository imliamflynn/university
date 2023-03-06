let AddToCart = (function () {
    let pub = {};

    function cart() {
        alert("Hi!");
        let listing = {};
        let cart = [];

        listing.title = this.parentNode.parentNode.getElementsByTagName("h3")[0].innerHTML;
        listing.price = this.parentNode.getElementsByClassName("price")[0].innerHTML;

        if(window.sessionStorage.getItem("cart") === null){
            cart.push(listing);
        }else{
            cart = JSON.parse(window.sessionStorage.getItem("cart"));
            cart.push(listing);
        }
        window.sessionStorage.setItem("cart", JSON.stringify(cart));
    }

    pub.setup = function () {
        //let button;
        //button = document.getElementsByClassName("buy");
        //for (let i = 0; i < button.length; i++) {
        //    button[i].onclick = cart;
        //}
        $(".buy").click(cart);
    };
    return pub;
}());

$(document).ready(AddToCart.setup);

//Selector = example.get/getItem("example");
//Event = example.onclick/click/onsubmit;
//DOM Manipulation = this.parentNode; (anything going through the DOM)