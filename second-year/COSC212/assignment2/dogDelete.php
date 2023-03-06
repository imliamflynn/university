<?php
include("htaccess/header.php");
/**
 * The delete page for Dog Hire - Assignment 2
 * @desc Processes a form which allows admins to delete a dog.
 * @author Liam Flynn
 */
?>
<main>
    <h2>Delete a Dog</h2>
    <?php
    $dogId = $_POST['dogToDelete'];
    $file = "json/animals.json";
    $json_input = file_get_contents($file);
    $json = json_decode($json_input, true);

    /**Deletes dog from json file */
    foreach ($json['animals']['dogs'] as $key => $dog){
        if($dog['dogId'] == $dogId){
            unset($json['animals']['dogs'][$key]);
            echo "<p>Deleted dog " . $dogId . "</p>";
        }
    }

    file_put_contents($file, json_encode($json));
    ?>
</main>
</body>
</html>