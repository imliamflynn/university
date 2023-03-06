<?php
$scriptList = array('../js/jquery-3.6.0.min.js');
include("htaccess/header.php");
include("validationFunctions.php");
if(!isset($_SESSION['authenticatedUser'])){
    if(strlen($_SESSION['lastPage']) > 0){
        header('Location: ' . $_SESSION['lastPage']);
        exit;
    }else{
        header('Location: index.php');
        exit;
    }
}
$_SESSION['lastPage'] = $_SERVER['PHP_SELF'];

$_SESSION['deliveryName'] = htmlentities(htmlentities($_POST['deliveryName']));
$_SESSION['deliveryEmail'] = $_POST['deliveryEmail'];
$_SESSION['deliveryAddress1'] = $_POST['deliveryAddress1'];
$_SESSION['deliveryCity'] = $_POST['deliveryCity'];
$_SESSION['deliveryPostcode'] = $_POST['deliveryPostcode'];
$_SESSION['cardType'] = $_POST['cardType'];
$_SESSION['cardNumber'] = $_POST['cardNumber'];
$_SESSION['cardMonth'] = $_POST['cardMonth'];
$_SESSION['cardYear'] = $_POST['cardYear'];
$_SESSION['cardValidation'] = $_POST['cardValidation'];

$errors = [];

if (isEmpty($_SESSION['deliveryName'])) {
    array_push($errors, "You must enter a name");
}

if (isEmpty($_SESSION['deliveryEmail'])) {
    array_push($errors, "You must enter an email");
} else if (!isEmail($_SESSION['deliveryEmail'])) {
    array_push($errors, "The email must have the pattern name@domain.com");
}

if (isEmpty($_SESSION['deliveryAddress1'])) {
    array_push($errors, "You must enter an address");
}
if (isEmpty($_SESSION['deliveryCity'])) {
    array_push($errors, "You must enter a city");
}

if (isEmpty($_SESSION['deliveryPostcode'])) {
    array_push($errors, "You must enter a postcode");
} else if (!isDigits($_SESSION['deliveryPostcode']) || !checkLength($_SESSION['deliveryPostcode'], 4)) {
    array_push($errors, "The postcode should only contain the digits 0-9. The postcode must be 4 digits long");
}

if (isEmpty($_SESSION['cardNumber'])) {
    array_push($errors, "You must enter a credit card number");
} else if (!checkCardNumber($_SESSION['cardType'], $_SESSION['cardNumber'])) {
    array_push($errors, "Invalid card number!");
}

if (!checkCardDate($_SESSION['cardMonth'], $_SESSION['cardYear'])) {
    array_push($errors, "Card expiry date must be in the future");
}

if (isEmpty($_SESSION['cardValidation'])) {
    array_push($errors, "You must enter a CVC value");
} else if (!checkCardVerification($_SESSION['cardType'], $_SESSION['cardValidation'])) {
    array_push($errors, "Invalid CVC");
}
?>

    <main>
        <?php
        if (sizeof($errors) == 0) {
            echo "<p>Thanks for your order!</p>";
            echo "<script src='../js/getCartContents.js'></script>";
        } else {
            echo "<ul id='errors'>";
            foreach ($errors as $error) {
                echo "<li> $error </li>";
            }
            echo "</ul>";
        }
        ?>
        <div id="cart"></div>
    </main>

<?php include("htaccess/footer.php"); ?>