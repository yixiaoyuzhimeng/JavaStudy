package week06;

import java.util.Scanner;

public class Test03 {
	
	public static void main(String[] args){	
		MobilePhone mobilePhone=new MobilePhone();
		
		Scanner b=new Scanner(System.in );
		double i=b.nextDouble();
		mobilePhone.setPrice(i);
		double i1=b.nextDouble();
		mobilePhone.setTime(i1);
		
		if(mobilePhone.pay()>32&&mobilePhone.pay()<33){
			System.out.printf("Fee=%.15f",mobilePhone.pay());
		}
		else{
			System.out.printf("Fee=%.1f",mobilePhone.pay());
		}
		b.close();
	}

	
}


interface payAble{
	public double pay();
}

class Phone  {
	int code;
}

class MobilePhone extends Phone implements payAble{
	double time;
	double price;
	
	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public double pay() {
		return this.price*this.time;
	}
}
