import java.lang.Math;

public class Student implements Comparable<Student> {
	
	// Fields
	private static float[] weights = { 0.2f, 0.2f, 0.2f, 0.2f, 0.2f };
	private static String[] subjects = { "Lab1", "Lab2", "Lab3", "Midterm exam", 
			"Final exam" };
	
	private String id;
	private String name;
	private int[] grades;
	
	private int weightedGrade;
	private int rank;
	
	// Constructor
	public Student(String _id, String _name, int[] _grades)
	{
		id = _id;
		name = _name;
		grades = _grades;
		evalWeightedGrade();
		rank = -1;
	}
	
	// Overrides
	@Override
	public int compareTo(Student another) {
		return this.weightedGrade - another.weightedGrade;
	}
	
	// Public Methods
	public void evalWeightedGrade()
	{
		float sum = 0;
		for(int i = 0; i < grades.length; ++i) {
			sum += (grades[i] * weights[i]);
		}
		weightedGrade = Math.round(sum);
	}
	
	// Getters & Setters
	public static String[] getSubjects()
	{
		return subjects;
	}
	
	public static float[] getWeights()
	{
		return weights;
	}
	
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
	
	public int getRank()
	{
		return rank;
	}
	
	public static void setWeights(float[] _weights)
	{	
		weights = _weights;
	}
	
	public void setRank(int _rank)
	{
		rank = _rank;
	}
	
}
