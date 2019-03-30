
public class Person {
	
	// Fields
	String id;
	String name;
	int[] grades;
	
	// Constructor
	public Person(String i, String n, int[] a)
	{
		id = i;
		name = n;
		grades = a;
	}
	
	// Public Methods
	public String getId()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public int[] getGrades()
	{
		return grades;
	}
	
}
