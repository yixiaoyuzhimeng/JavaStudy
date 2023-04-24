package week10;


/*歌曲类
 *属性:
 *    歌名 歌手 歌曲时长
 *方法:
 *    toString打印信息方法
 *    以及set get访问方法
 *    方便实例化的构造方法
 *    
 */
public class Music {
    //歌名
    private String name;
    //歌手
    private String musicPlayer;
    //歌长
    private double musicTime;
    //标记歌曲的状态变量(由于数组定长 ，打标记的方法实现删除false默认正常true删除)
    private boolean isDelete;
    public Music() {
        this("","",0);
    }
    //带参数的构造方法
    public Music(String name,String player,double time) {
        this.name = name;
        this.musicPlayer = player;
        this.musicTime = time;
    }
    //set get方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMusicPlayer() {
        return musicPlayer;
    }
    public void setMusicPlayer(String musicPlayer) {
        this.musicPlayer = musicPlayer;
    }
    public double getMusicTime() {
        return musicTime;
    }
    public void setMusicTime(double musicTime) {
        this.musicTime = musicTime;
    }
    
    public boolean isDelete() {
        return isDelete;
    }
 
    public void setDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }
 
    //打印方法(歌名 歌手 歌长)
    @Override
    public String toString() {
        return "Music [name=" + name + ", musicPlayer=" + musicPlayer + ", musicTime=" + musicTime + "]";
    }
    
}