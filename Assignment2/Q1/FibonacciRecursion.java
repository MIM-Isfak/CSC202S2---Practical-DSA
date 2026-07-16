import java.util.*;
public class FibonacciRecursion
{
	static int fib(int n)
	{
		if (n < 0)
		{
			System.out.println("Invalid input!");
			return -1;
		}
		else if (n == 0) 
		{
			return 0;
		}
		else if (n == 1) 
		{
			return 1;
		}
		else
		{
			return fib(n-1)+fib(n-2);
		}
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number(n>0): ");
		int n = sc.nextInt();
		
		int result = fib(n);
		
		if (result != -1)
		{
			System.out.println("Fibonacci number is: "+result);
		}
	}
}