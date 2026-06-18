public class Rectangle
{
	double length;
	double width;
	
	public Rectangle()
	{
		this.length = 0;
		this.width = 0;
	}
	
	public Rectangle(double length,double width)
	 {
		 this.length = length;
		 this.width = width;
	 }
	 
	 public double getLength()
	 {
		 return length;
	 }
	 
	 public double getWidth()
	 {
		 return width;
	 }
	 
	 public void setLength(double length)
	 {
		 this.length=length;
	 }
	 
	 public void setWidth(double width)
	 {
		 this.width=width;
	 }
	 
	 public double calculatePerimeter()
	{
		return 2*(length+width);
	}
	public double calculateArea()
	{
		return length*width;
	}
	 
	public static void main(String args[])
	{
		Rectangle r1 = new Rectangle(6,4);
		
		System.out.println("area: "+r1.calculateArea());
		System.out.println("perimeter: "+r1.calculatePerimeter());
	} 
}


