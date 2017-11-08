import java.util.*;
class Mythread extends Thread
{
	static Thread mt;
	public void run()
	{
		 
		for (int i=0;i<10 ;i++ ) {
			System.out.println("child thread 1");
			try{
			mt.join();}
			catch(InterruptedException e){}
		}
		
	}
}
class demo
{
	public static void main(String[] args) throws InterruptedException
	{
		Mythread t= new Mythread();
		Mythread.mt=Thread.currentThread();
		//t.setPriority(10);
		t.start();
		t.join();
		for (int i=0;i<10 ;i++ ) {
			System.out.println("main thread 1");
			Thread.sleep(2000);
		}

	}
}