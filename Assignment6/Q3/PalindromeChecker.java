import java.util.Scanner;

public class PalindromeChecker
{
	// Removes non-alphanumeric characters and converts to lowercase
    public static String cleanString(String str)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);
            if (Character.isLetterOrDigit(ch))
            {
                sb.append(Character.toLowerCase(ch));
            }
        }
        return sb.toString();
    }
    
    // Uses StackLinkedList to check if the cleaned string is a palindrome
    public static boolean isPalindrome(String cleaned)
    {
        StackLinkedList stack = new StackLinkedList();
        
        for (int i = 0; i < cleaned.length(); i++)
        {
            stack.push(String.valueOf(cleaned.charAt(i)));
        }
        
        // Pop each character - comes out in REVERSED order
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty())
        {
            reversed.append(stack.pop());
        }
        
        return cleaned.equals(reversed.toString());
    }
	
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        // Clean the string - keep only alphanumeric, convert to lowercase
        String cleaned = cleanString(input);
        
        boolean result = isPalindrome(cleaned);
        
        System.out.println("Cleaned string: " + cleaned);
        if (result)
        {
            System.out.println("The string is a valid palindrome.");
        }
        else
        {
            System.out.println("The string is NOT a palindrome.");
        }
    }
}