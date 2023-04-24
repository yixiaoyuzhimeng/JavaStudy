package cdu.yxy.app.model;
import java.io.Serializable;
public class CartItem implements Serializable {
    private int id;
    private int customerId;
    private int productId;
    private int productNum;//number
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getProductNum() {
        return productNum;
    }
    public void setProductNum(int productNum) {
        this.productNum = productNum;
    }

    @Override
    public String toString() {
        return "CartItem{"+
                "id="+id+
                ",customerId="+customerId+
                ",productId="+productId+
                ",productNum="+productNum+"}";
    }
}
