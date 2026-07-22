import java.util.ArrayList;
import java.util.Collections;

public class MissingNumbers
{
    public static ArrayList<Integer> findMissingNumbers(ArrayList<Integer> list)
    {
        ArrayList<Integer> missing = new ArrayList<>();

        if (list == null || list.isEmpty())
        {
            return missing; // no numbers to check, return empty list
        }

        int min = Collections.min(list);
        int max = Collections.max(list);

        // Use a boolean lookup array for O(1) presence checks instead of
        // repeatedly calling list.contains(), which is O(n) per call
        boolean[] present = new boolean[max - min + 1];
        for (int num : list)
        {
            present[num - min] = true;
        }

        for (int i = min; i <= max; i++)
        {
            if (!present[i - min])
            {
                missing.add(i);
            }
        }

        return missing;
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(7);
        numbers.add(9);

        ArrayList<Integer> missing = findMissingNumbers(numbers);
        System.out.println("Missing numbers: " + missing);
    }
}