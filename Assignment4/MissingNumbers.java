import java.util.ArrayList;
import java.util.Scanner;

public class MissingNumbers
{
    public static ArrayList<Integer> findMissingNumbers(ArrayList<Integer> list)
    {
        ArrayList<Integer> missing = new ArrayList<>();

        if (list == null || list.isEmpty())
        {
            return missing;
        }

        int min = list.get(0);
        int max = list.get(0);

        for (int i = 1; i < list.size(); i++)
        {
            int current = list.get(i);
            if (current < min)
            {
                min = current;
            }
            if (current > max)
            {
                max = current;
            }
        }

        for (int i = min; i <= max; i++)
        {
            if (!list.contains(i))
            {
                missing.add(i);
            }
        }

        return missing;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++)
        {
            numbers.add(sc.nextInt());
        }

        ArrayList<Integer> missing = findMissingNumbers(numbers);
        System.out.println("Missing numbers: " + missing);
    }
}