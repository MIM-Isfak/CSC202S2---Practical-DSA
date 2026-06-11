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