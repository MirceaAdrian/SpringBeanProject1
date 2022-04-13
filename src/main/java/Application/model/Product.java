package Application.model;

import java.text.DecimalFormat;
import java.util.Objects;

public class Product extends AbstractEntity {

    private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("####.##");

    private final int id;
    private final String name;
    private final double price;
    private final int sectionId;



    public Product(final int id, final String name, final double price,final int sectionId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sectionId = sectionId;

    }

    public int getId() {
        return id;
    }

    public int getSectionId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id == product.id &&
                Objects.equals(name, product.name) &&
                Objects.equals(price, product.price) &&
                Objects.equals(sectionId,product.sectionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Product: {");

        sb.append("id: ").append(id);
        sb.append(", name: '").append(name).append('\'');
        sb.append(", \tprice: ").append(DECIMAL_FORMAT.format(price));
        sb.append(", \tsectionId: ").append(sectionId);
        sb.append('}');

        return sb.toString();
    }
}
