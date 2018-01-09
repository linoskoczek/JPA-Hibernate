package management;

import hibernate.ProductEntity;

public class ProductRepository {
    public static ProductEntity createProduct(String name) {
        ProductEntity product = new ProductEntity();
        product.setName(name);

        return product;
    }
}
