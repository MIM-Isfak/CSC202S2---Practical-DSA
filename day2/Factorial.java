import java.util.*;

class Factorial
{
	public static int fact(int a)
	{
		if(a==0)
		{
			return 1;
		}
		else
		{
			return fact(a-1)*a;
		}
		
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int num = sc.nextInt();
		
		if(num<0)
		{
			System.out.println("Enter a positive integer!");
		}
		else
		{
			System.out.println("Factorial of "+num+" = "+fact(num));
		}
		
	}
}