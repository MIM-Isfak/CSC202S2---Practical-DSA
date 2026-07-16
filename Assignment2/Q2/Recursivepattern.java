public class RecursivePattern
{
	static void pattern(String s, int n)
	{
		if (n == 0)
		{
			return;
		}
		
		System.out.println(s.substring(0, n));
		
		pattern(s, n-1);
		
		if (n > 1)
		{
			System.out.println(s.substring(0, n));
		}
	}
	
	public static void main(String args[])
	{
		String inp = "abc";
		
		pattern(inp, inp.length());
		
	}
}