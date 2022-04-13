package Application.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

public class ProductDTO implements Serializable {

    private int id,sectionId;

    private double price;

    @NotNull(message = "The name cannot be null")
    @Pattern(regexp = "\\d", message = "Does not match the pattern")
    @Size(min = 10, max = 50, message = "Nope")
    private String productName;

    public ProductDTO() {}

    public ProductDTO(final int id, final String productName, final double price,final int sectionId) {
        this.id = id; this.productName = productName;this.price = price; this.sectionId = sectionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {this.sectionId = sectionId;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDTO)) return false;
        ProductDTO that = (ProductDTO) o;
        return id == that.id &&
                Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName);
    }
}
