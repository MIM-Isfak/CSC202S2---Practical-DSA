import java.util.Scanner;

public class ReverseString
{
	public static String reverseString(String str)
    {
        StackADT stack = new StackADT(str.length());
        
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            stack.push((int) ch);   // char -> int cast
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty())
        {
            int value = stack.pop();
            char ch = (char) value;  // int -> char cast back
            result.append(ch);
        }
        
        return result.toString();
	}
	
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        String reversed = reverseString(input);
        
        System.out.println("Original string: " + input);
        System.out.println("Reversed string: " + reversed);
    }
}
