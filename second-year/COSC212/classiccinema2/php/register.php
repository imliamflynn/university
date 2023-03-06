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
?>

<main>
    <h2>Register</h2>

    <?php
    $conn = new mysqli('sapphire', 'llennonflynn', 'Liamflynn1', 'llennonflynn_dev');

    $_SESSION['username'] = $_POST['username'];
    $_SESSION['password'] = $_POST['password'];
    $_SESSION['email'] = $_POST['email'];

    if(strlen(trim($_SESSION['username'])) > 0 && strlen(trim($_SESSION['password'])) > 0 && strlen(trim($_SESSION['email'])) > 0) {
        if ($conn->connect_errno) {
            echo "Failed to connect to db";
            exit;
        }

        $username = $conn->real_escape_string($_POST['username']);
        $password = $conn->real_escape_string($_POST['password']);
        $email = $conn->real_escape_string($_POST['email']);
        $query = "SELECT * FROM Users WHERE username = '$username'";
        $result = $conn->query($query);

        if ($result->num_rows === 0) {
            $query = "INSERT INTO Users (username, password, email, role) " . "VALUES ('$username', SHA('$password'), '$email', 'user')";
            $conn->query($query);
            if ($conn->affected_rows === 0) {
                echo "Something went wrong";
            }
        } else {
            echo "Username is already taken!";
        }


        $result->free();
        $conn->close();
    }else{
        if(strlen(trim($_SESSION['username'])) == 0){
            echo "Enter username<br>";
        }
        if(strlen(trim($_SESSION['password'])) == 0){
            echo "Enter password<br>";
        }
        if(strlen(trim($_SESSION['email'])) == 0){
            echo "Enter email<br>";
        }

    ?>

    <form id="register" action="<?php echo $_SERVER['PHP_SELF'];?>" method="POST" novalidate>
        <fieldset>
            <legend>Register</legend>
            <label for="username">Username:</label>
            <input type="text" id="username" name="username" required
                <?php if (isset($_SESSION['username'])) {
                    $username = $_SESSION['username'];
                    echo "value='$username'"; }
                ?>><br>
            <label for="password">Password:</label>
            <input type="text" id="password" name="password" required
                <?php if (isset($_SESSION['password'])) {
                    $password = $_SESSION['password'];
                    echo "value='$password'"; }
                ?>><br>
            <label for="email">Email:</label>
            <input type="text" id="email" name="email" required
                <?php if (isset($_SESSION['email'])) {
                    $email = $_SESSION['email'];
                    echo "value='$email'"; }
                ?>><br>
            <input type="submit" value="Submit">
            <?php
            }
            ?>
        </fieldset>
    </form>

</main>

<?php include('htaccess/footer.php'); ?>
