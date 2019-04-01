import java.lang.Math;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class Person {
	
	// Fields
	String id;
	String name;
	LinkedHashMap<String, Integer> gradesLinkedMap;
	int weightedGrade;
	
	static float[] weights = { 0.2f, 0.2f, 0.2f, 0.2f, 0.2f };
	
	// Constructor
	public Person(String i, String n, int[] a)
	{
		id = i;
		name = n;
		initGradesLinkedMap(a);
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
	
	public LinkedHashMap<String, Integer> getGradesLinkedMap()
	{
		return gradesLinkedMap;
	}
	
	public int getWeightedGrade()
	{
		return weightedGrade;
	}
	
	// Private Methods
	private void initGradesLinkedMap(int[] grades)
	{
		gradesLinkedMap = new LinkedHashMap<String, Integer>();
		gradesLinkedMap.put("Lab1", grades[0]);
		gradesLinkedMap.put("Lab2", new Integer(grades[1]));
		gradesLinkedMap.put("Lab3", new Integer(grades[2]));
		gradesLinkedMap.put("Midterm exam", new Integer(grades[3]));
		gradesLinkedMap.put("Final exam", new Integer(grades[4]));
	}
	
	private boolean evalWeightedGrade()
	{
		if(weights.length != gradesLinkedMap.size()) {
			weightedGrade = -1;
			return false;
		}
		
		float sum = 0;
		ArrayList<Integer> grades = new ArrayList<Integer>(gradesLinkedMap.values());
		for(int i = 0; i < grades.size(); ++i) {
			sum += (grades.get(i) * weights[i]);
		}
		weightedGrade = Math.round(sum);
		return true;
	}
	
}
