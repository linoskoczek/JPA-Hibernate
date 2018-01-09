package hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "OrdrItem", schema = "assignment11", catalog = "")
public class OrdrItemEntity {
    private int id;
    private Integer orderId;
    private Integer productId;
    private Integer count;
    private OrdrEntity ordrByOrderId;
    private OrdrEntity ordrByOrderId_0;
    private ProductEntity productByProductId;
    private ProductEntity productByProductId_0;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "order_id")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "product_id")
    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdrItemEntity that = (OrdrItemEntity) o;
        return id == that.id &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(productId, that.productId) &&
                Objects.equals(count, that.count);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, orderId, productId, count);
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    public OrdrEntity getOrdrByOrderId() {
        return ordrByOrderId;
    }

    public void setOrdrByOrderId(OrdrEntity ordrByOrderId) {
        this.ordrByOrderId = ordrByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    public OrdrEntity getOrdrByOrderId_0() {
        return ordrByOrderId_0;
    }

    public void setOrdrByOrderId_0(OrdrEntity ordrByOrderId_0) {
        this.ordrByOrderId_0 = ordrByOrderId_0;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    public ProductEntity getProductByProductId_0() {
        return productByProductId_0;
    }

    public void setProductByProductId_0(ProductEntity productByProductId_0) {
        this.productByProductId_0 = productByProductId_0;
    }
}
