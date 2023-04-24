package week02;

import java.util.Scanner;

public class Pyramid {
	public static void main(String[] args){
		int n;//金字塔数
		System.out.println("请输入金字塔层数");//提示用户输入
		Scanner in=new Scanner(System.in);
		n=in.nextInt();
		//第一层表示层数，第二层表示“*”的打印情况
		for(int i=1;i<=n;i++){
			//打印出多余的空格
			for(int j=i;j<=n-1;j++){
				System.out.print(" ");
			}
			//打印出将用的*
			for(int k=1;k<=2*i-1;k++){
				System.out.print("*");
			}
			System.out.println();//换行
		}
		in.close();
	}
	

}
