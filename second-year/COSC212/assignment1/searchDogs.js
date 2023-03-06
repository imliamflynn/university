let SearchDogs = (function() {
    let pub = {};
    let unavailableDogs = [];

    /*shows only the dogs that are available on the day that is passed from the form*/
    function showAvailableDogs(data){
        let i, j;
        let dogs = "";
        let dogsJSON = data.animals.dogs;
        let target = $("#availableDogs");
        let count = 0;

        for (i = 0; i < dogsJSON.length; i++) {
            for (j = 0; j < unavailableDogs.length; j++) {
                if (unavailableDogs[j] === dogsJSON[i].dogId) {
                    count = 1;
                }
            }
            if (count === 0) {
                let dog = "<section class='dogClass'>";
                let name = dogsJSON[i].dogName;
                let type = dogsJSON[i].dogType;
                let size = dogsJSON[i].dogSize;
                let desc = dogsJSON[i].description;
                let price = dogsJSON[i].pricePerHour;

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
                dog += "<input type='button' value='Select' class='rent'></p></section>";
                dogs += dog;
            }
            count = 0;
        }
        $(target).html(dogs);
    }

    /*checks date and calls showAvailableDogs*/
    function dateChecker(dogsData, date, bookingsData){
        for (let booking of bookingsData.bookings.booking) {
            booking.dogId.forEach(id => {
                let bookingDate = booking.pickup.day + booking.pickup.month + booking.pickup.year;
                if(date === bookingDate) {
                    unavailableDogs.push(id);
                }
            });
        }
        showAvailableDogs(dogsData);
    }

    /*gets data from bookings.json and passes it to dateChecker alongside data and date*/
    function getBookingsJSON(dogsData, date) {
        $.ajax({
            type: "GET",
            dataType: "json",
            contentType: "application/json",
            url: "./json/bookings.json",
            cache: false,
            success: function (bookingsData) {
                dateChecker(dogsData, date, bookingsData);
            }, error: function () {
                alert("error");
            }
        });
    }

    /*gets data from animals.json and passes it to getBookingsJSON also with the date*/
    function getDogsJSON(date){
        $.ajax({
            type: "GET",
            url: "./json/animals.json",
            cache: false,
            success: function (dogsData) {
                getBookingsJSON(dogsData, date);
            }, error: function () {
                alert("error");
            }
        });
    }

    /*stores the date and passes it to getDogsJSON*/
    function runProgram(){
        let day = $("#day").val();
        let month = $("#month").val();
        let year = $("#year").val();
        let date = day;
        date += month;
        date += year;
        getDogsJSON(date);
        return false;
    }

    /*calls runProgram when form is submitted*/
    pub.setup = function () {
        let form = document.getElementById("dogBookingForm");
        form.onsubmit = runProgram;
    };

    return pub;
}());

$(document).ready(SearchDogs.setup);