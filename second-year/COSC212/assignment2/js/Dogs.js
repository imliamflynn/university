/**
 * @desc A closure that manages the display of vehicles from a file
 * containing the information as JSON
 * @requires JQuery
 * @author Nick Meek
 * @created July 2020
 * @updated July 2021
 */
var Dogs = (function () {
    "use strict";
    var pub = {};
    var items;

    /**
     * Creates the HTML to display all the dogs from the file animals.json
     * as an HTML list. When finished it attaches some event handlers.
     */
    pub.setup = function () {
        //get the vehicle information and build the list for display / selection
        $.when($.getJSON("./json/animals.json", function (data) {
                items = data.animals.dogs;
                $.each(items, function (key, value) {
                    $("#dogsLst").append("<li id='" + (value.dogId).replace(/\s+/g, '') + "'>" + value.dogId + " : " +
                        value.dogName + " : " +
                        value.pricePerHour + "</li>").css({cursor: "pointer"});
                });
            })
        ).done(function () {
            //Add the event handlers to the list items just created
            $("#dogsLst li").mouseenter(function () {
                $("#dogPreviewPane").text("");
                showPreview($(this).attr("id"));
            }).mouseleave(function () {
                //nothing yet
            });
        });
    };//setup

    /**
     * Coordinates the building and displaying of a preview of each dog
     * @param id The id of the dog
     */
    function showPreview(id) {
        var dog;
        dog = findDogById(id);
        if (dog) {
            $("#dogPreviewPane").append(makeInfoTag(dog));
        } else {
            $("#dogPreviewPane").text("No Preview Found");
        }
    }//showPeview

    /**
     * Returns an html definition list describing a particular vehicle
     * @param dog The dog object
     * @return {string} The html string
     */
    function makeInfoTag(dog) {
        return "<section id='siteInfo'>" +

            "<dl><dt>Name</dt><dd>" + dog.dogName + "</dd></dl>" +
            "<dt>Price*</dt><dd>" + dog.pricePerHour + "</dd></dl>" +
            "<dt>Description</dt><dd>" + dog.description + "</dd></dl>" +
            makeImgTag(dog.dogSize) + "</section>";

    }

    /**
     * Returns an html img tag for a particular 'type' of vehicle
     * @param type Currently on of 'Small', 'Medium' or 'Large'. The default is 'Luxury'
     * @return {string} The html tag.
     */
    function makeImgTag(type) {
        if (type === "Small") {
            return "<img src='./images/small.jpg' alt='A small dog'>";
        } else if (type === "Medium") {
            return "<img src='./images/medium.jpg' alt='A medium dog'>";
        } else if (type === "Large") {
            return "<img src='./images/large.jpg' alt='A large dog'>";
        } else {
            return "<img src='./images/huge.jpg' alt='A huge dog'>";
        }
    }

    /**
     * Returns the vehicle with the given id or null if not found
     * @param id The id of the dog
     * @return {*} The dog or null
     */
    function findDogById(id) {
        var s = null;
        $.each(items, function (k, v) {
            if (id === (v.dogId).replace(/\s+/g, '') ) {
                s = items[k];
                return false;
            }
        });
        return s;
    }//findDogById

    return pub;
}());

$(document).ready(Dogs.setup);
