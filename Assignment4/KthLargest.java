import java.util.ArrayList;
import java.util.Scanner;

public class KthLargest
{
    public static int findKthLargest(ArrayList<Integer> list, int k)
    {
        if (list == null || list.isEmpty() || k > list.size() || k <= 0)
        {
            return -1;
        }

        ArrayList<Integer> copy = new ArrayList<>(list);

        int largest = -1;
        for (int count = 1; count <= k; count++)
        {
            int maxIndex = 0;
            for (int i = 1; i < copy.size(); i++)
            {
                if (copy.get(i) > copy.get(maxIndex))
                {
                    maxIndex = i;
                }
            }
            largest = copy.get(maxIndex);
            copy.remove(maxIndex);
        }

        return largest;
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

        System.out.print("Enter the value of k: ");
        int k = sc.nextInt();

        int result = findKthLargest(numbers, k);

        if (result != -1)
        {
            System.out.println("The " + k + "th largest element is: " + result);
        }
        else
        {
            System.out.println("Invalid input: k is out of range or list is empty.");
        }
    }
}