class Rectangle
{
	double length;
	double width;
	
	public Rectangle()
	{
		this.length = 0;
		this.width = 0;
	}
	
	public void setLength(double length)
	{
		this.length = length;
	}
	public void setWidth(double width)
	{
		this.width = width;
	}
	public double calculatePerimeter()
	{
		// double perimeter = 2*(length+width);
		// return perimeter;
		return 2*(length+width);
	}
	public double calculateArea()
	{
		// double area = (length*width);
		// return area;
		return (length*width);
	}
}

public class Mainex1
{
	public static void main(String args[])
	{
		Rectangle r1 = new Rectangle();
		r1.setLength(6.0);
		r1.setWidth(4.0);
		System.out.println("perimeter = "+r1.calculatePerimeter());
		System.out.println("area = "+r1.calculateArea());
	}
}