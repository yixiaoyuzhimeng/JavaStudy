package week09;


import java.awt.*;
import javax.swing.*;

public class Test2 extends JFrame {
	private JPanel jp =new JPanel();
	private JButton [] jbArray =new JButton[80];
	public Test2() {
		for(int i=0;i<jbArray.length;i++) {
			jbArray[i]=new JButton("按钮"+(i+1));
			jbArray[i].setForeground(Color.red);
			jbArray[i].setBackground(Color.yellow);
			jp.add(jbArray[i]);
			jp.setLayout(new GridLayout(20,4));
		}
		this.add(jp);
		this.setTitle("网格布局");
		this.setBounds(100,100,450,200);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Test2();
	}
}
