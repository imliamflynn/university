<?php
session_start();
$reviews = simplexml_load_file($_POST['xmlFileName']);
$review = $reviews->addChild('review');
$user = $review->addChild('user', $_SESSION['authenticatedUser']);
$rating = $review->addChild('rating', $_POST['rating']);
$reviews->saveXML($_POST['xmlFileName']);
header("Location: " . $_SESSION['lastPage']);
?>
