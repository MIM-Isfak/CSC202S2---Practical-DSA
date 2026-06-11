import java.util.*;

public class Mainex3
{
	public static void main(String args[])
	{
		Book b1 = new Book("The Art of War","John",2025);
		Book b2 = new Book("Illution","Sam",2008);
		Book b3 = new Book("The Goal","Mary",2026);
		
		arraylist arr[] = new arraylist();
		
		arr.add(b1);
		arr.add(b2);
		
		System.out.println(arr.toString());
	}
}