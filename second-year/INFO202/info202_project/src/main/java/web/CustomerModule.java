package web;

import domain.Customer;
import dao.CustomerJdbiDAO;
import io.jooby.Jooby;
import io.jooby.StatusCode;

/**
 *
 * @author liamflynn
 */
public class CustomerModule extends Jooby {

    public CustomerModule(CustomerJdbiDAO dao) {
        get("/api/customers/{username}", ctx -> {
            String username = ctx.path("username").value();
            Customer cust = dao.getCustomer(username);
            
            if (cust == null){
                return ctx.send(StatusCode.NOT_FOUND);
            }else{
                return cust;
            }
        });

        
        post("/api/register", ctx -> {
            Customer customer = ctx.body().to(Customer.class);
            dao.saveCustomer(customer);
            return ctx.send(StatusCode.CREATED);
        });
    }
}
