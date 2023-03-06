<?php
if(session_id() === ""){
    session_start();
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Classic Cinema</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="../style.css">
    <?php
        if (isset($scriptList) && is_array($scriptList)) {
            foreach ($scriptList as $script) {
                echo "<script src='$script'></script>";
            }
        }
    ?>
</head>
<body>
    <header>
        <h1>Classic Cinema</h1>

        <div id="user">
        <?php if (isset($_SESSION['authenticatedUser'])) { ?>
            <!-- HTML to display the Welcome message and logout form -->
            <div id="logout">
                <p>Welcome, <?php echo $_SESSION['authenticatedUser']; echo $_SESSION['role']; ?><span id="logoutUser"></span></p>
                <form id="logoutForm" action="logout.php" method>
                    <input type="submit" id="logoutSubmit" value="Logout">
                </form>
            </div>
        <?php } else { ?>
            <!-- HTML to display the login form -->
            <div id="login">
                <form id="loginForm" action="login.php"  method="POST">
                    <label for="loginUser">Username: </label>
                    <input type="text" name="loginUser" id="loginUser"><br>
                    <label for="loginPassword">Password: </label>
                    <input type="password" name="loginPassword" id="loginPassword"><br>
                    <input type="submit" id="loginSubmit" value="Login">
                    <a href="register.php">Register</a>
                </form>
            </div>
        <?php } ?>
        </div>

        <nav>
            <ul>
                <?php
                    $currentPage = basename($_SERVER['PHP_SELF']);
                    if ($currentPage === 'index.php') {
                        echo "<li>Home</li>";
                    } else {
                        echo "<li><a href='index.php'>Home</a></li>";
                    }
                    if ($currentPage === 'classic.php') {
                        echo "<li>Classic</li>";
                    } else {
                        echo "<li><a href='classic.php'>Classic</a></li>";
                    }
                    if ($currentPage === 'scifi.php') {
                        echo "<li>Sci Fi</li>";
                    } else {
                        echo "<li><a href='scifi.php'>Sci Fi</a></li>";
                    }
                    if ($currentPage === 'hitchcock.php') {
                        echo "<li>Hitchcock</li>";
                    } else {
                        echo "<li><a href='hitchcock.php'>Hitchcock</a></li>";
                    }
                    if ($currentPage === 'contact.php') {
                        echo "<li>Contact</li>";
                    } else {
                        echo "<li><a href='contact.php'>Contact</a></li>";
                    }

                    if (isset($_SESSION['authenticatedUser'])) {
                        if ($currentPage === 'cart.php') {
                            echo "<li>Cart</li>";
                        } else {
                            echo "<li><a href='cart.php'>Cart</a></li>";
                        }
                        if ($currentPage === 'orders.php') {
                            echo "<li>Orders</li>";
                        } else {
                            echo "<li><a href='orders.php'>Orders</a></li>";
                        }
                    }
                ?>
            </ul>
        </nav>
    </header>