import java.util.ArrayList;
import java.util.Collections;

public class KthLargest
{
    public static int findKthLargest(ArrayList<Integer> list, int k)
    {
        if (list == null || list.isEmpty() || k > list.size() || k <= 0)
        {
            return -1;
        }

        // Make a copy so we don't mutate the caller's list
        ArrayList<Integer> copy = new ArrayList<>(list);
        Collections.sort(copy, Collections.reverseOrder());

        return copy.get(k - 1);
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(4);
        numbers.add(7);
        numbers.add(20);
        numbers.add(15);

        int k = 2;
        int result = findKthLargest(numbers, k);

        if (result != -1)
        {
            System.out.println("The " + k + "th largest element is: " + result);
        }
        else
        {
            System.out.println("Invalid input: k is out of range or list is empty.");
        }

        // Edge case tests
        System.out.println(findKthLargest(numbers, 10)); // k > size -> -1
        System.out.println(findKthLargest(new ArrayList<>(), 1)); // empty list -> -1
    }
}