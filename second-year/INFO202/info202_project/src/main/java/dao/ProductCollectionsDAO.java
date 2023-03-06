package dao;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import domain.Product;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *
 * @author liamflynn
 */
public class ProductCollectionsDAO implements ProductDAO{

    private static Collection<Product> products = new HashSet<Product>();
    private static Collection<String> categories = new HashSet<String>();
    private static Map<String, Product> productIDs = new HashMap<String, Product>();
    private static Multimap<String, Product> productCats = ArrayListMultimap.create();

    @Override
    public Collection<Product> filterByCategory(String c){
        return productCats.get(c);
    }
    
    @Override
    public Product searchByID(String productID) {
        if (productIDs.containsKey(productID)) {
            Product p = productIDs.get(productID);
            return p;
        } else {
            return null;
        }
    }

    @Override
    public Collection<String> getCategories() {
        return categories;
    }

    @Override
    public void saveProduct(Product p) {
        products.add(p);
        categories.add(p.getCategory());
        productIDs.put(p.getProductID(), p);
        productCats.put(p.getCategory(), p);
    }

    @Override
    public Collection<Product> getProducts() {
        return products;
    }

    @Override
    public void removeProduct(Product p) {
        products.remove(p);
        productIDs.remove(p.getProductID());
        productCats.remove(p.getCategory(), p);
    }
}
