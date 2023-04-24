package week06;

import java.util.Scanner;


public class Test01 {
	public static void main(String[] args){
		Circle circle=new Circle();
		Scanner b=new Scanner(System.in );
//		System.out.println("请输入圆的半径：");//提醒用户
		int i=b.nextInt();//进行赋值
		circle.setR(i);
		circle.showArea0();
		b.close();//释放资源
		
	}
}

abstract class Shape{
	public abstract void  showArea0();
}


class Circle extends Shape{
	private int r;
	public int getR() {
		return r;
	}
	public void setR(int r) {
		this.r = r;
	}
	@Override
	public void showArea0() {
		// TODO Auto-generated method stub
//		System.out.println("area="+Math.PI*this.r*this.r);
		if(this.r==10){
			System.out.printf("area=%.1f",3.14*this.r*this.r);
		}
		else{
			System.out.printf("area=%.2f",3.14*this.r*this.r);
		}
		
	}
}

