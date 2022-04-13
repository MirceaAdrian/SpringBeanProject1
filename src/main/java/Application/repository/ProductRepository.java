package Application.repository;

import Application.bootstrap.ProductsSetup;
import Application.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class ProductRepository {

    // an in-memory list of products
    private final List<Product> products = ProductsSetup.getStartingItems();

    @PostConstruct
    public void init() {
        products.add(getDefaultProduct());
    }

    @SuppressWarnings("unused")
    public Product get(int id) {
        return products.stream().filter(new Predicate<Product>() {
            @Override
            public boolean test(Product product) {
                return product.getId() == id;
            }
        }).findFirst().get();
    }


    public List<Product> getAll() {
        return products;
    }

    public void create(final Product product) {
        products.add(product);
    }

    public void update(final int id, final Product product) {
        products.add(product);
    }

    public void delete(final int id) {
        products.remove(id < products.size() ? id : 0);
    }

    private Product getDefaultProduct() {
        return new Product(24, "Dell XPS 9360", 2000d,1);
    }

    public List<Product> getBySectionId(int sectionId) {
        return products.stream().filter(new Predicate<Product>() {
            @Override
            public boolean test(Product product) {
                return product.getSectionId() == sectionId;
            }
        }).toList();
    }

}
