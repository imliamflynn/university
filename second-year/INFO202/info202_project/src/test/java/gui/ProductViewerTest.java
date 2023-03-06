package gui;

import dao.ProductDAO;
import domain.Product;
import helpers.SimpleListModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.DialogFixture;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 *
 * @author liamflynn
 */
public class ProductViewerTest {

    private ProductDAO proDAO;
    private DialogFixture fixture;
    private Robot robot;
    private Product pro1, pro2, pro3;

    @BeforeEach
    public void setUp() {
        robot = BasicRobot.robotWithNewAwtHierarchy();
        robot.settings().delayBetweenEvents(300);

        Collection<Product> products = new ArrayList<>();
        Collection<String> categories = new ArrayList<>();
        Collection<Product> productCats = new ArrayList<>();

        pro1 = new Product();
        pro1.setProductID("123");
        pro1.setName("Wagon");
        pro1.setDescription("A wagon.");
        pro1.setCategory("Old Transportation");
        pro1.setListPrice(new BigDecimal("20.00"));
        pro1.setQuantityInStock(new BigDecimal("2"));

        pro2 = new Product();
        pro2.setProductID("456");
        pro2.setName("Brie");
        pro2.setDescription("Brie cheese.");
        pro2.setCategory("Dairy");
        pro2.setListPrice(new BigDecimal("5.55"));
        pro2.setQuantityInStock(new BigDecimal("50"));

        pro3 = new Product();
        pro3.setProductID("789");
        pro3.setName("Camembert");
        pro3.setDescription("Camembert Cheese.");
        pro3.setCategory("Dairy");
        pro3.setListPrice(new BigDecimal("333.33"));
        pro3.setQuantityInStock(new BigDecimal("1000"));

        products.add(pro1);
        products.add(pro2);
        products.add(pro3);

        categories.add("Old Transportation");
        categories.add("Dairy");

        productCats.add(pro2);
        productCats.add(pro3);

        proDAO = mock(ProductDAO.class);

        when(proDAO.getProducts()).thenReturn(products);
        when(proDAO.getCategories()).thenReturn(categories);
        when(proDAO.searchByID("123")).thenReturn(pro1);
        when(proDAO.filterByCategory("Dairy")).thenReturn(productCats);

        Mockito.doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                products.remove(pro1);
                return null;
            }
        }).when(proDAO).removeProduct(pro1);
        Mockito.doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                products.remove(pro2);
                return null;
            }
        }).when(proDAO).removeProduct(pro2);
    }

    @AfterEach
    public void tearDown() {
        fixture.cleanUp();
    }

    @Test
    public void testDisplay() {
        ProductViewer dialog = new ProductViewer(null, true, proDAO);

        fixture = new DialogFixture(robot, dialog);
        fixture.show().requireVisible();
        fixture.click();

        SimpleListModel model = (SimpleListModel) fixture.list("listProducts").target().getModel();

        fixture.list("listProducts").requireItemCount(3);

        fixture.comboBox("combCat").selectItem("Dairy");

        assertThat(model, containsInAnyOrder(pro2, pro3));
        fixture.list("listProducts").requireItemCount(2);

        fixture.textBox("txtSearch").enterText("123");
        fixture.button("buttSearch").click();

        assertThat(model, containsInAnyOrder(pro1));
        fixture.list("listProducts").requireItemCount(1);
        
        verify(proDAO).getProducts();
        verify(proDAO).getCategories();
    }

    @Test
    public void testDelete() {
        ProductViewer dialog = new ProductViewer(null, true, proDAO);

        fixture = new DialogFixture(robot, dialog);
        fixture.show().requireVisible();
        fixture.click();

        SimpleListModel model = (SimpleListModel) fixture.list("listProducts").target().getModel();

        fixture.list("listProducts").requireItemCount(3);        
        
        fixture.list("listProducts").selectItem(pro1.toString());
        fixture.button("buttDelete").click();
        fixture.optionPane().requireVisible().yesButton().click();

        assertThat(model, containsInAnyOrder(pro2, pro3));
        fixture.list("listProducts").requireItemCount(2);
        
        verify(proDAO).removeProduct(pro1);
    }
}
