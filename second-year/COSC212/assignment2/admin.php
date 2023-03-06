<?php
$scriptList = array('js/Admin.js');
include("htaccess/header.php");
$_SESSION['lastPage'] = $_SERVER['PHP_SELF'];
/**
 * The admin page for Dog Hire - Assignment 2
 * @desc Has multiple forms which allows admins to add a dog, edit a dog, delete a dog, and cancel a booking. Displays all bookings in a table too.
 * @author Liam Flynn
 */
?>
<main>
    <h2>Adminstration Page</h2>
    <div id="bookings"></div>
    <div>
        <form id="dogAdd" action="dogAdd.php" method="POST" novalidate>
            <fieldset>
                <legend>Add Dog</legend>
                <label for="dogId">Dog ID: </label>
                <input type="text" id="dogId" name="dogId"
                    <?php
                    /** Stores dogId details in session, so they don't disappear from the form once you leave the page.*/
                    if(isset($_SESSION['dogId'])){
                        $dogId = $_SESSION['dogId'];
                        echo "value='$dogId'";
                    }
                    ?>><br>
                <label for="dogName">Dog Name: </label>
                <input type="text" id="dogName" name="dogName"
                    <?php
                    /** Stores dogName details in session, so they don't disappear from the form once you leave the page.*/
                    if(isset($_SESSION['dogName'])){
                        $dogName = $_SESSION['dogName'];
                        echo "value='$dogName'";
                    }
                    ?>><br>
                <label for="dogType">Dog Type: </label>
                <input type="text" id="dogType" name="dogType"
                    <?php
                    /** Stores dogType details in session, so they don't disappear from the form once you leave the page.*/
                    if(isset($_SESSION['dogType'])){
                        $dogType = $_SESSION['dogType'];
                        echo "value='$dogType'";
                    }
                    ?>><br>
                <label for="dogSize">Dog Size: </label>
                <select id="dogSize" id="dogSize" name="dogSize"
                    <?php
                    /** Stores dogSize details in session, so they don't disappear from the form once you leave the page.*/
                    if(isset($_SESSION['dogSize'])){
                        $dogSize = $_SESSION['dogSize'];
                        echo "value='$dogSize'";
                    }
                    ?>>
                    <option value="small">Small</option>
                    <option value="medium">Medium</option>
                    <option value="large">Large</option>
                    <option value="huge">Huge</option>
                </select><br>
                <label for="description">Description: </label>
                <textarea rows="3" cols="30" id="description" name="description"
                    <?php
                    /** Stores description details in session, so they don't disappear from the form once you leave the page.*/
                    if(isset($_SESSION['description'])){
                        $description = $_SESSION['description'];
                        echo "value='$description'";
                    }
                    ?>>
                </textarea><br>
                <label for="price">Price Per Hour: </label>
                <input type="text" id="price" name="price"
                    <?php
                    /** Stores price details in session, so they don't disappear from the form once you leave the page.*/
                    if(isset($_SESSION['price'])){
                        $price = $_SESSION['price'];
                        echo "value='$price'";
                    }
                    ?>><br>
                <input type="submit" name="dogAdd" value="Add Dog">
            </fieldset>
        </form>
    </div>

    <div>
        <form id="dogEdit" action="dogEdit.php" method="POST" novalidate>
            <fieldset>
                <legend>Edit Dog</legend>
                <label for="dogToEdit">Dog To Edit: </label>
                <select id="dogToEdit" name="dogToEdit">
                    <?php
                    /** Displays all dogs as options for drop down selection.*/
                    $json_input = file_get_contents("json/animals.json");
                    $json = json_decode($json_input, true);
                    var_dump($json);
                    foreach ($json["animals"]["dogs"] as $dogToEdit){
                        echo "<option value='" . $dogToEdit["dogId"] . "'>Dog ID: " . $dogToEdit["dogId"] . "</option>";
                    }
                    ?>
                </select><br>
                <label for="newId">New Dog ID: </label>
                <input type="text" id="newId" name="newId"
                    <?php
                    /** Stores newId details in session, so they don't disappear from the form once you leave the page.*/
                    if(isset($_SESSION['newId'])){
                        $newId = $_SESSION['newId'];
                        echo "value='$newId'";
                    }
                    ?>><br>
                <label for="newName">New Dog Name: </label>
                <input type="text" id="newName" name="newName"
                    <?php
                    /** Stores newName details in session, so they don't disappear from the form once you leave the page.*/
                    if(isset($_SESSION['newName'])){
                        $newName = $_SESSION['newName'];
                        echo "value='$newName'";
                    }
                    ?>><br>
                <label for="newType">New Dog Type: </label>
                <input type="text" id="newType" name="newType"
                    <?php
                    /** Stores newType details in session, so they don't disappear from the form once you leave the page.*/
                    if(isset($_SESSION['newType'])){
                        $newType = $_SESSION['newType'];
                        echo "value='$newType'";
                    }
                    ?>><br>
                <label for="newSize">New Dog Size: </label>
                <select id="newSize" id="newSize" name="newSize"
                    <?php
                    /** Stores newSize details in session, so they don't disappear from the form once you leave the page.*/
                    if(isset($_SESSION['newSize'])){
                        $newSize = $_SESSION['newSize'];
                        echo "value='$newSize'";
                    }
                    ?>>
                    <option value="small">Small</option>
                    <option value="medium">Medium</option>
                    <option value="large">Large</option>
                    <option value="huge">Huge</option>
                </select><br>
                <label for="newDescription">New Dog Description: </label>
                <textarea rows="3" cols="30" id="newDescription" name="newDescription"
                    <?php
                    /** Stores newDescription details in session, so they don't disappear from the form once you leave the page.*/
                    if(isset($_SESSION['newDescription'])){
                        $newDescription = $_SESSION['newDescription'];
                        echo "value='$newDescription'";
                    }
                    ?>>
                </textarea><br>
                <label for="newPrice">New Dog Price: </label>
                <input type="text" id="newPrice" name="newPrice"
                    <?php
                    /** Stores newPrice details in session, so they don't disappear from the form once you leave the page.*/
                    if(isset($_SESSION['newPrice'])){
                        $newPrice = $_SESSION['newPrice'];
                        echo "value='$newPrice'";
                    }
                    ?>><br>
                <input type="submit" value="Save Changes">
            </fieldset>
        </form>
    </div>

    <div>
        <form id="cancelBooking" action="cancelBooking.php" method="POST" novalidate>
            <fieldset>
                <legend>Cancel Booking</legend>
                <label for="bookingToCancel">Bookings: </label>
                <select id="bookingToCancel" name="bookingToCancel">
                <?php
                /** Displays all bookings as options for drop down selection.*/
                $json_input = file_get_contents("json/bookings.json");
                $json = json_decode($json_input, true);
                foreach ($json["bookings"]["booking"] as $booking){
                    echo "<option value='" . $booking["name"] . "'>" . $booking["name"] . "</option>";
                }
                ?>
                </select><br>
                <input type="submit" value="Cancel Booking">
            </fieldset>
        </form>
    </div>

    <div>
        <form id="dogDelete" action="dogDelete.php" method="POST" novalidate>
            <fieldset>
                <legend>Delete Dog</legend>
                <label for="dogToDelete">Dogs: </label>
                <select id="dogToDelete" name="dogToDelete">
                    <?php
                    /** Displays all dogs as options for drop down selection.*/
                    $json_input = file_get_contents("json/animals.json");
                    $json = json_decode($json_input, true);
                    foreach ($json["animals"]["dogs"] as $dog){
                        echo "<option value='" . $dog["dogId"] . "'>Dog ID: " . $dog["dogId"] . "</option>";
                    }
                    ?>
                </select><br>
                <input type="submit" value="Delete Dog">
            </fieldset>
        </form>
    </div>
</main>
</body>
</html>

