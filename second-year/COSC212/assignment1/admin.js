let Admin = (function (){
    let pub = {};

    /*uses passed json data to display bookings*/
    function displayBookings(data, target){
        let bookings = '';
        let jsonBookingsList = data.bookings.booking;

        for (let i = 0; i < jsonBookingsList.length; i++) {
            let id = jsonBookingsList[i].dogId;
            let name = jsonBookingsList[i].name;
            let day = jsonBookingsList[i].pickup.day;
            let month = jsonBookingsList[i].pickup.month;
            let year = jsonBookingsList[i].pickup.year;
            let time = jsonBookingsList[i].pickup.time;
            let numHours = jsonBookingsList[i].numHours;

            bookings += '<h3>Dog Id: ' + id + '</h3>';
            bookings += '<p>Name: ' + name + '</p>';
            bookings += '<p>Day: ' + day + '</p>';
            bookings += '<p>Month: ' + month + '</p>';
            bookings += '<p>Year: ' + year + '</p>';
            bookings += '<p>Time: ' + time + '</p>';
            bookings += '<p>Number of Hours: ' + numHours + '</p>';
        }

        $(target).html(bookings);
    }

    /*gets data from bookings.json and passes it to displayBookings*/
    function getJSON(){
        let target = $("#bookingsList");

        $.ajax({
            type: "GET",
            url: "./json/bookings.json",
            cache: false,
            success: function(data){
                displayBookings(data, target);
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

$(document).ready(Admin.setup);