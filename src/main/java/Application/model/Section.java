package Application.model;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Section extends AbstractEntity {

    private final int id;
    private final StoreSection name;
    private final Optional<List<Product>> products;

    public Section(final int id, final StoreSection name, final Optional<List<Product>> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public StoreSection getStoreSection() {
        return name;
    }

    public Optional<List<Product>> getProducts() {
        return products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Section)) return false;
        Section that = (Section) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
