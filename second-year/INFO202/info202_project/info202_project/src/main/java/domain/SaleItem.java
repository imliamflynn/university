package domain;

import java.math.BigDecimal;

/**
 *
 * @author liamflynn
 */
public class SaleItem {
    private BigDecimal quantityPurchased;
    private BigDecimal salePrice;
    private Product product;
    
    @Override
    public String toString() {
        return "SaleItem{" + "quantityPurchased=" + quantityPurchased + ", salePrice=" + salePrice + ", product=" + product + '}';
    }
    
    public BigDecimal getItemTotal(){
        return salePrice.multiply(quantityPurchased);
    }

    public BigDecimal getQuantityPurchased() {
        return quantityPurchased;
    }
    public void setQuantityPurchased(BigDecimal quantityPurchased) {
        this.quantityPurchased = quantityPurchased;
    }

    public BigDecimal getSalePrice() {
        return salePrice;
    }
    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }
    
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
}
