package week04;


import java.util.Scanner;

/**
 * 
 * @author 依兮
 * 
 * 定义类Point及它的属性、方法和构造函数，
 * 定义主类和main()，在main()方法中创建两个坐标对象,
 * 并通过对象调用getMiddle方法后得到一个新的点坐标，
 * 调用show（）显示该对象的坐标值。
 *
 */

//如何不用静态方法调用？——通过对象调用


class Point{
	public double x;
	public double y;
	public Point(){
	}
	public Point(double x , double y){  //构造函数的重载
		this.x=x;
		this.y=y;
	}
	public void show(){
		System.out.println("x="+x+","+"y="+y);
	}
}

public class Test1 {
	public static void main(String[] args){
		Scanner x=new Scanner(System.in);
		
		System.out.println("请输入第一个点的x、y坐标");
		double x11=x.nextDouble();
		double y11=x.nextDouble();
		Point a=new Point(x11,y11);
		
		System.out.println("请输入第二个点的x、y坐标");
		double x22=x.nextDouble();
		double y22=x.nextDouble();
		Point b=new Point(x22,y22);
		
		Point m=new Point();
		m=getMiddle(a,b);
		m.show();
		x.close();
	}
	
	static Point getMiddle(Point a,Point b){
		Point t=new Point();
		t.x=(a.x+b.x)/2;
		t.y=(a.y+b.y)/2;
		return t;
	}
}

