<?php
$scriptList = array('js/leaflet.js', 'js/map.js');
include ("htaccess/header.php");
$_SESSION['lastPage'] = $_SERVER['PHP_SELF'];
echo "<link rel='stylesheet' href='leaflet.css'>"
/**
 * The map page for Dog Hire - Assignment 2
 * @desc Displays leaflet map.
 * @author Liam Flynn
 */
?>
<main>
<div id="map"></div>
</main>
</body>
</html>