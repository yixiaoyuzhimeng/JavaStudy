package week09;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test1 extends JFrame{
	//创建JPanle对象
	private JPanel jp = new JPanel();
	//创建按钮对象
	private JButton b1=new JButton("按钮1");
	private JButton b2 =new JButton("按钮2");
  
	//创建标签对象
	private JLabel j1= new JLabel();
  
	public Test1() {
		jp.add(b1);
		jp.add(b2);
		jp.add(j1);
		this.add(jp);
		this.setTitle("CHEN");
		this.setBounds(100,100,400,130);
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Test1.this.j1.setText("按钮一内容");
			}
		});
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Test1.this.j1.setText("按钮二内容");
			}
		});
		this.setBounds(100,100,400,130);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Test1();
	}
}
