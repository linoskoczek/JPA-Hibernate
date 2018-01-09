package management;

import hibernate.CustomerEntity;
import hibernate.HibernateUtil;
import hibernate.VipCustomerEntity;
import org.hibernate.Session;

public class VipCustomerRepository {
    public static VipCustomerEntity createVIPCustomer(CustomerEntity customerEntity) {
        VipCustomerEntity vip = new VipCustomerEntity();
        vip.setIdCustomer(customerEntity.getId());
        vip.setDiscountRate(10);
        return vip;
    }
}