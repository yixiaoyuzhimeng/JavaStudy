//package week08;
//
///**
// * 
// * @author 依兮
// *利用多线程编写一个模拟时钟(AWT程序、Runnable接口)，
// *有时分秒针,
// *编写一个应用程序，
// *创建三个线程分别显示各自的时间。
// *
// */
//
//
//
//import guijiemian.MyFrame2;
//import guijiemian.MyFrame3;
//
//import java.awt.Frame;
//import java.awt.Label;
//import java.awt.Panel;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;
//import java.awt.event.WindowListener;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
// 
//
//public class Test2 extends Frame  {
//	private Panel p=null;
//	private Label l1=null;
//	private Label l2=null;
//	private Label l3=null;
//	
//	public Test2(){
//		init();
//	}
//	
//	public void init(){
//		
//		this.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				// TODO Auto-generated method stub
//				//super.windowClosing(arg0);
//				Test2.this.dispose();
//			}
//		});
//
//		p=new Panel();
//		l1=new Label("时");
//		l2=new Label("分");
//		l3=new Label("秒");
//		p.add(l1);
//		p.add(l2);
//		p.add(l3);
//		this.add(p);
//		
//		this.setBounds(100,100,400,200);
//		this.setVisible(true);
//	}
//	
//	public static void main(String[] args) {
//		
//		//布局电子时钟界面
//		Frame f=new Frame("Clock");
//		Label l1=new Label("时");
//		Label l2=new Label("分");
//		Label l3=new Label("秒");
//		ll.setHorizontalAlignment(JLabel.CENTER);
//		f.add(jl,"Center");
//		f.setSize(200,150);
//		f.setLocation(400,200);
//		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		f.setVisible(true);
//
//		//多线程开始
//		MyFrame m1 = new MyFrame(jl);
//		Thread t1=new Thread(t1);
//		MyFrame m2 = new MyFrame(j2);
//		Thread t2=new Thread(t2);
//		MyFrame m3 = new MyFrame(j3);
//		Thread t3=new Thread(t3);
//		t1.start();
//		t2.start();
//		t3.start();
//		
//	}
//
//	
//	
//}
//
//
//class MyFrame extends Frame implements WindowListener ,Runnable{
//	
//	private JLabel clock;
//	
//	public MyFrame(JLabel clock){
//		this.clock=clock;
//  	}
//	
//	public void start() {
//		
//	}
//	
//	public void run(){
//		while(true){
//			clock.setText(this.getTime());
//			try{
//				//休眠一秒钟
//				Thread.sleep(1000);
//			}catch(InterruptedException e){
//				e.printStackTrace();
//   			}
//   		}
//  	}
//
//	private String getTime() {
//
//		Calendar c = new GregorianCalendar();
//	
//		//获取日期
//		String time = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" +c.get(Calendar.DATE) + "   ";
//			//获取时刻
//		int hour = c.get(Calendar.HOUR_OF_DAY);
//		int minute = c.get(Calendar.MINUTE);
//		int second = c.get(Calendar.SECOND);
//		//当时间不足10的时候，在个位数前加一个0，使时间整齐
//		String ph = hour < 10 ? "0" : "";
//		String pm = minute < 10 ? "0" : "";
//		String ps = second < 10 ? "0" : "";
//		time += ph + hour + ":" + pm + minute + ":" + ps + second;
//		return time;
//	}
//	
//	@Override
//	public void windowActivated(WindowEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void windowClosed(WindowEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void windowClosing(WindowEvent arg0) {
//		// TODO Auto-generated method stub
//		this.dispose();
//	}
//	@Override
//	public void windowDeactivated(WindowEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void windowDeiconified(WindowEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void windowIconified(WindowEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public void windowOpened(WindowEvent arg0) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	
//}


