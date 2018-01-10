package management;

import hibernate.CustomerEntity;
import hibernate.VipCustomerEntity;
import org.hibernate.query.Query;

import java.util.List;

public class VipCustomerRepository extends Repository {
    public static VipCustomerEntity createVipCustomer(CustomerEntity customerEntity) {
        return createVipCustomer(customerEntity.getId());
    }

    public static VipCustomerEntity createVipCustomer(int customerId) {
        return createVipCustomer(customerId, 0);
    }

    public static VipCustomerEntity createVipCustomer(int customerId, int discount) {
        int vipId = getVipIdByCustomerId(customerId);
        if(vipId == -1) {
            VipCustomerEntity vip = new VipCustomerEntity();
            vip.setIdCustomer(customerId);
            vip.setDiscountRate(discount);
            session.save(vip);
            return vip;
        }
        else {
            VipCustomerEntity vip =  session.get(VipCustomerEntity.class, vipId);
            vip.setDiscountRate(discount);
            session.save(vip);
            return vip;
        }

    }

    public static boolean checkIfVip(int customerId) {
        boolean isVip = false;

        long sumOfOrderValues = OrdrRepository.getSumOfOrderValues(customerId);

        if(sumOfOrderValues >= 1000) {
            isVip = true;

            if(sumOfOrderValues >= 5000) //10% discount
                createVipCustomer(customerId, 10);

            else                         //5% discount
                createVipCustomer(customerId, 5);

        }

        return isVip;
    }

    public static void removeVipByCustomerId(int customerId) {
        int vipId = getVipIdByCustomerId(customerId);
        removeVip(vipId);
    }

    public static void removeVip(int id) {
        VipCustomerEntity vip =  session.get(VipCustomerEntity.class, id);
        removeVip(vip);
    }

    public static void removeVip(VipCustomerEntity vip) {
        if(vip != null) {
            session.delete(vip);
            session.save(vip);
        }
    }

    public static int getVipIdByCustomerId(int customerId) {
        try {
            Query query = session
                    .createQuery("SELECT id FROM VipCustomerEntity WHERE idCustomer = :customerId")
                    .setParameter("customerId", customerId);

            List list = query.list();
            return (int) list.get(0);
        }
        catch(IndexOutOfBoundsException ignored) {
            return -1;
        }
    }
}
