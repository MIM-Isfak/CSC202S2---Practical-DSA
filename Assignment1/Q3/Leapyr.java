import java.util.*;

public class Leapyr
{
    static void isLeapYear(int year)
    {
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
        {
            System.out.println(year+" is a Leap Year!");
        }
        else
        {
            System.out.println(year+" is not a Leap Year!");
        }
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = sc.nextInt();

        isLeapYear(year);
    }
}