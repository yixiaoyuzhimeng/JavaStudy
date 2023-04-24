package cdu.yxy.app2.bean;
import java.io.Serializable;
public class Candidate implements Serializable {
    private  int id;
    private String name;
    private int votes;
    private String photoUrl;
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
    public int getVotes() {
        return votes;
    }
    public void setVotes(int votes) {
        this.votes = votes;
    }
    public String getPhotoUrl() {
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
    @Override
    public String toString() {
        return id+" "+name+" "+votes+" "+photoUrl;
    }
}
