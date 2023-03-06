<?php
$scriptList = array('js/Dogs.js', 'js/Booking.js', 'js/ShowReviews.js');
include("htaccess/header.php");
$_SESSION['lastPage'] = $_SERVER['PHP_SELF'];
/**
 * The home page for Dog Hire - Assignment 2
 * @desc Has a form which allows users to book a dog. Has a list of dogs you can preview, and displays reviews.
 * @author Liam Flynn
 */
?>
<main>
    <div id="bookingData">
        <section id="siteList">
            <fieldset>
                <legend>Our Lovely Dogs</legend>
                <ul id="dogsLst"></ul>
            </fieldset>
        </section>

        <section id="selectDates">
            <form id="dogBooking" action="dogBooking.php" method="POST" novalidate>
                <fieldset>
                    <legend>Dog Booking</legend>
                    <label for="dog">Dog: </label>
                    <select id="dog" name="dog">
                        <?php
                        /** Displays all dogs as options for drop down selection.*/
                        $json_input = file_get_contents("json/animals.json");
                        $json = json_decode($json_input, true);
                        foreach ($json['animals']['dogs'] as $dog) {
                            echo "<option value='" . $dog['dogId'] . "'>" . $dog['dogName'] . "</option>";
                        }
                        ?>
                    </select>
                    <label for="day">Day: </label>
                    <input type="text" id="day" name="day"
                        <?php
                        /** Stores day details in session, so they don't disappear from the form once you leave the page.*/
                        if (isset($_SESSION['day'])) {
                            $day = $_SESSION['day'];
                            echo "value='$day'";
                        }
                        ?>>
                    <label for="month">Month: </label>
                    <input type="text" id="month" name="month"
                        <?php
                        /** Stores month details in session, so they don't disappear from the form once you leave the page.*/
                        if (isset($_SESSION['month'])) {
                            $month = $_SESSION['month'];
                            echo "value='$month'";
                        }
                        ?>>
                    <label for="year">Year: </label>
                    <input type="text" id="year" name="year"
                        <?php
                        /** Stores year details in session, so they don't disappear from the form once you leave the page.*/
                        if (isset($_SESSION['year'])) {
                            $year = $_SESSION['year'];
                            echo "value='$year'";
                        }
                        ?>>
                    <label for="time">Time: </label>
                    <input type="time" id="time" name="time"
                        <?php
                        /** Stores time details in session, so they don't disappear from the form once you leave the page.*/
                        if (isset($_SESSION['time'])) {
                            $time = $_SESSION['time'];
                            echo "value='$time'";
                        }
                        ?>>
                    <label for="hours">Hours: </label>
                    <input type="number" id="hours" name="hours" max="12"
                        <?php
                        /** Stores hours details in session, so they don't disappear from the form once you leave the page.*/
                        if (isset($_SESSION['hours'])) {
                            $hours = $_SESSION['hours'];
                            echo "value='$hours'";
                        }
                        ?>>
                    <label for="name">Name: </label>
                    <input type="text" id="name" name="name" required
                        <?php
                        /** Stores name details in session, so they don't disappear from the form once you leave the page.*/
                        if (isset($_SESSION['name'])) {
                            $name = $_SESSION['name'];
                            echo "value='$name'";
                        }
                        ?>>
                    <input type="submit" value="Make Dog Booking">
                </fieldset>
            </form>
        </section>

        <section id="dogPreviewPane"></section>
    </div>

    <div id="reviews"><h2>Reviews</h2></div>
</main>
</body>
</html>