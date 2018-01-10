package test;

import hibernate.ProductEntity;
import management.ProductRepository;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ProductTest extends CustomerTest {
    @Test
    public void addProducts() {
        ProductEntity product1 = ProductRepository.createProduct("Onion", 100);
        ProductEntity product2 = ProductRepository.createProduct("Garlic", 80);

        products.add(product1);
        products.add(product2);

        Query idQuery = session.createQuery("SELECT id FROM ProductEntity");
        List list = idQuery.list();

        Assert.assertEquals(session.createQuery("FROM ProductEntity").list().size(), 2);
        Assert.assertTrue(list.contains(product1.getId()));
        Assert.assertTrue(list.contains(product2.getId()));
    }
}
