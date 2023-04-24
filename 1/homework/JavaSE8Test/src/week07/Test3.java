package week07;

/**
 * 
 * @author 依兮
 *将一个文本文件的内容按行读出，
 *每读出一行就顺序加上行号，
 *并写入另一个文件中
 *
 *
 */

import java.io.*;


public class Test3 {
	public static void main(String[] args){
		String str;
		int i=1;
		
		File f=new File("read.txt");
		FileReader fr;
		try{
			
			FileWriter fw =new FileWriter("output.txt");
			BufferedWriter bw=new BufferedWriter(fw);
			fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			while(br.ready()){
				str=i+"."+br.readLine();
				System.out.println(str);
				bw.write(str+"\r\n");
				bw.flush();
				i++;
			}
			bw.close();
			br.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	
}