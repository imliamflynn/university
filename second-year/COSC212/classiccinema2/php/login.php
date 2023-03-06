<?php
include ("htaccess/header.php");
?>

<main>
    <h2>Logged In</h2>
    <?php
    $conn = new mysqli('sapphire', 'llennonflynn', 'Liamflynn1', 'llennonflynn_dev');
    if ($conn->connect_errno) {
        echo "Failed to connect to db";
        exit;
    }else{
        $username = $conn->real_escape_string($_POST['loginUser']);
        $password = $conn->real_escape_string($_POST['loginPassword']);

        $query = "SELECT * FROM Users WHERE username = '$username' AND password = SHA('$password')";
        $result = $conn->query($query);
        if($result->num_rows === 0){
            echo "Log in failed";
        }else{
            $_SESSION['authenticatedUser'] = $username;
            $row = $result->fetch_assoc();
            $_SESSION['role'] = $row['role'];
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

<?php include('htaccess/footer.php'); ?>