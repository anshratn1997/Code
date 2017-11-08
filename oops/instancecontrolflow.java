class test
{
	int i=10;
	{
		System.out.println("first instace block");
	}
	test()
	{
		System.out.println("constructore");
	}
   public static void main(String[] args) {
   	test t=new test();
   	System.out.println("main");

   }
   public void m1()
   {
   	System.out.println(j);
   }
   {
   	System.out.println("second instance block");
   }
   int j=20;
}