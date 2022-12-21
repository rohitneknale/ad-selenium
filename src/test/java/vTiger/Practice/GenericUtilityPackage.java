package vTiger.Practice;

public class GenericUtilityPackage {

	public static void main(String[] args) {
		
		
		int value = GenericUtilityPackage.add(10, 20);	//calling/called method
		System.out.println(value);
		int num = GenericUtilityPackage.sub(30, 20);
		System.out.println(num);

	}
	
	public static int add(int a, int b)	//called method	//parameterized method
	{
		int c = a+b;
		return c;
	}
	
	public static int sub(int a,int b)
	{
		int d=a-b;
		return d;
	}
}
