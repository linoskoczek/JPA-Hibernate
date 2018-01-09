package management;

import hibernate.CustomerEntity;
import hibernate.OrdrEntity;
import hibernate.OrdrItemEntity;
import hibernate.ProductEntity;

import java.sql.Timestamp;

public class OrdrRepository {
    public static OrdrEntity createOrder(CustomerEntity customer) {
        OrdrEntity order = new OrdrEntity();
        order.setDate(new Timestamp(System.currentTimeMillis()));
        order.setCustomerId(customer.getId());

        return order;
    }

    public static OrdrItemEntity addItemToOrder(OrdrEntity order, ProductEntity product, int count) {
        OrdrItemEntity item = new OrdrItemEntity();
        item.setOrderId(order.getId());
        item.setProductId(product.getId());
        item.setCount(count);

        return item;
    }
}
