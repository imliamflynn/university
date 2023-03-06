<?php
include("htaccess/header.php");
?>

<main>
    <h2>Logged out</h2>
    <?php
    $_SESSION = array();
    session_destroy();
    header('Location: index.php');
    ?>
</main>

<?php include('htaccess/footer.php'); ?>
