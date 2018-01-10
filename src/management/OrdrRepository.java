package management;

import hibernate.*;

import java.sql.Timestamp;
import java.util.List;

public class OrdrRepository extends Repository {
    public static OrdrEntity createOrder(CustomerEntity customer) {
        OrdrEntity order = new OrdrEntity();
        order.setDate(new Timestamp(System.currentTimeMillis()));
        order.setCustomerId(customer.getId());
        session.save(order);

        return order;
    }

    public static OrdrItemEntity addItemToOrder(OrdrEntity order, ProductEntity product, int count) {
        OrdrItemEntity item = new OrdrItemEntity();
        item.setOrderId(order.getId());
        item.setProductId(product.getId());
        item.setCounter(count);
        session.save(item);

        VipCustomerRepository.checkIfVip(order.getCustomerId());

        return item;
    }

    public static long getSumOfOrderValues(int customerId) {
        //todo check only one year back
        long[] sum = {0};

        Timestamp oneYearBack = new Timestamp(System.currentTimeMillis() - ((long) 31556952 * 1000));

        List<Integer> allCustomersOrders = session
                .createQuery("SELECT id FROM OrdrEntity WHERE customerId = :cid AND date > :yearBack")
                .setParameter("yearBack", oneYearBack)
                .setParameter("cid", customerId).list();
        List<?> productsWithCounters;
        if(allCustomersOrders.size() > 0) {
            productsWithCounters = session.createQuery("SELECT productId as OrderedItemId,counter as Counter FROM OrdrItemEntity WHERE orderId IN (:lst)")
                    .setParameterList("lst", allCustomersOrders)
                    .list();

            productsWithCounters.forEach(p -> {
                Object[] row = (Object[]) p;
                int product = (int) row[0];
                int counter = (int) row[1];
                sum[0] += (int) session
                        .createQuery("SELECT :howMany * price FROM ProductEntity WHERE id = :productId")
                        .setParameter("howMany", counter)
                        .setParameter("productId", product).list().get(0);
            });
        }

        return sum[0];
    }
}
