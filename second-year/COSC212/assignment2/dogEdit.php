<?php
include("htaccess/header.php");
include("validationFunctions.php");
/**
 * The edit page for Dog Hire - Assignment 2
 * @desc Processes a form which allows admins to edit a dog.
 * @author Liam Flynn
 */
?>
<main>
    <h2>Edit Dog</h2>
    <?php
    $_SESSION['newId'] = $_POST['newId'];
    $_SESSION['newName'] = $_POST['newName'];
    $_SESSION['newType'] = $_POST['newType'];
    $_SESSION['newSize'] = $_POST['newSize'];
    $_SESSION['newDescription'] = $_POST['newDescription'];
    $_SESSION['newPrice'] = $_POST['newPrice'];

    $dogToEdit = $_POST['dogToEdit'];
    $file = "json/animals.json";
    $json_input = file_get_contents($file);
    $json = json_decode($json_input, true);

    /** Deletes old dog from json.*/
    foreach ($json['animals']['dogs'] as $key => $dogToRemove){
        if($dogToRemove['dogId'] == $dogToEdit){
            unset($json['animals']['dogs'][$key]);
        }
    }
    file_put_contents($file, json_encode($json));

    $idTaken = 0;
    $errors = array();
    $valid = true;

    $file = "json/animals.json";
    $json_input = file_get_contents($file);
    $json = json_decode($json_input, true);
    foreach ($json['animals']['dogs'] as $dog){
        if($dog['dogId'] == $_SESSION['newId']){
            $idTaken++;
        }
    }

    /** Adds errors to errors array if anything goes wrong. */
    if(isset($_POST['dogEdit'])){
        $valid = true;
        if(isEmpty($_POST['newId'])){
            $valid = false;
            array_push($errors, "Enter Dog ID");
        }
        if(isEmpty($_POST['newName'])){
            $valid = false;
            array_push($errors, "Enter Dog Name");
        }
        if(isEmpty($_POST['newType'])){
            $valid = false;
            array_push($errors, "Enter Dog Type");
        }
        if(isEmpty($_POST['newSize'])){
            $valid = false;
            array_push($errors, "Enter Dog Size");
        }
        if(isEmpty($_POST['newDescription'])){
            $valid = false;
            array_push($errors, "Enter Dog Description");
        }
        if(isEmpty($_POST['newPrice'])){
            $valid = false;
            array_push($errors, "Enter Dog Price Per Hour");
        }
        if ($idTaken > 0){
            $valid = false;
            array_push($errors, "Dog ID Taken");
        }
    }

    /** If there are errors, prints errors. Else adds edited dog to json.*/
    if(count($errors) != 0){
        echo "<ul>";
        foreach ($errors as $error) {
            echo "<li>$error</li>";
        }
        echo "</ul>";
    }else{
        array_push($json['animals']['dogs'], array('dogId' => $_SESSION['newId'], 'dogName' => $_SESSION['newName'], 'dogType' => $_SESSION['newType'], 'dogSize' => $_SESSION['newSize'], 'description' => $_SESSION['newDescription'], 'pricePerHour' => $_SESSION['newPrice']));
        file_put_contents($file, json_encode($json));

        echo "<p>Edited Dog</p>";
        echo "<p>Dog ID: " . $_SESSION['newId'] . "</p>";
        echo "<p>Dog Name: " . $_SESSION['newName'] . "</p>";
        echo "<p>Dog Type: " . $_SESSION['newType'] . "</p>";
        echo "<p>Dog Size: " . $_SESSION['newSize'] . "</p>";
        echo "<p>Dog Description: " . $_SESSION['newDescription'] . "</p>";
        echo "<p>Price Per Hour: " . $_SESSION['newPrice'] . "</p>";
    }
    session_destroy();
    ?>
</main>
</body>
</html>
