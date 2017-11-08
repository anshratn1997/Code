import java.util.*;
class display
{
    public synchronized void displayn()
    {
    	for (int i=0;i<10 ;i++ ) {
    		System.out.print(i);
    	
    	try{
    		Thread.sleep(1000);

    	}
    	catch(InterruptedException e)
    	{}
    }
   }
    public  synchronized void displayc()
    {
    	for (int i=65;i<75 ;i++ ) {
    		System.out.print((char)i);
    	
    	try{
    		Thread.sleep(1000);

    	}
    	catch(InterruptedException e)
    	{}
    }
  }
}
class Mythread extends Thread
{
	display d;
	
	Mythread(display d)
	{
		this.d=d;
	}
	public void run()
	{    
		d.displayn();
		
	}
}
class Mythread1 extends Thread
{
	display d;
	
	Mythread1(display d)
	{
		this.d=d;
	}
	public void run()
	{    
		d.displayc();
		
	}
}
class demo1
{
	public static void main(String[] args)
	{
		display d=new display();
		//display d2=new display();
		Mythread t= new Mythread(d);
		Mythread1 t1= new Mythread1(d);
		//t.setPriority(10);
		t.start();
		t1.start();
	}
}