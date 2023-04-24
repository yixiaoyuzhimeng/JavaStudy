package week02;

public class JavaAplication {
	public static void main(String[] args){
		for(int i=1900;i<2000;i++){
			if((i%4==0&&i%100!=0)||(i%400==0))
				System.out.println(i);
		}
	}
}
