<?php
if (!isset($_GET['user'])) {
    header("Location: helloForm.html"); exit;
}
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<main>
    <?php
    echo "<p>Hello " . $_GET['user'] . "!</p>";
    ?>
</main>

</body>
</html>
