import java.util.Scanner;

public class Mainex2
{
	public static int performOperation(int num1, int num2, char opr)
		{
			if (opr=='+')
			{
				 return num1 + num2;
			}
			else if (opr == '-')
			{
				 return num1 - num2;
			}
			else if (opr == '*')
			{
				 return num1 * num2;
			}
			else if (opr == '/')
			{
				 return num1 / num2;
			}
			else
			{
				System.out.println("Oprator is wrong.Try another!");
				return 0;
			}
			
		}
		
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the operator(+, -, *, /): ");
		char opr = sc.nextLine().charAt(0);
		
		System.out.println("Enter number1: ");
		int num1 = sc.nextInt();
		System.out.println("Enter number2: ");
		int num2 = sc.nextInt();
		
		System.out.println("answer: "+performOperation(num1,num2,opr));
	}
}
