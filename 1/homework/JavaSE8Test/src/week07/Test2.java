//package week07;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.util.Scanner;
//
//
//
///**
// * 
// * 编写主方法main()，
// * 接受键盘输入的字符串，
// * 用FileInputStream类将字符串写入文件，
// * 用FileOutputStream类读出文件内容显示在屏幕上
// * 
// */
//
//public class Test2 {
//
//	public static void main(String[] args){
//		Scanner in=new Scanner(System.in);
//		byte[] b=in.nextLine().getBytes();
//		File file=new java.io.File("test.txt");
//		OutputStream oStream=new FileOutputStream(file);
//		oStream.write(b);
//		oStream.close();
//		in.close();
//		
//		InputStream is =new FileInputStream(file);
//		int n;
//		StringBuilder sb =new StringBuilder();
//		while((n=is.read())!=-1){
//			sb.append((char) n);
//		}
//		is.close();
//		System.out.println(sb.toString());
//		
//		BufferedReader br =new BufferedReader(new InputStreamReader(file));
//		StringBuffer sbf =new StringBuffer();
//		StringBuffer lneBuffer =null;
//		while((line=br.readLine())!=null){
//			sbf.append(line);
//		}
//		br.close();
//		System.out.println(sbf.toString());
//		
//		
//		
//	}
//	
//	
//}
