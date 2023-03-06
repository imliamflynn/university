<?php
include('htaccess/header.php');
if(isset($_SESSION['authenticatedUser'])){
    if(strlen($_SESSION['lastPage']) > 0){
        header($_SESSION['lastPage']);
        exit;
    }else{
        header('index.php');
        exit;
    }
}
/**
 * The register page for Dog Hire - Assignment 2
 * @desc Has a form which allows users to register. Also does form processing in this same file as form.
 * @author Liam Flynn
 */
?>

<main>
    <h2>Register</h2>

    <?php
    /** Connects to db. */
    $conn = new mysqli('sapphire', 'llennonflynn', 'Liamflynn1', 'llennonflynn_dev');

    $_SESSION['username'] = $_POST['username'];
    $_SESSION['password'] = $_POST['password'];

    /** If valid, creates new user and inserts them into Admin sql database. Else displays errors.*/
    if(strlen(trim($_SESSION['username'])) > 0 && strlen(trim($_SESSION['password'])) > 0) {
        if ($conn->connect_errno) {
            echo "Failed to connect to db";
            exit;
        }

        $username = $conn->real_escape_string($_POST['username']);
        $password = $conn->real_escape_string($_POST['password']);
        $query = "SELECT * FROM Admin WHERE username = '$username'";
        $result = $conn->query($query);

        if ($result->num_rows === 0) {
            $query = "INSERT INTO Admin (username, password) " . "VALUES ('$username', SHA('$password'))";
            $conn->query($query);
            if ($conn->affected_rows === 0) {
                echo "Something went wrong";
            }
            header("Location: index.php");
        } else {
            echo "Username is already taken!";
        }
        $result->free();
        $conn->close();
    }else{
        /** Displays errors. */
    if(strlen(trim($_SESSION['username'])) == 0){
        echo "Enter username<br>";
    }
    if(strlen(trim($_SESSION['password'])) == 0){
        echo "Enter password<br>";
    }
    ?>

    <form id="register" action="<?php echo $_SERVER['PHP_SELF'];?>" method="POST" novalidate>
        <fieldset>
            <legend>Register</legend>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required
                <?php
                /** Stores username details in session, so they don't disappear from the form once you leave the page.*/
                if (isset($_SESSION['username'])) {
                    $username = $_SESSION['username'];
                    echo "value='$username'"; }
                ?>><br>
            <label for="password">Password:</label>
            <input type="text" id="password" name="password" required
                <?php
                /** Stores password details in session, so they don't disappear from the form once you leave the page.*/
                if (isset($_SESSION['password'])) {
                    $password = $_SESSION['password'];
                    echo "value='$password'"; }
                ?>><br>
            <input type="submit" value="Submit">
            <?php
            }
            ?>
        </fieldset>
    </form>

</main>
</body>
</html>
