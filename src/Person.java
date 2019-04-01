import java.lang.Math;

public class Person {
	
	// Fields
	String id;
	String name;
	int[] grades;
	int weightedGrade;
	
	static float[] weights = { 0.2f, 0.2f, 0.2f, 0.2f, 0.2f };
	
	// Constructor
	public Person(String i, String n, int[] a)
	{
		id = i;
		name = n;
		grades = a;
		evalWeightedGrade();
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
	
	public int getWeightedGrade()
	{
		return weightedGrade;
	}
	
	// Private Methods
	private boolean evalWeightedGrade()
	{
		if(weights.length != grades.length) {
			weightedGrade = -1;
			return false;
		}
		
		float sum = 0;
		for(int i = 0; i < grades.length; ++i) {
			sum += (grades[i] * weights[i]);
		}
		weightedGrade = Math.round(sum);
		return true;
	}
	
}
