/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.ProductDAO;
import domain.Product;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.DialogFixture;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author liamflynn
 */
public class ProductEditorTest {
    private ProductDAO proDAO;
    private DialogFixture fixture;
    private Robot robot;
    
    @BeforeEach
    public void setUp(){
        robot = BasicRobot.robotWithNewAwtHierarchy();
        robot.settings().delayBetweenEvents(10);
        
        Collection<String> categories = new ArrayList<>();
        categories.add("Dairy");
        categories.add("Meat");
        categories.add("Vegetable");
        
        proDAO = mock(ProductDAO.class);
        
        when(proDAO.getCategories()).thenReturn(categories);
    }
    
    @AfterEach
    public void tearDown(){
        fixture.cleanUp();
    }
    
    @Test
    public void testSave(){
        ProductEditor dialog = new ProductEditor(null, true, proDAO);
        
        fixture = new DialogFixture(robot, dialog);
        fixture.show().requireVisible();
        fixture.click();
        
        fixture.textBox("txtID").enterText("1234");
        fixture.textBox("txtName").enterText("Chicken");
        fixture.comboBox("combCat").selectItem("Meat");
        fixture.textBox("txtPrice").enterText("9.99");
        fixture.textBox("txtStock").enterText("50");
        
        fixture.button("buttSave").click();
        
        ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(Product.class);
        
        verify(proDAO).saveProduct(argument.capture());
        
        Product savedProduct = argument.getValue();
        
        assertThat("Ensure the ID was saved", savedProduct, hasProperty("productID", equalTo("1234")));
        assertThat("Ensure the name was saved", savedProduct, hasProperty("name", equalTo("Chicken")));
        assertThat("Ensure the category was saved", savedProduct, hasProperty("category", equalTo("Meat")));
        assertThat("Ensure the price was saved", savedProduct, hasProperty("listPrice", equalTo(new BigDecimal("9.99"))));
        assertThat("Ensure the stock was saved", savedProduct, hasProperty("quantityInStock", equalTo(new BigDecimal("50"))));        
    }
}
