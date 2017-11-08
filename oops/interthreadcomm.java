import java.util.*;
class Mythread extends Thread
{
	int total=0;
	public void run()
	{
        for (int i=0;i<10 ;i++ ) {
           total+=i;
        }
	}
}
class demo1
{
	public static void main(String[] args)
	{
		
		Mythread t= new Mythread();
		Thread t1=Thread.currentThread();
		//t.setPriority(10);
		t.start();
		try{
		t.join();}
		catch(Exception e){}
		System.out.println(t.total);
	}
}