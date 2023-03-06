package dao;

import domain.Sale;
import domain.SaleItem;
import java.time.LocalDateTime;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.transaction.Transaction;

/**
 *
 * @author liamflynn
 */
public interface SaleJdbiDAO extends SaleDAO {

    @SqlUpdate("INSERT INTO SALE (CUSTOMER_ID, DATE, STATUS) VALUES (:customer.customerID, :date, :status)")
    @GetGeneratedKeys
    Integer insertSale(@BindBean Sale sale);

    @SqlUpdate("INSERT INTO SALE_ITEM (QUANTITY_PURCHASED, PRODUCT_ID, SALE_ID, SALE_PRICE) VALUES (:quantityPurchased, :product.productID, :saleID, :salePrice)")
    void insertSaleItem(@BindBean SaleItem item, @Bind("saleID") Integer saleId);

    @SqlUpdate("UPDATE INTO PRODUCT (QUANTITY_PURCHASED, PRODUCT_ID, SALE_ID, SALE_PRICE) VALUES (:quantityPurchased, :product.productID, :saleID, :salePrice)")
    void updateStockLevel(@BindBean SaleItem item);

    @Override
    @Transaction
    default void save(Sale sale) {
        // save current date
        sale.setDate(LocalDateTime.now());

        // set sale status
        sale.setStatus("NEW ORDER");

        // call the insertSale method, and get the generated sale ID.
        Integer saleId = insertSale(sale);
        sale.setSaleID(saleId);

        // loop through the sale's items.
        for (SaleItem item : sale.getItems()) {
            insertSaleItem(item, saleId);
            updateStockLevel(item);
        }

    }
}