package week03;

import java.util.Scanner;


/**
 * 
 * @author 于肖依
 *问题描述：
 *接受用户输入一段英文文字后，
 *输出其中的字符数、字母数、单词数和句子数
 *（设句子以“？”、“！”、“.”结束）。
 */
public class Application3 {

	public static void main(String[] args){
		String a=new String();
		System.out.println("请输入一段英文文字：");
		Scanner b=new Scanner(System.in);
		a=b.nextLine();
		char c[]=a.toCharArray();
		int ch,l=0,wo=0,sen=0;
		ch=a.length();
		for(char i:c){
			if((i>='a'&&i<='z')||(i>='A'&&i<='B')){
				l++;
			}
			if(i==' '){
				wo++;
			}
			if(i=='?'||i=='!'||i=='.'){
				sen++;
				wo++;
			}
		}
		System.out.println("字符数为"+ch);
		System.out.println("字母数为"+l);
		System.out.println("单词数为"+wo);
		System.out.println("句子数为"+sen);
		b.close();
	}
}
