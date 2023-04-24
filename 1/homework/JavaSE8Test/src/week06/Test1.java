package week06;

import java.io.*;
import java.util.*;


/**
 * 
 * @author 依兮
 * 从命令行得到5个整数，
 * 放入一整型数组，
 * 然后打印输出，
 * 要求：如果输入数据不为整数，
 * 要捕获Integer.parseInt()产生的异常，
 * 显示“请输入整数”，
 * 捕获输入参数不足5个的异常(数组越界)，
 * 显示“请输入至少5个整数”。
 *
 *
 */

public class Test1 {
	public static void main(String[] args) throws IOException{
		String str;
		int i=0,j;
		int s[]=new int[6];
		int a[]=new int[6];
		BufferedReader buf =new BufferedReader(new InputStreamReader(System.in));
		while(true){
			try{
				i++;
				System.out.println("请输入第"+i+"个整数");
				str=buf.readLine();
				s[i]=Integer.parseInt(str);
				if(s[i]==0){
					if(i<6){
						j=7;
						a[j]=s[i];
					}
					break;
				}
			}catch(NumberFormatException e){
				System.out.println("请输入整数");
				i--;
			}catch(NoSuchElementException e){
				System.out.println("请输入至少5个数字");
			}finally{
				
			}
		}
		System.out.println("整数：");
		for(int y=1;y<=i;y++){
			System.out.println(s[y]);		
		}	
		
		}
	}

