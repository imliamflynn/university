/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author liamflynn
 */
public class InvoiceItemTest {

    private InvoiceItem item;

    @BeforeEach
    public void setUp() {
        item = new InvoiceItem();
        item.setProductName("Polkadot Widget");
        item.setSalePrice(0.1);
        item.setQuantityPurchased(0.2);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testGetItemTotal() {
        Double result = item.getItemTotal();
        assertThat(result, is(closeTo(0.02,0.0001)));
    }

}
