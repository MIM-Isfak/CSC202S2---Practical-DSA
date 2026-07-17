import java.util.ArrayList;

public class ArrayMerge
{
	public static ArrayList<Double> mergeArrays(double[] ascendingArr, double[] descendingArr)
	{
		ArrayList<Double> result = new ArrayList<>();
		int i = 0;
		int j = descendingArr.length-1;
		
		while(i<)
		
	}
	
	public static void main(String args[])
	{
		double[] ascendingArr = {0.1,0.3,0.5,0.7};
		double[] descendingArr = {8.8,3.3,2.2,1.1};
		ArrayList<Double> merged = mergeArrays(ascendingArr,descendingArr);
		
		System.out.println("Merged sorted array: " + merged);
	}
}