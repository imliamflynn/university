<?php
if (session_id() == "") {
    session_start();
}
/**
 * The header for Dog Hire - Assignment 2
 * @desc Is the header that is displayed at the top of all web pages. Displays all the navigation links
 * and changes depending on if you are signed in or not. And adds scripts depending on the scriptList passed
 * by php file that includes this one.
 * @author Liam Flynn
 */
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Dog Hire</title>
    <link rel="stylesheet" href="style.css">
    <link rel="stylesheet" href="js/jquery/jquery-ui.min.css">
    <script src="js/jquery/jquery3.3.js"></script>
    <?php
    /** If $scriptList is set, add script tags with each script from $scriptList. */
    if (isset($scriptList) && is_array($scriptList)) {
        foreach ($scriptList as $script) {
            echo "<script src='$script'></script>";
        }
    }
    ?>
</head>
<body>
<header>
    <h1>Dog Hire</h1>
    <div id="user">
        <?php
        /** Displays logout form if user is logged in. */
        if (isset($_SESSION['authenticatedUser'])) {
            ?>
            <!-- HTML to display the Welcome message and logout form -->
            <div id="logout">
                <p>Welcome, <?php echo $_SESSION['authenticatedUser'];?><span id="logoutUser"></span></p>
                <form id="logoutForm" action="logout.php" method>
                    <input type="submit" id="logoutSubmit" value="Logout">
                </form>
            </div>
        <?php
            /** Displays login form is user is not logged in. */
        } else {
            ?>
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
            /**Displays navigation links depending on login status*/
            $currentPage = basename($_SERVER['PHP_SELF']);
            if ($currentPage === 'index.php') {
                echo "<li>Home</li>";
            } else {
                echo "<li><a href='index.php'>Home</a></li>";
            }
            if ($currentPage === 'map.php') {
                echo "<li>Map</li>";
            } else {
                echo "<li><a href='map.php'>Map</a></li>";
            }

            if (isset($_SESSION['authenticatedUser'])) {
                if ($currentPage === 'admin.php') {
                    echo "<li>Admin</li>";
                } else {
                    echo "<li><a href='admin.php'>Admin</a></li>";
                }
            }
            ?>
        </ul>
    </nav>
</header>