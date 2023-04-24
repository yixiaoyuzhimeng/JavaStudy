package week03;



/**
 * 
 * @author 于肖依
 * 定义一个二维数组，
 * 第一维的长度为所打印杨辉三角的层数（即10），
 * 第二维为每一层的数据个数（也就是其所在的层数）。
 *
 */

/*
public class Application4 {
	 public static void main(String[] args) {
		 // 定义数组的长度
	    int length = 10;
	    int arr[][] = new int[length][];	    
	    // 遍历二维数组
	    for (int i = 0; i < arr.length; i++) {
	    	// 确定二维数组元素的大小
	    	arr[i] = new int[i+1];     
	    	// 打印空格
	    	for (int j = 0; j < arr.length-i-1; j++) {
	    		System.out.print("  ");
	    	}     
	    	// 遍历一维数组
	    	for (int j = 0; j < arr[i].length; j++) {
	    		if(j == 0 || arr[i].length-1 == j) {
	    			// 三角形两腰全为 1
	    			arr[i][j] = 1;
	    		}else {
	    			// 其他元素等于两肩数字之和
	    			arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
	    		}
	    		System.out.printf("%4d",arr[i][j]);
	    	}
	    	System.out.println();
	    }
	 }
		 

		
}
*/