package hibernate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Customer", schema = "assignment11", catalog = "")
public class CustomerEntity {
    private int id;
    private String name;
    private Collection<OrdrEntity> ordrsById;
    private Collection<OrdrEntity> ordrsById_0;
    private Collection<VipCustomerEntity> vipCustomersById;
    private Collection<VipCustomerEntity> vipCustomersById_0;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<OrdrEntity> getOrdrsById() {
        return ordrsById;
    }

    public void setOrdrsById(Collection<OrdrEntity> ordrsById) {
        this.ordrsById = ordrsById;
    }

    @OneToMany(mappedBy = "customerByCustomerId_0")
    public Collection<OrdrEntity> getOrdrsById_0() {
        return ordrsById_0;
    }

    public void setOrdrsById_0(Collection<OrdrEntity> ordrsById_0) {
        this.ordrsById_0 = ordrsById_0;
    }

    @OneToMany(mappedBy = "customerByIdCustomer")
    public Collection<VipCustomerEntity> getVipCustomersById() {
        return vipCustomersById;
    }

    public void setVipCustomersById(Collection<VipCustomerEntity> vipCustomersById) {
        this.vipCustomersById = vipCustomersById;
    }

    @OneToMany(mappedBy = "customerByIdCustomer_0")
    public Collection<VipCustomerEntity> getVipCustomersById_0() {
        return vipCustomersById_0;
    }

    public void setVipCustomersById_0(Collection<VipCustomerEntity> vipCustomersById_0) {
        this.vipCustomersById_0 = vipCustomersById_0;
    }
}
