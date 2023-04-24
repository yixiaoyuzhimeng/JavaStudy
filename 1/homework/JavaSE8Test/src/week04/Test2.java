package week04;

import java.util.Scanner;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Text;




/**
 * 
 * @author 依兮
 *问题描述：
 *定义一个复数(z=x+iy)类Complex，及它的属性、方法和构造函数；
 *定义主类和main()方法，在main()方法中创建两个复数类Complex对象，
 *并通过复数类对象调用它们的属性和方法，输出方法执行结果。
 *
 */

class Complex{
	int x;
	int y;
	Complex(){
		x=0;
		y=0;
	}
	Complex(int i,int j){
		this.x=i;
		this.y=j;
	}
	public  String showComp(){
		return x+"+"+y+"i";
	}

}
public class Test2{
	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("请输入第一个复数的实部和虚部：");
		Complex a=new Complex();
		a.x=scanner.nextInt();
		a.y=scanner.nextInt();
		
		System.out.println("请输入第二个复数的实部和虚部：");		
		Complex b=new Complex();
		b.x=scanner.nextInt();
		b.y=scanner.nextInt();
		
		Test2 test2=new Test2();
		Complex c=test2.addComp(a, b);
		Complex d=test2.subComp(a, b);
		Complex e=test2.multiComp(a, b);
		boolean f=test2.boolComp(a, b);
		
		System.out.println(a.showComp()+" + "+b.showComp()+" = "+c.showComp());
		System.out.println(a.showComp()+" - "+b.showComp()+" = "+d.showComp());
		System.out.println(a.showComp()+" * "+b.showComp()+" = "+e.showComp());
		System.out.println(a.showComp()+" = "+b.showComp()+" ? "+f);
		
		scanner.close();
	}	
	
	public  Complex addComp(Complex a,Complex b){
		Complex c=new Complex();
		c.x=a.x+b.x;
		c.y=a.y+b.y;
		return c;
	}
	public  Complex subComp(Complex a,Complex b){
		Complex c=new Complex();
		c.x=a.x-b.x;
		c.y=a.y-b.y;
		return c;
	}
	public  Complex multiComp(Complex a,Complex b){
		Complex c=new Complex();
		c.x=a.x*b.x-a.y*b.y;
		c.y=a.y*b.x+a.x*b.y;
		return c;
	}
	public boolean boolComp(Complex a,Complex b){
		boolean m=true;
		if(a.x!=b.x||a.y!=b.y){
			m=false;
		}
		return m;
	}
}

//import javax.swing.JOptionPane;
//class Complex {
//	int x;
//	int y;
//	public Complex(){
//		this.x=0;
//		this.y=0;
//	}
//	public Complex(int x,int y){
//		this.x=x;
//		this.y=y;
//	}
//	public void showComp()
//	{
//		System.out.println(this.x+"+"+this.y+"i"+".");
//	}
//	public Complex addComp(Complex c1,Complex c2)
//	{
//		Complex cx1 =new Complex();
//		cx1.x=c1.x+c2.x;
//		cx1.y=c1.y+c2.y;
//		return cx1;
//	}
//	public Complex subComp(Complex c1,Complex c2)
//	{
//		Complex cx2 =new Complex();
//		cx2.x=c1.x-c2.x;
//		cx2.y=c1.y-c2.y;
//		return cx2;
//	}
//	public Complex multiComp(Complex c1,Complex c2)
//	{
//		Complex cx3=new Complex();
//		cx3.x=c1.x*c2.x-c1.y*c2.y;
//		cx3.y=c1.x*c2.y+c2.x*c1.y;
//		return cx3;
//	}
//	public boolean equalComp(Complex c1,Complex c2)
//	{
//		if(c1.x==c2.x&&c1.y==c2.y)
//		{
//			System.out.println("两个复数相等！");
//			return true;
//		}
//		else
//		{
//			System.out.println("两个复数不相等！");
//			return false;
//		}
//	}
//
//}
//public class Test2{
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		String Nc1;
//		String Nc2;
//		String Nc3;
//		String Nc4;
//		int c1,c2,c3,c4;
//	
//		Nc1=JOptionPane.showInputDialog("请输入第一个复数的实部：");
//		c1=Integer.parseInt(Nc1);
//		Nc2=JOptionPane.showInputDialog("请输入第一个复数的虚部：");
//		c2=Integer.parseInt(Nc2);
//		Nc3=JOptionPane.showInputDialog("请输入第二个复数的实部：");
//		c3=Integer.parseInt(Nc3);
//		Nc4=JOptionPane.showInputDialog("请输入第二个复数的虚部：");
//		c4=Integer.parseInt(Nc4);
//	
//	
//		Complex cm1=new Complex(c1,c2); 
//		Complex cm2=new Complex(c3,c4);
//		System.out.println("第一个：");
//		cm1.showComp();
//		System.out.println("第二个：");
//		cm2.showComp();
//		System.out.println("相加后：");
//		cm1.addComp(cm1, cm2).showComp();
//		System.out.println("相减后：");
//		cm1.subComp(cm1, cm2).showComp();
//		System.out.println("相乘后：");
//		cm1.multiComp(cm1, cm2).showComp();
//		System.out.println();
//		cm1.equalComp(cm1,cm2);
//	}
//}
