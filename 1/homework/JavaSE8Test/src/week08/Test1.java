package week08;

/**
 * 
 * @author 依兮
 *利用Runnable接口改写，
 *并上机检验,
 *必须能够实现多线程
 *
 */

class TestRunnable implements Runnable {
	
	private static int count=0;
	private int no;
	private int delay;
	
	public  TestRunnable(){
		count++;
		no=count;
	}
	
	@Override
	public void run(){
		try{
			for(int i=0;i<10;i++){
				delay=(int)(Math.random()*5000);
				Thread.sleep(delay);
				System.out.println("Thread "+no+" with a delay "+delay);
			}
		}catch(InterruptedException e){
			
		}
	}
	
}




public class Test1 {
	
	public  void main(String[] args){
	
		TestRunnable t1=new TestRunnable();
		Thread thread1=new Thread(t1);
		TestRunnable t2=new TestRunnable();
		Thread thread2=new Thread(t2);
		
		thread1.start();
		thread2.start();
		
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			System.out.println("Thread wrong");
		}
	
	}

}
