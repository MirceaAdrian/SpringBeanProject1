package Application.service;

import Application.model.Product;
import Application.dto.ProductDTO;
import Application.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void create(final ProductDTO productDTO) {
        productRepository.create(getDTOConverter().apply(productDTO));
    }

    public ProductDTO get(final int id) {
        final Product product =
                Optional.ofNullable(productRepository.get(id))
                        .orElseThrow(() -> new IllegalArgumentException("There is no product with the id " + id));

        return getProductConverter().apply(product);
    }

    public List<ProductDTO> getBySectionId(final int sectionId) {

        return productRepository.getBySectionId(sectionId)
                                .parallelStream()
                                .map(getProductConverter())
                                .collect(Collectors.toList());
    }

    public List<ProductDTO> getAll() {
        return productRepository.getAll()
                                .parallelStream()
                                .map(getProductConverter())
                                .collect(Collectors.toList());
    }

    public void update(final int id, final ProductDTO productDTO) {
        productRepository.update(id, getDTOConverter().apply(productDTO));
    }

    public void delete(final int id) {
        productRepository.delete(id);
    }

    private Function<ProductDTO, Product> getDTOConverter() {
        return dto -> new Product(dto.getId(), dto.getProductName(), dto.getPrice(),dto.getSectionId());
    }

    private Function<Product, ProductDTO> getProductConverter() {
        return product -> new ProductDTO(product.getId(), product.getName(),product.getPrice(),product.getSectionId());
    }

    private Predicate<Product> filterItem() {
        return product -> product.getName().isEmpty() || product.getId() > 20;
    }
}
