package week03;

import java.util.Scanner;

/**
 * 
 * @author 于肖依
 * 问题描述：
 * 将命令行第一个参数每个字符放入字符数组
 * 然后逆序输出
 *
 */
public class Application2 {

	public static void main(String[] args){
		String a=new String();//定义字符串变量
		System.out.println("请输入一个字符串");//提示用户
		Scanner b=new Scanner(System.in);//实例化
		a=b.nextLine();//接收输入的字符串并赋值给a
		char c[]=a.toCharArray();//将字符串转化为字符数组
		System.out.print("\n逆序后后的字符分别为：");
		for(int i=c.length-1;i>=0;i--){
			System.out.print(c[i]+" ");
		}
		b.close();//释放资源
	}
}
