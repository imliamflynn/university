/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liamflynn
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class Invoice {

    private String customerName;
    private String customerAddress;
    private LocalDate date;

    private static Collection<InvoiceItem> items = new ArrayList<>();

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Collection<InvoiceItem> getItems() {
        return items;
    }

    public void addItem(InvoiceItem itemToAdd) {
        items.add(itemToAdd);
    }

    public void removeItem(InvoiceItem itemToAdd) {
        items.remove(itemToAdd);
    }

    public Double getTotal() {
        return items.stream().mapToDouble(item -> item.getItemTotal()).sum();
    }

}
