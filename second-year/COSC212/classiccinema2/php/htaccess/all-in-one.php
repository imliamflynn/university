<?php
if (strlen(trim($_GET['user']))> 0){
    if (isset($_GET['submit'])) {
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
<?php }
} else {
    ?>
    <form name="myForm" action="<?php echo $_SERVER['PHP_SELF'];?>" method="GET">
        <label for="name">Name: </label>
        <input type="text" id="name" name="user">
        <button type="submit" name="submit">Submit</button>
    </form>
<?php } ?>