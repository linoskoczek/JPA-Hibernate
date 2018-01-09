package hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "VIPCustomer", schema = "assignment11", catalog = "")
public class VipCustomerEntity {
    private int id;
    private int idCustomer;
    private int discountRate;
    private CustomerEntity customerByIdCustomer;
    private CustomerEntity customerByIdCustomer_0;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_customer")
    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Basic
    @Column(name = "discountRate")
    public int getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VipCustomerEntity that = (VipCustomerEntity) o;
        return id == that.id &&
                Objects.equals(idCustomer, that.idCustomer) &&
                Objects.equals(discountRate, that.discountRate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, idCustomer, discountRate);
    }

    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id")
    public CustomerEntity getCustomerByIdCustomer() {
        return customerByIdCustomer;
    }

    public void setCustomerByIdCustomer(CustomerEntity customerByIdCustomer) {
        this.customerByIdCustomer = customerByIdCustomer;
    }

    @ManyToOne
    @JoinColumn(name = "id_customer", referencedColumnName = "id")
    public CustomerEntity getCustomerByIdCustomer_0() {
        return customerByIdCustomer_0;
    }

    public void setCustomerByIdCustomer_0(CustomerEntity customerByIdCustomer_0) {
        this.customerByIdCustomer_0 = customerByIdCustomer_0;
    }
}
