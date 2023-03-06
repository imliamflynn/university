<?php
include("htaccess/header.php");
/**
 * The cancelBooking page for Dog Hire - Assignment 2
 * @desc Processes a form which allows admins to cancel a booking.
 * @author Liam Flynn
 */
?>
<main>
    <h2>Cancel Booking</h2>
    <?php
    $name = $_POST['bookingToCancel'];
    $file = "json/bookings.json";
    $json_input = file_get_contents($file);
    $json = json_decode($json_input, true);

    /**Removes booking from json file.*/
    foreach ($json['bookings']['booking'] as $key => $booking){
        if($booking['name'] == $name){
            unset($json['bookings']['booking'][$key]);
        }
    }

    file_put_contents($file, json_encode($json));

    echo "<p>Booking Cancelled</p>";
    ?>
</main>
</body>
</html>