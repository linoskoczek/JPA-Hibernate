package management;

import hibernate.CustomerEntity;
import hibernate.HibernateUtil;
import hibernate.VipCustomerEntity;
import org.hibernate.Session;

public class VipCustomerRepository extends Repository {
    public static VipCustomerEntity createVipCustomer(CustomerEntity customerEntity) {
        return createVipCustomer(customerEntity.getId());
    }

    public static VipCustomerEntity createVipCustomer(int customerId) { // todo dont create new vip customer, check if already exists
        return createVipCustomer(customerId, 0);
    }

    public static VipCustomerEntity createVipCustomer(int customerId, int discount) {
        VipCustomerEntity vip = new VipCustomerEntity();
        vip.setIdCustomer(customerId);
        vip.setDiscountRate(discount);
        session.save(vip);
        return vip;
    }

    public static boolean checkIfVip(int customerId) {
        Session session = HibernateUtil.getSession();
        boolean isVip = false;

        long sumOfOrderValues = OrdrRepository.getSumOfOrderValues(customerId);

        if(sumOfOrderValues >= 1000) {
            isVip = true;

            if(sumOfOrderValues >= 5000) //10% discount
                createVipCustomer(customerId, 10);

            else                         //5% discount
                createVipCustomer(customerId, 5);

        }
        //todo else to check if have to remove him
        return isVip;
    }
}
