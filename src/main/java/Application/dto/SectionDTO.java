package Application.dto;

import Application.model.Product;
import Application.model.StoreSection;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


public class SectionDTO implements Serializable {

    private int id;

    private Optional<List<Product>> products;

    private StoreSection name;


    @NotNull(message = "The name cannot be null")
    @Pattern(regexp = "\\d", message = "Does not match the pattern")
    @Size(min = 10, max = 50, message = "Nope")
    private String productName;

    public SectionDTO() {}

    public SectionDTO(final int id, final StoreSection sectionName,  final Optional<List<Product>> products) {
        this.id = id; this.name = sectionName; this.products = products;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StoreSection getStoreSection() {
        return name;
    }

    public  Optional<List<Product>> getProducts(){
        return products;
    }
    public void setProducts(Optional<List<Product>> products){
        this.products = Optional.of(new ArrayList<Product>(products.get()));}


/*
    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {this.sectionId = sectionId;}
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SectionDTO)) return false;
        SectionDTO that = (SectionDTO) o;
        return id == that.id &&
                Objects.equals(productName, that.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName);
    }
}
