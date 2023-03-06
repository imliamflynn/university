<?php
$_SESSION['lastPage'] = $_SESSION['PHP_SELF'];
include("htaccess/header.php");
/**
 * The logout page for Dog Hire - Assignment 2
 * @desc Clears the stored session details and redirects user to index.php.
 * @author Liam Flynn
 */
?>
<main>
    <h2>Logging Out</h2>
    <?php
    /** Clears the stored session details and redirects user to index.php.*/
    $_SESSION = array();
    session_destroy();
    header('Location: index.php');
    ?>
</main>
</body>
</html>