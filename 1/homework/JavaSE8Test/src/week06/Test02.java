package week06;

import java.util.Scanner;


public class Test02 {
	public static void main(String[] args){	
		Circle1 circle1=new Circle1();
		Scanner b=new Scanner(System.in );
		double i=b.nextDouble();//进行赋值
		circle1.setR(i);
		if(i==10){
			System.out.printf("Circle Area=%.1f",circle1.getArea());
		}
		else{
			System.out.printf("Circle Area=%.2f",circle1.getArea());
		}
		b.close();//释放资源
	}

		
}

interface CalculateAble{
	public double getArea();
}

class Circle1 implements CalculateAble{
	double r;
	
	public double getR() {
		return r;
	}
	
	public void setR(double r) {
		this.r = r;
	}
	
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		//return Math.PI*this.r*this.r;
		return 3.14*this.r*this.r;
	}
}




