import java.util.ArrayList;
import java.util.Scanner;

public class IntersectionOfElements
{
	public static ArrayList<Integer> findIntersection(ArrayList<Integer> list1, ArrayList<Integer> list2)
	{
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 0; i<list1.size(); i++)
		{
			int current = list1.get(i);
		
			boolean foundInList2 = false;
			for(int j = 0; j<list2.size(); j++)
			{
				if(list2.get(j).equals(current))
				{
					foundInList2 = true;
					break;
				}
			}
			
			boolean alreadyAdded = false;
			for(int k = 0; k<result.size(); k++)
			{
				if(result.get(k).equals(current))
				{
					alreadyAdded = true;
					break;
				}
			}
		
			if(foundInList2 && !alreadyAdded)
			{
				result.add(current);
			}
		}
		return result;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
	
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
	
		System.out.print("Enter number of elements in list1: ");
		int n1 = sc.nextInt();
		System.out.println("Enter "+n1+" Integers for list1:");
		for(int i=0; i<n1; i++)
		{
			list1.add(sc.nextInt());
		}
		
		System.out.print("Enter number of elements in list2: ");
		int n2 = sc.nextInt();
		System.out.println("Enter "+n2+" Integers for list2:");
		for(int i=0; i<n2; i++)
		{
			list2.add(sc.nextInt());
		}
		
		ArrayList<Integer> intersection = findIntersection(list1,list2);
		
		System.out.println("List 1: "+list1);
		System.out.println("List 2: "+list2);
		System.out.println("Intersection: "+intersection);
	}
	
}