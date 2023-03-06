<?php
include("htaccess/header.php");

$counter = 1;
if (isset($_COOKIE['counter'])) {
    $counter = (int) $_COOKIE['counter'];
}
echo "<main>";
echo "<p> You have been here $counter time(s) recently</p>";
echo "</main>";

setcookie('counter', $counter+1, time()+5, '/');

include("htaccess/footer.php");
?>