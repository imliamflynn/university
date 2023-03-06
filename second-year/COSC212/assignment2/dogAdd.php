<?php
include("htaccess/header.php");
include("validationFunctions.php");
/**
 * The add dog page for Dog Hire - Assignment 2
 * @desc Processes a form which allows admins to add a dog.
 * @author Liam Flynn
 */
?>

<main>
    <h2>Add Dog</h2>
    <?php
    $_SESSION['dogId'] = $_POST['dogId'];
    $_SESSION['dogName'] = $_POST['dogName'];
    $_SESSION['dogType'] = $_POST['dogType'];
    $_SESSION['dogSize'] = $_POST['dogSize'];
    $_SESSION['description'] = $_POST['description'];
    $_SESSION['price'] = $_POST['price'];

    $idTaken = 0;
    $errors = array();
    $valid = true;

    $file = "json/animals.json";
    $json_input = file_get_contents($file);
    $json = json_decode($json_input, true);
    /** If dogId is already in use $idTaken is increased. */
    foreach ($json['animals']['dogs'] as $dog){
        if($dog['dogId'] == $_SESSION['dogId']){
            $idTaken++;
        }
    }
    /** Adds errors to errors array if there are any. */
    if(isset($_POST['dogAdd'])){
        $valid = true;
        if(isEmpty($_POST['dogId'])){
            $valid = false;
            array_push($errors, "Enter Dog ID");
        }
        if(isEmpty($_POST['dogName'])){
            $valid = false;
            array_push($errors, "Enter Dog Name");
        }
        if(isEmpty($_POST['dogType'])){
            $valid = false;
            array_push($errors, "Enter Dog Type");
        }
        if(isEmpty($_POST['dogSize'])){
            $valid = false;
            array_push($errors, "Enter Dog Size");
        }
        if(isEmpty($_POST['description'])){
            $valid = false;
            array_push($errors, "Enter Dog Description");
        }
        if(isEmpty($_POST['price'])){
            $valid = false;
            array_push($errors, "Enter Dog Price Per Hour");
        }
        if ($idTaken > 0){
            $valid = false;
            array_push($errors, "Dog ID Taken");
        }
    }

    /** If there are errors, displays them. Else adds new dog to json file. */
    if(count($errors) != 0){
        echo "<ul>";
        foreach ($errors as $error) {
            echo "<li>$error</li>";
        }
        echo "</ul>";
    }else{
        array_push($json['animals']['dogs'], array('dogId' => $_SESSION['dogId'], 'dogName' => $_SESSION['dogName'], 'dogType' => $_SESSION['dogType'], 'dogSize' => $_SESSION['dogSize'], 'description' => $_SESSION['description'], 'pricePerHour' => $_SESSION['price']));
        file_put_contents($file, json_encode($json));

        echo "<p>New Dog</p>";
        echo "<p>Dog ID: " . $_SESSION['dogId'] . "</p>";
        echo "<p>Dog Name: " . $_SESSION['dogName'] . "</p>";
        echo "<p>Dog Type: " . $_SESSION['dogType'] . "</p>";
        echo "<p>Dog Size: " . $_SESSION['dogSize'] . "</p>";
        echo "<p>Dog Description: " . $_SESSION['description'] . "</p>";
        echo "<p>Price Per Hour: " . $_SESSION['price'] . "</p>";
    }
    session_destroy();
    ?>
</main>
</body>
</html>
