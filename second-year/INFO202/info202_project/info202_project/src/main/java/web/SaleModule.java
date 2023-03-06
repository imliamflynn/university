package web;

import io.jooby.Jooby;
import domain.Sale;
import dao.SaleJdbiDAO;
import io.jooby.StatusCode;

/**
 *
 * @author liamflynn
 */
public class SaleModule extends Jooby{
    
    public SaleModule(SaleJdbiDAO dao){
        post("/api/sales", ctx -> {
           Sale sale = ctx.body().to(Sale.class);
           System.out.println(sale);
           dao.save(sale);
           return ctx.send(StatusCode.CREATED);
        });
    }
}
