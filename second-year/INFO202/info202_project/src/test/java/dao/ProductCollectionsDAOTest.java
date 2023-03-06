package dao;

import domain.Product;
import java.math.BigDecimal;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author liamflynn
 */
public class ProductCollectionsDAOTest {

    private ProductDAO proDAO;
    private Product pro1;
    private Product pro2;
    private Product pro3;

    @BeforeAll
    public static void initialise() {
        JdbiDaoFactory.setJdbcUri("jdbc:h2:mem:tests;INIT=runscript from 'src/main/java/dao/schema.sql'");
    }

    @BeforeEach
    public void setUp() {
        //proDAO = new ProductCollectionsDAO();
        proDAO = JdbiDaoFactory.getProductDAO();

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
        pro3.setName("Snakes and Ladders");
        pro3.setDescription("Snakes and Ladders board game.");
        pro3.setCategory("Board Games");
        pro3.setListPrice(new BigDecimal("333.33"));
        pro3.setQuantityInStock(new BigDecimal("1000"));

        proDAO.saveProduct(pro1);
        proDAO.saveProduct(pro2);
    }

    @AfterEach
    public void tearDown() {
        proDAO.removeProduct(pro1);
        proDAO.removeProduct(pro2);
        proDAO.removeProduct(pro3);
    }

    @Test
    public void testSaveProduct() {
        assertThat(proDAO.getProducts(), hasSize(2));
        proDAO.saveProduct(pro3);
        assertThat(proDAO.getProducts(), hasItem(pro3));
        assertThat(proDAO.getProducts(), hasSize(3));
    }

    @Test
    public void testGetProducts() {
        assertThat(proDAO.getProducts(), hasItem(pro1));
        assertThat(proDAO.getProducts(), hasItem(pro2));
        assertThat(proDAO.getProducts(), hasSize(2));
    }

    @Test
    public void testRemoveProduct() {
        assertThat(proDAO.getProducts(), hasSize(2));
        proDAO.removeProduct(pro1);
        assertThat(proDAO.getProducts(), not(hasItem(pro1)));
        assertThat(proDAO.getProducts(), hasSize(1));
    }

    @Test
    public void testGetCategories() {
        assertThat(proDAO.getCategories(), hasItem(pro1.getCategory()));
        assertThat(proDAO.getCategories(), hasItem(pro2.getCategory()));
    }

}
