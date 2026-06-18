import java.util.*;

class Book
{
	String title;
	String author;
	int year;
	
	
	public Book(String title,String author,int year)
	{
		this.title = title;
		this.author = author;
		this.year = year;
	}
	
	public String getTitle()
	{
		return title;
	}
	public String getAuthor()
	{
		return author;
	}
	public int getYear()
	{
		return year;
	}

	public String toString()
	{
		return "Book title: "+title+"\nAuthor of book: "+author+"\npublished year: "+year+"\n";
	}
}


public class Mainex3
{
	public static void main(String args[])
	{
		Book b1 = new Book("The Art of War","John",2025);
		Book b2 = new Book("Illution","Sam",2008);
		Book b3 = new Book("The Goal","Mary",2026);
		
		ArrayList<Book> library = new ArrayList<Book>();
		
		library.add(b1);
		library.add(b2);
		
		for(Book b : library)
		{
			System.out.println(b.toString());
		}
		
	}
}