package week07;


/**
 * 
 *从键盘输入十个整数，
 *程序接收字符串，
 *再转化为整数，
 *从小到大排序输出 
 * 
 */

import java.util.Arrays;
import java.util.Scanner;




public class Test1 {
	public static void main(String[] srgs){
		Scanner scanner=new Scanner(System.in);
		int[] ints=new int[10];
		int i=0;
		String string;
		string =scanner.nextLine();
		String[] ss=string.split("\\D");
		try{
			for (String a:ss){
				ints[i++]=Integer.parseInt(a);//以非数字分割字符串
				
			}
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("输入的整数超过了十个，下面将按照从小到大输出前十个数字！");
		}catch(NumberFormatException e){
			System.out.println("没有输入内容");
		}finally{
			scanner.close();
		}
		Arrays.sort(ints);
		for(int a:ints){
			if(i++<10&&a==0){
				continue;
			}
		System.out.println(a);
		}
	}

}
