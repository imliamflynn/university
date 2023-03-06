package domain;

import java.math.BigDecimal;
import java.util.Objects;
import net.sf.oval.constraint.Length;
import net.sf.oval.constraint.NotBlank;
import net.sf.oval.constraint.NotNegative;
import net.sf.oval.constraint.NotNull;

/**
 *
 * @author lenli455
 */
public class Product {

    private String productID; // <<unique>>
    @NotNull(message = "Name must be provided.")
    @NotBlank(message = "Name must be provided.")
    @Length(min = 2, message = "Name must contain at least two characters.")
    private String name;
    private String description;
    private String category;
    @NotNull(message = "Price must be provided.")
    @NotNegative(message = "Price must be zero or greater.")
    private BigDecimal listPrice;
    private BigDecimal quantityInStock;

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.productID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (!Objects.equals(this.productID, other.productID)) {
            return false;
        }
        return true;
    }

    
    
    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", name=" + name + '}';
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public BigDecimal getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(BigDecimal quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
