<?php
include('htaccess/header.php');

if (!isset($_SESSION['authenticatedUser'])) {
    if (strlen($_SESSION['lastPage']) > 0) {
        header('Location: ' . $_SESSION['lastPage']);
        exit;
    } else {
        header('Location: index.php');
        exit;
    }
}
$_SESSION['lastPage'] = $_SERVER['PHP_SELF'];
?>
<main>
    <?php
    $orderNum = 1;
    $orders = simplexml_load_file('htaccess/orders.xml');

    echo "<h3>Orders</h3>";

    if ($_SESSION['role'] == "user") {
        foreach ($orders->order as $order) {
            $orderName = $order->delivery->username;
            if ($orderName == $_SESSION['authenticatedUser']) {
                echo "<h3>Order $orderNum</h3>";
                $orderNum++;

                $username = $order->delivery->username;
                echo "<p><b>Username: </b>$username</p>";

                $deliveryName = $order->delivery->deliveryName;
                echo "<p><b>Name: </b>$deliveryName</p>";

                $deliveryEmail = $order->delivery->deliveryEmail;
                echo "<p><b>Email: </b>$deliveryEmail</p>";

                $deliveryAddress1 = $order->delivery->deliveryAddress1;
                echo "<p><b>AddressLine1: </b>$deliveryAddress1</p>";

                $deliveryAddress2 = $order->delivery->deliveryAddress2;
                echo "<p><b>AddressLine2: </b>$deliveryAddress2</p>";

                $deliveryCity = $order->delivery->deliveryCity;
                echo "<p><b>City: </b>$deliveryCity</p>";

                $deliveryPostcode = $order->delivery->deliveryPostcode;
                echo "<p><b>Postcode: </b>$deliveryPostcode</p>";

                echo "<b>Movies:</b>";
                echo "<ul>";

                $items = $order->items;
                $totalCost = 0.0;

                foreach ($items->item as $item) {
                    $title = $item->title;
                    $price = $item->price;
                    echo "<li> $title $price";
                    $totalCost += floatval($price);
                }

                echo "</ul>";
                echo "<p><b>Total cost: </b>$totalCost</p>";
            }
        }
    }
    if ($_SESSION['role'] == "admin") {
        foreach ($orders->order as $order) {

            echo "<h3>Order $orderNum</h3>";
            $orderNum++;

            $username = $order->delivery->username;
            echo "<p><b>Username: </b>$username</p>";

            $deliveryName = $order->delivery->deliveryName;
            echo "<p><b>Name: </b>$deliveryName</p>";

            $deliveryEmail = $order->delivery->deliveryEmail;
            echo "<p><b>Email: </b>$deliveryEmail</p>";

            $deliveryAddress1 = $order->delivery->deliveryAddress1;
            echo "<p><b>AddressLine1: </b>$deliveryAddress1</p>";

            $deliveryAddress2 = $order->delivery->deliveryAddress2;
            echo "<p><b>AddressLine2: </b>$deliveryAddress2</p>";

            $deliveryCity = $order->delivery->deliveryCity;
            echo "<p><b>City: </b>$deliveryCity</p>";

            $deliveryPostcode = $order->delivery->deliveryPostcode;
            echo "<p><b>Postcode: </b>$deliveryPostcode</p>";

            echo "<b>Movies:</b>";
            echo "<ul>";

            $items = $order->items;
            $totalCost = 0.0;

            foreach ($items->item as $item) {
                $title = $item->title;
                $price = $item->price;
                echo "<li> $title $price";
                $totalCost += floatval($price);
            }

            echo "</ul>";
            echo "<p><b>Total cost: </b>$totalCost</p>";
        }
    }
    ?>
</main>
<?php
include('htaccess/footer.php');
?>
