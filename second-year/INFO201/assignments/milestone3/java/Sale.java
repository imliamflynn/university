package java;
/**
 * Sale.
 * @author liamflynn
 */
public class Sale {
    
    private Customer customer;
    
    private Integer saleID;
    private String saleDateTime;
    private String addressNumber;
    private Boolean giftWrap;
    private String storeDelivery;
    private Integer gst;
    private String status;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getSaleID() {
        return saleID;
    }

    public void setSaleID(Integer saleID) {
        this.saleID = saleID;
    }

    public String getSaleDateTime() {
        return saleDateTime;
    }

    public void setSaleDateTime(String saleDateTime) {
        this.saleDateTime = saleDateTime;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public Boolean getGiftWrap() {
        return giftWrap;
    }

    public void setGiftWrap(Boolean giftWrap) {
        this.giftWrap = giftWrap;
    }

    public String getStoreDelivery() {
        return storeDelivery;
    }

    public void setStoreDelivery(String storeDelivery) {
        this.storeDelivery = storeDelivery;
    }

    public Integer getGst() {
        return gst;
    }

    public void setGst(Integer gst) {
        this.gst = gst;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
