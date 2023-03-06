let AddToCart = (function () {
    let pub = {};

    function cart() {
        let listing = {};
        let cart = [];
        
        listing.title = $(this).parent().parent().find("h3")[0].innerHTML;
        listing.price = $(this).parent().find(".price")[0].innerHTML;

        if(window.localStorage.getItem("cart") === null){
            cart.push(listing);
        }else{
            cart = JSON.parse(window.localStorage.getItem("cart"));
            cart.push(listing);
        }
        window.localStorage.setItem("cart", JSON.stringify(cart));
    }

    pub.setup = function () {
        $(".buy").click(cart);
    };
    return pub;
}());

$(document).ready(AddToCart.setup);

//Selector = example.get/getItem("example");
//Event = example.onclick/click/onsubmit;
//DOM Manipulation = this.parentNode; (anything going through the DOM)