package test;

import hibernate.CustomerEntity;
import hibernate.HibernateUtil;
import hibernate.VipCustomerEntity;
import management.CustomerRepository;
import management.VipCustomerRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
    private Session session;
    private CustomerEntity customer;

    @Before
    public void prepare() {
        session = HibernateUtil.getSession();
        session.beginTransaction();
    }

    @After
    public void close() {
        session.getTransaction().rollback();
    }

    @Test
    public void addCustomer() {
        customer = CustomerRepository.createCustomer("Janusz");
        session.save(customer);

        Query idQuery = session.createQuery("SELECT id FROM CustomerEntity WHERE name = 'Janusz'");
        int id = (int) idQuery.list().get(0);

        Assert.assertEquals(session.createQuery("FROM CustomerEntity").list().size(), 1);
        Assert.assertEquals(id, customer.getId());
    }

    @Test
    public void addVipCustomer() {
        addCustomer();
        VipCustomerEntity vip = VipCustomerRepository.createVIPCustomer(customer);
        session.save(vip);

        Query idQuery = session.createQuery("SELECT id FROM CustomerEntity WHERE name = 'Janusz'");
        int id = (int) idQuery.list().get(0);

        Assert.assertEquals(id, vip.getIdCustomer());
        Assert.assertEquals(session.createQuery("FROM VipCustomerEntity").list().size(), 1);
    }
}
