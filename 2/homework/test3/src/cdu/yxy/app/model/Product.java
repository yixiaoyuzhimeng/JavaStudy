package cdu.yxy.app.model;
import java.io.Serializable;
import java.math.BigDecimal;
public class Product implements Serializable {
    private int id;
    private String name;
    private BigDecimal price;
    private int sale;
    private long stock;
    private long marketDate;
    private String imgUrl;
    private String info;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BigDecimal getPrice() {
        return price;
    }
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    public int getSale() {
        return sale;
    }
    public void setSale(int sale) {
        this.sale = sale;
    }
    public BigDecimal getSalePrice(){
        return price.multiply(new BigDecimal(sale)).divide((new BigDecimal(100)));
    }
    public long getStock() {
        return stock;
    }
    public void setStock(long stock) {
        this.stock = stock;
    }
    public long getMarketDate() {
        return marketDate;
    }
    public void setMarketDate(long marketDate) {
        this.marketDate = marketDate;
    }
    public String getImgUrl() {
        return imgUrl;
    }
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    @Override
    public String toString() {
        return "Product:"+id+","+
                name+","+
                price+","+
                sale+","+
                stock+","+
                marketDate+","+
                imgUrl+","+
                info;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof  Product){
            return this.id==((Product)obj).getId();
        }
        return false;
    }
}
