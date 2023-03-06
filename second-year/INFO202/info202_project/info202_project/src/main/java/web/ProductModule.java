package web;

import io.jooby.Jooby;
import dao.ProductDAO;
import dao.ProductJdbiDAO;


/**
 *
 * @author liamflynn
 */
public class ProductModule extends Jooby{
    
    public ProductModule(ProductJdbiDAO dao){
        get("/api/products", ctx -> dao.getProducts());

        get("/api/products/{id}", ctx -> {
            String id = ctx.path("id").value();
            return dao.searchByID(id);
        });
        
        get("/api/categories", ctx -> dao.getCategories());
        
        get("/api/categories/{category}", ctx -> {
            String category = ctx.path("category").value();
            return dao.filterByCategory(category);
        });
    }
    
}
