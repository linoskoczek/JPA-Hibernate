package test;

import management.OrdrRepository;
import org.hibernate.query.Query;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class OrdrTest extends ProductTest {
    @Test
    public void addOrder() {
        addCustomer();
        ordr = OrdrRepository.createOrder(customer);
        session.save(ordr);

        Query idQuery = session.createQuery("SELECT id FROM OrdrEntity");
        int id = (int) idQuery.list().get(0);

        Assert.assertEquals(session.createQuery("FROM OrdrEntity").list().size(), 1);
        Assert.assertEquals(id, ordr.getId());
    }

    @Test
    public void addItemsToOrder() {
        addProducts();
        addOrder();

        items.add(OrdrRepository.addItemToOrder(ordr, products.get(0), random.nextInt(5)+1));
        items.add(OrdrRepository.addItemToOrder(ordr, products.get(1), random.nextInt(2)+1)); //todo adding same product twice
        session.save(items.get(0));
        session.save(items.get(1));

        Assert.assertEquals(session.createQuery("FROM OrdrItemEntity").list().size(), 2);

        Query idQuery = session.createQuery("SELECT id FROM OrdrItemEntity");
        List list = idQuery.list();
        
        Assert.assertTrue(list.contains(items.get(0).getId()));
        Assert.assertTrue(list.contains(items.get(1).getId()));
    }
}
