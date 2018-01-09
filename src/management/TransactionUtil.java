package management;

import hibernate.HibernateUtil;

public class TransactionUtil {
    public static void beginTransaction() {
        HibernateUtil.getSession().beginTransaction();
    }

    public static void commitTransaction() {
        HibernateUtil.getSession().getTransaction().commit();
    }

    public static void rollbackTransaction() {
        HibernateUtil.getSession().getTransaction().rollback();
    }
}
