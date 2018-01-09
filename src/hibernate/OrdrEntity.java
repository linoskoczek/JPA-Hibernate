package hibernate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Ordr", schema = "assignment11", catalog = "")
public class OrdrEntity {
    private int id;
    private int customerId;
    private Timestamp date;
    private CustomerEntity customerByCustomerId;
    private CustomerEntity customerByCustomerId_0;
    private Collection<OrdrItemEntity> ordrItemsById;
    private Collection<OrdrItemEntity> ordrItemsById_0;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdrEntity that = (OrdrEntity) o;
        return id == that.id &&
                customerId == that.customerId &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, customerId, date);
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    public CustomerEntity getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(CustomerEntity customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    public CustomerEntity getCustomerByCustomerId_0() {
        return customerByCustomerId_0;
    }

    public void setCustomerByCustomerId_0(CustomerEntity customerByCustomerId_0) {
        this.customerByCustomerId_0 = customerByCustomerId_0;
    }

    @OneToMany(mappedBy = "ordrByOrderId")
    public Collection<OrdrItemEntity> getOrdrItemsById() {
        return ordrItemsById;
    }

    public void setOrdrItemsById(Collection<OrdrItemEntity> ordrItemsById) {
        this.ordrItemsById = ordrItemsById;
    }

    @OneToMany(mappedBy = "ordrByOrderId_0")
    public Collection<OrdrItemEntity> getOrdrItemsById_0() {
        return ordrItemsById_0;
    }

    public void setOrdrItemsById_0(Collection<OrdrItemEntity> ordrItemsById_0) {
        this.ordrItemsById_0 = ordrItemsById_0;
    }
}
