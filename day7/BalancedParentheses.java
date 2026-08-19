import java.util.Scanner;

public class BalancedParentheses
{
	public static boolean isBalanced(String expr)
    {
        StackLinkedList stack = new StackLinkedList();
        
        for (int i = 0; i < expr.length(); i++)
        {
            char ch = expr.charAt(i);
            
            // Step 1: If opening bracket, push it
            if (ch == '(' || ch == '{' || ch == '[')
            {
                stack.push(String.valueOf(ch));
            }
            // Step 2: If closing bracket, check and pop
            else if (ch == ')' || ch == '}' || ch == ']')
            {
                // Closing bracket with empty stack = unbalanced
                if (stack.isEmpty())
                {
                    return false;
                }
                
                String top = stack.pop();
                char openBracket = top.charAt(0);
                
                // Check if it matches the correct opening bracket
                if (!isMatchingPair(openBracket, ch))
                {
                    return false;
                }
            }
        }
        
        // Step 3: If stack is empty at the end, all brackets matched
        return stack.isEmpty();
    }
    
    // Checks if open and close brackets are a valid pair
    public static boolean isMatchingPair(char open, char close)
    {
        if (open == '(' && close == ')') 
		{
			return true;
		}
        if (open == '{' && close == '}') 
		{
			return true;
		}
        if (open == '[' && close == ']') 
		{
			return true;
		}
		else
        {
			return false;
		}
    }
	
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter an expression: ");
        String expr = sc.nextLine();
        
        boolean result = isBalanced(expr);
        
        if (result)
        {
            System.out.println("The expression is balanced.");
        }
        else
        {
            System.out.println("The expression is not balanced.");
        }
    }
}
