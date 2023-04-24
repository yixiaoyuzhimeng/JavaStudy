package cdu.yxy.app.model;
import java.io.Serializable;
public class Customer implements Serializable {
    private int id;
    private String name;
    private String password;
    private Boolean isVip;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean isVip() {
        return isVip;
    }
    public void setVip(Boolean vip) {
        isVip = vip;
    }
    @Override
    public String toString() {
        return "User:"+id+","
                +name+","
                +password+","
                +isVip;
    }
}
