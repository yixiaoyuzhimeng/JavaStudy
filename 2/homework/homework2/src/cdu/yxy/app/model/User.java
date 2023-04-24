package cdu.yxy.app.model;

public class User {
    private int id;
    private String name;
    private String password;
    private String sex;
    private String hobby;

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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{"+"id="+id+
                ",name='"+name+'\''+
                ",password="+password+'\''+
                ",sex="+sex+'\''+
                ",hobby='"+hobby+'\''+
                "}";
    }
}
