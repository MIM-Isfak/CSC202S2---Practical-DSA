import java.util.Scanner;

public class DecimalToBinary
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a decimal number: ");
        int num = sc.nextInt();
        
        int original = num; 
        
        StackADT stack = new StackADT(32);
        
        if (num == 0)
        {
            System.out.println("Binary representation: 0");
            return;
        }
        
        boolean isNegative = false;
        if (num < 0)
        {
            isNegative = true;
            num = -num;
        }
        
        while (num > 0)
        {
            int remainder = num % 2;
            stack.push(remainder);
            num = num / 2;
        }
        
        // Pop everything - this gives binary in correct order LIFO
        StringBuilder binary = new StringBuilder();
        if (isNegative)
        {
            binary.append("-");
        }
        
        while (!stack.isEmpty())
        {
            binary.append(stack.pop());
        }
        
        System.out.println("Decimal: " + original);
        System.out.println("Binary representation: " + binary.toString());
        
    }
}