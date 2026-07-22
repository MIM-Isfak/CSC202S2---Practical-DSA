import java.util.ArrayList;
public class StudentDetails
{
	public static void main(String args[])
	{
		ArrayList<Student> studentList = new ArrayList<>();
		
		Student st1 = new Student("John Doe", 18, 85.5);
		Student st2 = new Student("Jane Smith", 17, 92.0);
		Student st3 = new Student("Michael Johnson", 19, 78.3);
		
		studentList.add(st1);
		studentList.add(st2);
		studentList.add(st3);
		
		// print the details of students
		System.out.println("---------------Details of students-----------------");
		for(int i = 0; i < studentList.size(); i++)
		{
			System.out.print(studentList.get(i).toString());
		}

		// update the grade of John Doe
		for(Student st : studentList)
		{
			if(st.getName().equals("John Doe"))
			{
				st.setGrade(90.2);
				break;
			}
		}

		// remove "Jane Smith" from the studentList
		for(Student st : studentList)
		{
			if(st.getName().equals("Jane Smith"))
			{
				studentList.remove(st);
				break;
			}
		}

		System.out.println("\n--------------------------------");
		for(int i = 0; i < studentList.size(); i++)
		{
			System.out.print(studentList.get(i).toString());
		}
	}
}

class Student
{
	private String name;
	private int age;
	private double grade;
	
	public Student(String name,int age,double grade)
	{
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public double getGrade()
	{
		return grade;
	}
	public void setGrade(double grade)
	{
		this.grade = grade;
	}
	
	public String toString()
	{
		return "\nStudent name: "+name+", Age: "+age+", Grade: "+grade;
	}
}
