/**
 * @desc A closure that manages the Admin page
 * @requires JQuery
 * @author Nick Meek
 * @created July 2019
 * @updated July 2021
 */
var Admin = (function () {
    "use strict";
    var pub = {};

    pub.setup = function () {
        var s = "<table border='1'><tr><th>Name</th><th>Dog</th><th>Pickup Date</th><th>Pickup Time</th><th>Booked Hours</th></tr>";
        var bookings = [];
        $.getJSON("./json/bookings.json", function (data) {
            bookings = data.bookings.booking;
            console.log(bookings);
            $.each(bookings, function (k, v) {
                console.log(v.number);
                s += "<tr><td>" + v.name +
                    "</td><td>" + v.dogId + "</td>" +
                    "</td><td>" + v.pickup.day + ":" + v.pickup.month + ":" + v.pickup.year +
                    "</td><td>" + v.pickup.time + "</td>" + "</td><td>" + v.numHours + "</td>";
            });
            s += "</table>";
            $("main").append(s);
        });
    };

    return pub;
}());

$(document).ready(Admin.setup);