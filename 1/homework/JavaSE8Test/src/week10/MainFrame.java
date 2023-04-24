//package week10;
//
//
//import java.util.Scanner;
//
//
///*系统界面类的实现
//*功能:启动该类，为用户提供五个选项，通过选择不同的选项进行相应的操作
//*    1:查看歌单
//*    2:添加歌去
//*    3:搜索歌曲
//*    4:删除歌曲
//*    0:退出系统
//*/
//public class MainFrame {
//   //创建歌单对象
//   MusicList musicList;
//   //构造器
//   public MainFrame() {
//       musicList = new MusicList();
//       initFrame();
//   }
//   //初始化界面
//   public void initFrame() {
//       System.out.println("=================欢迎使用MUSIC系统=================");
//       System.out.println();
//       //while循环系统一直可以操作，知道输入0
//       while(true) {
//           System.out.print("1:查看歌单"+"  ");
//           System.out.print("2:添加歌曲"+"  ");
//           System.out.print("3:查询歌曲"+"  ");
//           System.out.print("4:删除歌曲"+"  ");
//           System.out.println("0:退出    ");    
//           System.out.println();
//           System.out.println("请选择你要执行的操作");
//           //匿名类创建键盘输入对象 ，获取键盘输入
//           int input = new  Scanner(System.in).nextInt();
//           switch(input) {
//           case 1:
//               //调用查看歌单方法
//               System.out.println("*********************查看歌单*********************");
//               musicList.musicPrint();
//               System.out.println("================================================");
//               break;
//           case 2:
//               //调用添加歌曲方法
//               System.out.println("*********************添加歌曲*********************");
//               musicList.musicAdd();
//               System.out.println("================================================");
//               break;
//           case 3:
//               //调用查询歌曲方法
//               System.out.println("*********************查询歌曲*********************");
//               musicList.searchMusic();
//               System.out.println("================================================");
//               break;
//           case 4:
//               //调用删除歌曲方法
//               System.out.println("*********************删除歌曲*********************");
//               System.out.println("输入要删除的歌曲名称");
//               //匿名类和创建键盘输入对象
//               String name = new Scanner(System.in).next();
//               musicList.delete(name);
//               System.out.println("================================================");
//               break;
//           case 0:
//               System.out.println("******************欢迎下次使用,再见！****************");
//               return;
//           default :
//               System.out.println("！！！！！！！输入序号有误，重新选择！！！！！！");
//               break;
//           }
//       }
//   }
//}