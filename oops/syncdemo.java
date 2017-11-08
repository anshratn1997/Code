import java.util.*;
class display
{
    public static synchronized void wish(String name)
    {
    	for (int i=0;i<10 ;i++ ) {
    		System.out.print("good morning :");
    	
    	try{
    		Thread.sleep(1000);

    	}
    	catch(InterruptedException e)
    	{}
    	System.out.println(name);
    }
    		

    }
}
class Mythread extends Thread
{
	display d;
	String name;
	Mythread(display d,String name)
	{
		this.d=d;
		this.name=name;
	}
	public void run()
	{    
		d.wish(name);
		
	}
}
class demo1
{
	public static void main(String[] args)
	{
		display d=new display();
		display d2=new display();
		Mythread t= new Mythread(d,"ratnesh");
		Mythread t1= new Mythread(d2,"pathak");
		//t.setPriority(10);
		t.start();
		t1.start();
	}
}