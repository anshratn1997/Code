import java.util.*;
class A
{
	public synchronized void d1(B b)
	{
		System.out.println("thread 1 start execution of d1() method");
		try{
			Thread.sleep(2000);
		}
		catch(Exception e){
		}
		b.last();
	}
	public synchronized void last()
	{
		System.out.println("inside last method of A");
	}
}
class B
{
	public synchronized void d2(A a)
	{
		System.out.println("thread 2 start execution of d2() method");
		try{
			Thread.sleep(2000);
		}
		catch(Exception e){
		}
		a.last();
	}
	public synchronized void last()
	{
		System.out.println("inside last method of B");
	}
}
class Mythread extends Thread
{
	A a=new A();
	B b=new B();
	public void m1()
	{
		this.start(); // this is called instead of t.start() method
		a.d1(b);// this line executed by main thread
	}
	public void run()
	{
       b.d2(a);// this line executed by child thread
	}
}
class demo1
{
	public static void main(String[] args)
	{
		
		Mythread t= new Mythread();
		t.m1();
	   
	}
}