package week08;

/**
 * 
 * @author 依兮
 *通过实验掌握Thread 、Runnable使用方法
 *
 */


class DelayThread extends Thread{
	//私有变量，防止意外更改
	private static int count=0; //静态变量，属于该类
	private int no;             //第几个创建的对象（线程）
	private int delay;          //延迟毫秒数
	//无参构造器
	public DelayThread(){
		count++;
		no=count;
	}
	//重写run方法
	public void run(){
		//捕获异常
		try{
			for(int i=0;i<10;i++){
				delay=(int)(Math.random()*5000);//获得0~5000内的随机数
				sleep(delay);
				System.out.println("Thread"+no+" with a delay "+delay);
			}
		}catch(InterruptedException e){
				
		}
	}
	
}


public class MyThread {
	
	public  static void main(String[] args){
		
		DelayThread thread1=new DelayThread();
		DelayThread  thread2=new DelayThread();
		
		thread1.start();
		thread2.start();
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			System.out.println("Thread wrong");
		}
		
//		System.out.println("over");
	}
	
}


