package hibernate;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "Product", schema = "assignment11", catalog = "")
public class ProductEntity {
    private int id;
    private String name;
    private int price;
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
    @Column(name = "name")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
        ProductEntity that = (ProductEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<OrdrItemEntity> getOrdrItemsById() {
        return ordrItemsById;
    }

    public void setOrdrItemsById(Collection<OrdrItemEntity> ordrItemsById) {
        this.ordrItemsById = ordrItemsById;
    }

    @OneToMany(mappedBy = "productByProductId_0")
    public Collection<OrdrItemEntity> getOrdrItemsById_0() {
        return ordrItemsById_0;
    }

    public void setOrdrItemsById_0(Collection<OrdrItemEntity> ordrItemsById_0) {
        this.ordrItemsById_0 = ordrItemsById_0;
    }
}
