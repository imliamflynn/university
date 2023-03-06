<?php
include("htaccess/header.php");
/**
 * The login page for Dog Hire - Assignment 2
 * @desc Checks if username and password entered are in the sql database.
 *       If so logs user in, else redirects user to last page or index.php.
 * @author Liam Flynn
 */
?>
<main>
    <h2>Login</h2>
    <?php
    /** Connects to db. */
    $conn = new mysqli('sapphire', 'llennonflynn', 'Liamflynn1', 'llennonflynn_dev');

    /**Checks username and password, logs in or redirects accordingly. */
    if($conn->errno){
        echo "Failed to connect to db.";
    }else{
        $username = $conn->real_escape_string($_POST['loginUser']);
        $password = $conn->real_escape_string($_POST['loginPassword']);

        $query = "SELECT * FROM Admin WHERE username = '$username' AND password = SHA('$password')";
        $result = $conn->query($query);
        if($result->num_rows === 0){
            echo "Failed to log in.";
        }else{
            $_SESSION['authenticatedUser'] = $username;
            if(isset($_SESSION['lastPage'])){
                header('Location: ' . $_SESSION['lastPage']);
                exit;
            }else{
                header('Location: index.php');
                exit;
            }
        }
    }
    ?>
</main>
</body>
</html>
