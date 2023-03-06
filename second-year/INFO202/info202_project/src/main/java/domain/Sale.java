package domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author liamflynn
 */
public class Sale {
    private Integer saleID; //<<unique>> <<generated>>
    private LocalDateTime date;
    private String status;
    private Customer customer;
    private Collection<SaleItem> items = new ArrayList<SaleItem>();
    
    @Override
    public String toString() {
        return "Sale{" + "saleID=" + saleID + ", date=" + date + ", status=" + status + ", customer=" + customer + ", items=" + items + '}';
    }
    
    public BigDecimal getTotal(){
        BigDecimal total = new BigDecimal("0");
        for (SaleItem s: items){
            total = total.add(s.getItemTotal());
        }
        return total;
    }
    
    public void addItem(SaleItem saleItem){
        items.add(saleItem);
    }

    public Integer getSaleID() {
        return saleID;
    }

    public void setSaleID(Integer saleID) {
        this.saleID = saleID;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Collection<SaleItem> getItems() {
        return items;
    }

    public void setItems(Collection<SaleItem> items) {
        this.items = items;
    }
    
}
