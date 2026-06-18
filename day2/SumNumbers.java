class SumNumbers 
{
    public static int calculateSumRecursive(int a[], int index) 
	{
   
        if (index == a.length)
		{
            return 0;
        }
 
        return a[index] + calculateSumRecursive(a, index + 1);  
    }
    

    public static int calculateSumIterative(int a[]) 
	{
        int sum = 0;
        for (int i = 0; i < a.length; i++) 
		{  
            sum += a[i];
        }
		return sum;
    
    }
    
   
    public static void main(String args[])
	{
        int arr[] = {1, 2, 3, 4, 5};
       
        System.out.println("Sum (Recursive) = " + calculateSumRecursive(arr, 0));
        
        int sum = calculateSumIterative(arr);
        System.out.println("Sum (Iterative) = " + sum);
		
		
		long recursiveStartTime = System.nanoTime();
		long recursiveEndTime = System.nanoTime();
		long recursiveExecutionTime = recursiveEndTime - recursiveStartTime;
		System.out.print("Recursive execution time(in nanoseconds): "+recursiveExecutionTime);
		
		System.out.println();
		
	
		long iterativeStartTime = System.nanoTime();
		long iterativeEndTime = System.nanoTime();
		long iterativeExecutionTime = iterativeEndTime - iterativeStartTime;
		System.out.print("Iterative execution time(in nanoseconds): "+iterativeExecutionTime);
    }
}
