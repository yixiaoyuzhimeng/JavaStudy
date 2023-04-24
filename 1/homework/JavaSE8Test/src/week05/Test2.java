package week05;


/**
 * 
 * @author 依兮
 *定义接口DiagArea，
 *其中包含方法double getDiagonal()求对角线长,
 * double getArea()求面积.
 * 定义一个矩形类，
 * 实现此接口，
 * 并自行扩充成员变量和方法.
 * 定义一个正方形类继承矩形类
 * （如矩形有长w和宽h，正方形有边x，并有相应的构造函数，重写toString()方法，可以一次直接显示边长、面积和对角线长）,
 * 在另一类中的主方法里使用测试该类。
 *
 *
 */

interface DiagArea{
	public double getDiagonal();
	public double getArea();
}


class Rectangle1 implements DiagArea{
	double w,h;
	Rectangle1(double w,double h){
		this.w=w;
		this.h=h;
	}
	@Override
	public double getDiagonal() {
		// TODO Auto-generated method stub
		return Math.sqrt(w*w+h*h);
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return w*h;
	}
	public void Dispaly(){
		System.err.println("w="+w+"  h="+h);
		System.out.println("the Rectangle's diagoal is "+this.getDiagonal());
		System.out.println("the Rectangle's area is "+this.getArea());
	}
}

class Square1  implements DiagArea{
	double x;
	Square1(double x) {
		// TODO Auto-generated constructor stub
		this.x=x;
	}
	public double getDiagonal()
	{
	return Math.sqrt(x*x*2);
	}
	public double getArea()
	{
	return x*x;
	}
	public void Display()
	{
	System.out.println("x= "+x);
	System.out.println("the Square's diagoal is "+this.getDiagonal());
	System.out.println("the Square's area is "+this.getArea());
	}
	
}




public class Test2 {

	public static void main(String[] args){
		Rectangle1 rectangle1=new Rectangle1(3, 4);
		Square1 square1=new Square1(5);
		rectangle1.Dispaly();
		square1.Display();
	}
}
