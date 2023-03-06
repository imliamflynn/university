let Cart = (function () {
    let pub = {};

    /*adds selected dog to cart and saves dog to localStorage*/
    function addToCart() {
        let listing = {};
        let cart = [];
        alert("clicked Select");

        listing.name = this.parentNode.parentNode.getElementsByTagName("h3")[0].innerHTML;
        listing.price = this.parentNode.getElementsByClassName("price")[0].innerHTML;

        if (window.localStorage.getItem("cart") === null) {
            cart.push(listing);
        } else {
            cart = JSON.parse(window.localStorage.getItem("cart"));
            cart.push(listing);
        }
        window.localStorage.setItem("cart", JSON.stringify(cart));
    }

    /*displays a list of dogs showing their info, and an image*/
    function displayDogs(data, target){
        let dogs = "";
        let jsonDogList = data.animals.dogs;

        for(let i = 0; i < jsonDogList.length; i++){
            let dog = "<section class='dogClass'>";
            let name = jsonDogList[i].dogName;
            let type = jsonDogList[i].dogType;
            let size = jsonDogList[i].dogSize;
            let desc = jsonDogList[i].description;
            let price = jsonDogList[i].pricePerHour;

            if (size === "Small"){
                dog += "<img src=\"images/small.jpg\" alt=\"Small Dog\">";
            }else if (size === "Medium"){
                dog += "<img src=\"images/medium.jpg\" alt=\"Medium Dog\">";
            }else if (size === "Large"){
                dog += "<img src=\"images/large.jpg\" alt=\"Large Dog\">";
            }else if (size === "Huge"){
                dog += "<img src=\"images/huge.jpg\" alt=\"Huge Dog\">";
            }

            dog += "<h3>" + name + "</h3>";
            dog += "<p>Type: " + type + "</p>";
            dog += "<p>Size: " + size + "</p>";
            dog += "<p>Description: " + desc + "</p><p>";
            dog += "$<span class='price'>" + price + " p/h</span>";
            dog += "<input type='button' value='Select' class='rent' onclick='return addToCart(); return false'></p></section>";
            dogs += dog;
        }

        $(target).html(dogs);
    }

    /* gets data from animals.json then calls displayDogs*/
    function getJSON(){
        let target = $("#dogList");

        $.ajax({
            type: "GET",
            url: "./json/animals.json",
            cache: false,
            success: function(data){
                displayDogs(data, target);
            }, error: function(){
                alert("error");
            }
        });
    }

    /*calls getJSON and calls addToCart on the button that is clicked*/
    pub.setup = function(){
        getJSON();
        $(".rent").click(addToCart);
    }

    return pub;
}());

$(document).ready(Cart.setup);