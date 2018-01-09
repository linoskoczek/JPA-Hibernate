package management;

import hibernate.CustomerEntity;
import hibernate.HibernateUtil;
import org.hibernate.Session;

public class CustomerRepository {
    public static CustomerEntity createCustomer(String name) {
        CustomerEntity customer = new CustomerEntity();
        customer.setName(name);
        return customer;
    }
}
