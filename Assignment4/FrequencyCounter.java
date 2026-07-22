import java.util.ArrayList;

public class FrequencyCounter
{
    public static void countFrequency(String[] arr)
    {
        ArrayList<String> uniqueElements = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        for (String element : arr)
        {
            int index = uniqueElements.indexOf(element);

            if (index == -1)
            {
                // First time seeing this element
                uniqueElements.add(element);
                counts.add(1);
            }
            else
            {
                // Already seen — increment its count
                counts.set(index, counts.get(index) + 1);
            }
        }

        System.out.println("Element Frequencies:");
        for (int i = 0; i < uniqueElements.size(); i++)
        {
            System.out.println(uniqueElements.get(i) + " -> " + counts.get(i));
        }
    }

    public static void main(String[] args)
    {
        String[] words = {"apple", "banana", "apple", "orange", "banana", "apple"};
        countFrequency(words);
    }
}