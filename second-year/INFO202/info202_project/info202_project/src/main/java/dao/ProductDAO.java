/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import domain.Product;
import java.util.Collection;

/**
 *
 * @author liamflynn
 */
public interface ProductDAO {

    Collection<Product> filterByCategory(String c);

    Collection<String> getCategories();

    Collection<Product> getProducts();

    void removeProduct(Product p);

    void saveProduct(Product p);

    Product searchByID(String productID);
    
}
