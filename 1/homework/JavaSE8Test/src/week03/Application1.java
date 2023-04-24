package week03;


import java.util.Scanner;
import java.util.Arrays;

/**
 * 
 * @author 于肖依
 *问题描述：
 *从命令行参数输入10个整数并保存在数组中，
 *求数组中最大、最小、数据的和、平均值
 *
 */

public class Application1 {

	//从main方法开始
	public static void main(String[] args){
		int num=0; //定义并初始化总和变量
		double avg=0.0; //定义并初始化平均值变量
		int[] a=new int[10];//定义数组a存放10个整数
		Scanner b=new Scanner(System.in );//实例化输出类为b
		System.out.println("请输入十个整数：");//提醒用户
		for(int i:a){//遍历数组
			i=b.nextInt();//进行赋值
			num+=i;//计算总和
		}
		avg=num/10.0;
		//将数据升序排列
		Arrays.sort(a);
		System.out.println("最大值为"+a[9]);
		System.out.println("最小值为"+a[0]);
		System.out.println("总和为"+num);
		System.out.println("平均值为"+avg);
		b.close();//释放资源
	}
	
	
}
