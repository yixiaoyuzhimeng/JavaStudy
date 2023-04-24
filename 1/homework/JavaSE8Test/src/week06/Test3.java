package week06;

/**
 * 
 * @author 依兮
 *自定义类Sanj，
 *其中有成员 x,y,z,作为三边长，
 *构造方法Sanj(a,b,c)分别给x,y,z赋值,
 *方法求面积getArea和显示三角形信息(三个边长)showInfo，
 *这2个方法中当三条边不能构成一个三角形时
 *要抛出自定义异常NotSanjiaoException，
 *否则显示正确信息。
 *在另外一个类中的主方法中构造一个Sanj对象(三边为命令行输入的三个整数)，
 *显示三角形信息和面积，
 *要求捕获异常。
 */



public class Test3 {
	public static void main(String[] args){
		int s[]={3,3,3};
		int a=s[0];
		int b=s[1];
		int c=s[2];
		try{
			sanjiao(a, b, c);
			showInfo(a, b, c);
			getarea(a, b, c);
		}catch(IllegalArgumentException e){
			System.out.println("不能构成三角形");
		}finally{
			
		}
	}
	
	public static void sanjiao(int a,int b,int c){
		if((a+b)>c&&(a+c)>b&&(b+c)>a){
			System.out.println(a+","+b+","+c+"三边可构成三角形");
		}else{
			throw new IllegalArgumentException("a,b,c不能构成三角形");
		}
	}
	
	public static void showInfo(int a,int b,int c){
		System.out.println("三边长分别为："+a+","+b+","+c);
	}
	
	public static void getarea(int a,int b,int c){
		double p=(a+b+c)/2;
		double Area=Math.sqrt(p*(p-a)*(p-b)*(p-c));
		System.out.println("面积为"+Area);
	}
}


