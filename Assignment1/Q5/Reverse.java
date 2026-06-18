import java.util.*;

public class Reverse 
{
    public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sen = sc.nextLine();

        String words[] = sen.split(" ");

        System.out.println("Words in reverse:");
        for (String word : words) 
		{
            String reversed = "";

            for (int i = word.length() - 1; i >= 0; i--) 
			{
                reversed += word.charAt(i);
            }

            System.out.println(reversed);
        }
    }
}

