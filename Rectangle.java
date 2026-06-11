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