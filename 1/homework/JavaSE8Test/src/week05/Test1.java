package week05;

/**
 * 
 * @author 依兮
 *定义抽象类Shape，
 *抽象方法为showArea()，
 *求出面积并显示。
 *再定义矩形类Rectangle,
 *正方形类Square,
 *圆类 Circle，
 *和各自的属性，
 *用showArea方法求出各自的面积。
 *定义主类、主方法，
 *在main方法中构造3个对象，
 *调用showArea方法；
 *
 *
 */


abstract class Shape{
	//double area;
	public abstract void  showArea();
}

class Rectangle extends Shape{
	private double x,y;
	Rectangle(double x,double y){
		this.x=x;
		this.y=y;
	}
	@Override
	public void showArea() {
		// TODO Auto-generated method stub
		System.out.println("矩形的面积为："+this.x*this.y);
	}
	
}

class Square extends Shape{
	private double x;
	Square(double x){
		this.x=x;
	}
	@Override
	public void showArea() {
		// TODO Auto-generated method stub
		System.out.println("正方形的面积为："+this.x*this.x);
	}
}

class Circle extends Shape{
	private double r;
	Circle(double r){
		this.r=r;
	}
	@Override
	public void showArea() {
		// TODO Auto-generated method stub
		System.out.println("圆形的面积为："+Math.PI*this.r*this.r);
	}
}


public class Test1 {
	public static void main(String[] args){
		Rectangle rectangle=new Rectangle(1, 2);
		Square square=new Square(2);
		Circle circle=new Circle(3);
		rectangle.showArea();
		square.showArea();
		circle.showArea();
		
	
	}
}
