<?php
session_start();
include("htaccess/header.php");
include("validationFunctions.php");
/**
 * The booking page for Dog Hire - Assignment 2
 * @desc Processes a form which allows users to book a dog.
 * @author Liam Flynn
 */
?>
<main>
    <h2>Dog Booking</h2>
    <?php
    $_SESSION['dog'] = $_POST['dog'];
    $_SESSION['day'] = $_POST['day'];
    $_SESSION['month'] = $_POST['month'];
    $_SESSION['year'] = $_POST['year'];
    $_SESSION['time'] = $_POST['time'];
    $_SESSION['hours'] = $_POST['hours'];
    $_SESSION['name'] = $_POST['name'];

    $file = "json/bookings.json";
    $json_input = file_get_contents($file);
    $json = json_decode($json_input, true);

    $errors = array();
    $valid = true;
    /** Adds errors to errors array if there are any. */
    if(isset($_POST['dogBooking'])){
        $valid = true;
        if(isEmpty($_POST['dog'])){
            $valid = false;
            array_push($errors, "Choose a dog");
        }
        if(isEmpty($_POST['day'])){
            $valid = false;
            array_push($errors, "Enter a day");
        }
        if(isEmpty($_POST['month'])){
            $valid = false;
            array_push($errors, "Enter a month");
        }
        if(isEmpty($_POST['year'])){
            $valid = false;
            array_push($errors, "Enter a year");
        }
        if(isEmpty($_POST['time'])){
            $valid = false;
            array_push($errors, "Enter a time");
        }
        if(isEmpty($_POST['hours'])){
            $valid = false;
            array_push($errors, "Enter hours");
        }
        if(isEmpty($_POST['name'])){
            $valid = false;
            array_push($errors, "Enter your name");
        }
    }

    /** If there are errors, display them. Else make booking and add it to json. */
    if(count($errors) != 0){
        echo "<ul>";
        foreach ($errors as $error) {
            echo "<li>$error</li>";
        }
        echo "</ul>";
    }else{
        array_push($json['bookings']['booking'], array('dogId' => [$_SESSION['dog']], 'name' => $_SESSION['name'], 'pickup' => array('day' => $_SESSION['day'], 'month' => $_SESSION['month'], 'year' => $_SESSION['year'], 'time' => $_SESSION['time']), 'numHours' => $_SESSION['hours']));
        file_put_contents($file, json_encode($json));

        echo "<p>Success!</p>";
        echo "<p>Name: " . $_SESSION['name'] . "</p>";
        echo "<p>Dog: " . $_SESSION['dog'] . "</p>";
    }
    session_destroy();
    ?>
</main>
</body>
</html>
