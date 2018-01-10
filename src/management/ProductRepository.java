package management;

import hibernate.ProductEntity;

public class ProductRepository extends Repository {
    public static ProductEntity createProduct(String name, int price) {
        ProductEntity product = new ProductEntity();
        product.setName(name);
        product.setPrice(price);
        session.save(product);

        return product;
    }
}
