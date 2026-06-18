import java.util.*;

class UniqueCombination
{
	public static void generateCombination(char chars[],int index,String current)
	{
		System.out.println(current);
		for(int i=index; i<chars.length;i++)
		{
			generateCombination(chars,i+1,current+chars[i])
		}
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Eneter number of characters: ");
		int n = sc.nextInt();
		char chars[] = new char[n];
		
		System.out.println("Eneter "+n+" Characters: ");
		for(int i=0;i<n;i++)
		{
			chars[i] = sc.nextLine().charAt(0);
		}
		
		generateCombination(chars,0,"");
	}
}