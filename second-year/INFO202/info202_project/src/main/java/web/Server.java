package web;

import dao.CustomerJdbiDAO;
import dao.ProductJdbiDAO;
import dao.JdbiDaoFactory;
import dao.SaleJdbiDAO;
import io.jooby.Jooby;
import io.jooby.ServerOptions;
import io.jooby.json.GsonModule;

  /**      
 *
 * @author liamflynn
 */
public class Server extends Jooby {

    ProductJdbiDAO productDao = JdbiDaoFactory.getProductDAO();
    CustomerJdbiDAO customerDao = JdbiDaoFactory.getCustomerDAO();
    SaleJdbiDAO saleDao = JdbiDaoFactory.getSaleDAO();

    public Server() {
        setServerOptions(new ServerOptions().setPort(8080));
        install(new GsonModule());
        mount(new ProductModule(productDao));
        mount(new CustomerModule(customerDao));
        mount(new SaleModule(saleDao));
        mount(new StaticAssetModule());
    }

    public static void main(String[] args) throws Exception {
        System.out.println("\nStarting Server.");
        new Server().start();
    }

}
