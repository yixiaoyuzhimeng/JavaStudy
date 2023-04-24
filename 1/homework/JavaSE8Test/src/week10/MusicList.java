//package week10;
//
//
//import java.util.Scanner;
// 
// 
///*歌单类
// *属性:歌曲数组
// *功能:查看歌单 查询歌曲 删除歌曲 添加歌曲
// */
//public class MusicList {
//    // 定义歌曲数组
//    Music[] musicsArray;
// 
//    public MusicList() {
//        // 实例化歌曲数组
//        musicsArray = new Music[5];
//        // 调用初始化方法
//        initMusicArray();
//    }
// 
//    // 私有的方法初始化歌单
//    private void initMusicArray() {
//        // 构造方法实例化一个对象，然后添加到数组
//        Music music1 = new Music("忽如远行客", "云泣", 342.0);
//        musicsArray[0] = music1;
//        Music music2 = new Music("长歌行", "i2star", 431.0);
//        musicsArray[1] = music2;
//    }
// 
//    // 歌单打印
//    public void musicPrint() {
//        // 遍历数组
//        for (int i = 0; i < musicsArray.length; i++) {
//            Music music = musicsArray[i];
//            if (music != null) {
//                System.out.println(music);
//            }
//        }
//    }
// 
//    // 删除歌曲
//    public void delete(String name) {
//        // 遍历数组
//        for (int i = 0; i < musicsArray.length; i++) {
//            // 当前位置对象
//            Music music = musicsArray[i];
//            // 判断当前歌曲对象不为空并且歌名等于输入的歌名
//            if (music != null && music.getName().equals(name)) {
//                // 将状态设置为true
//                music.setDelete(true);
//                // 清空当前位置的
//                musicsArray[i] = null;
//                System.out.println("歌曲:" + music.getName() + "删除成功");
//                return;
//            }
//        }
//        System.out.println("不存在此歌曲信息");
//    }
// 
//    // 添加歌曲
//    public void musicAdd() {
//        System.out.println("请输入歌曲名称");
//        String musicName = new Scanner(System.in).next();
//        System.out.println("请输入演唱者");
//        String musicPlayer = new Scanner(System.in).next();
//        System.out.println("请输入歌曲时长");
//        double musicPayer = new Scanner(System.in).nextDouble();
//        // 封装对象
//        Music music = new Music(musicName, musicPlayer, musicPayer);
//        // 调用对象添加方法
//        boolean b = add(music);
//        // 判断b
//        if (b) {
//            System.out.println("添加成功");
//        } else {
//            System.out.println("添加失败");
//        }
// 
//    }
// 
//    // 添加歌曲对象
//    public boolean add(Music music) {
//        // 调用索引方法查看空索引
//        int index = searchEmptyIndex();
//        // 找到空索引
//        if (index != -1) {
//            musicsArray[index] = music;
//            return true;
//        }
//        return false;
//    }
// 
//    // 搜索歌曲
//    public void searchMusic() {
//        System.out.println("输入要查寻的歌名");
//        String songName  = new Scanner(System.in).next();
//        // 遍历数组
//        for (int i = 0; i < musicsArray.length; i++) {
//            // 获得数组当前位置元素
//            Music music = musicsArray[i];
//            // 不为空并且歌曲名字想同就返回
//            if (music != null && music.getName().equals(songName)) {
//                //打印歌曲信息
//                System.out.println(music);
//                return;
//            }
//        }
//        System.out.println("歌曲搜索失败");
//    }
// 
//    // 查询索引
//    private int searchEmptyIndex() {
//        for (int i = 0; i < musicsArray.length; i++) {
//            Music music = musicsArray[i];
//            // 当前位置为空，返回当前下标，用来把保存新的歌曲对象
//            if (music == null) {
//                return i;
//            }
//        }
//        return -1;
//    }
// 
//}
// 