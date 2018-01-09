package test;

import hibernate.*;
import org.hibernate.Session;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class TestBasics {
    Session session;
    CustomerEntity customer;
    List<ProductEntity> products = new ArrayList<>();
    List<OrdrItemEntity> items = new ArrayList<>();
    OrdrEntity ordr;
    Random random = new Random();

    @Before
    public void prepare() {
        session = HibernateUtil.getSession();
        session.beginTransaction();
    }

}
