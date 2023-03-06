
import java.time.LocalDate;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.hasSize;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceTest {

    private Invoice invoice;
    private InvoiceItem item1;
    private InvoiceItem item2;

    @BeforeEach
    public void setUp() {
        invoice = new Invoice();
        invoice.setCustomerName("Doris Delores");
        invoice.setCustomerAddress("123 Some Street, Some where");
        invoice.setDate(LocalDate.now());

        item1 = new InvoiceItem();
        item1.setProductName("Polkadot Widget");
        item1.setSalePrice(0.1);
        item1.setQuantityPurchased(0.2);

        item2 = new InvoiceItem();
        item2.setProductName("Dodgy Doohicky");
        item2.setSalePrice(1.0);
        item2.setQuantityPurchased(2.0);

        invoice.addItem(item1);
        invoice.addItem(item2);
    }

    @AfterEach
    public void tearDown() {
        invoice.removeItem(item1);
        invoice.removeItem(item2);
    }

    @Test
    public void testAddItem() {
        assertThat(invoice.getItems(), hasItem(item1));
        assertThat(invoice.getItems(), hasItem(item2));
        assertThat(invoice.getItems(), hasSize(2));
    }

    @Test
    public void testRemoveItem() {
        invoice.removeItem(item1);
        assertThat(invoice.getItems(), not(hasItem(item1)));
        assertThat(invoice.getItems(), hasSize(1));
    }

    @Test
    public void testGetTotal() {
        assertThat(invoice.getTotal(), is(closeTo(2.02, 0.0001)));
    }

}
