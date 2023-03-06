<?php
function addReviewForm($xmlFileName){
    if (isset($_SESSION['authenticatedUser'])){
        echo "<form action='addReview.php' method='POST'>";
        echo "<input type ='hidden' name='xmlFileName' value='$xmlFileName'>";
        echo "<select name='rating' id='rating'>
        <option value='1'>1</option>
        <option value='2'>2</option>
        <option value='3'>3</option>
        <option value='4'>4</option>
        <option value='5'>5</option>
        </select>";
        echo "<input type='submit'>";
        echo "</form>";
    }
}
