package gradeSystem;
import java.lang.Math;
import java.util.Arrays;

public class Student implements Comparable<Student> {
	
	// Fields
	private static double[] weights = { 0.2f, 0.2f, 0.2f, 0.2f, 0.2f };
	private final static String[] subjects = { "Lab1", "Lab2", "Lab3", "Midterm exam", 
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
	
	/* int compareTo(Student another)
	 * 決定兩個Student的加權分數大小差距
	 * @param another：欲比較的Student
	 * @return int：分數差距
	 * 
	 * Pseudo code
	 * 回傳呼叫者的加權分數減去參數學生的加權分數
	 * 
	 * Time estimate：O(1)
	 * 
	 * Example
	 * int d = A.compareTo(B)
	 */
	@Override
	public int compareTo(Student another)
	{
		return this.weightedGrade - another.weightedGrade;
	}
	
	/* boolean equals(Object o)
	 * 決定兩個Student是否資料相同
	 * @param o：欲比較的物件
	 * @return boolean：是否相同
	 * 
	 * Pseudo code
	 * 1.先檢查該物件型別是否為Student，若非則回傳false
	 * 2.若是，再檢查兩個Student的id, name, grades三個變數是否全部相同
	 *   若是
	 * 
	 * Time estimate：O(1)
	 * 
	 * Example
	 * boolean isSame = A.equals(B)
	 */
	@Override
	public boolean equals(Object o)
	{
		if((o instanceof Student)) {
			Student s = (Student)o;
			return (s.getId().equals(getId())) 
					&& (s.getName().equals(getName()))
					&& (Arrays.equals(s.getGrades(), getGrades()));
		}
		return false;
	}
	
	// Public Methods
	
	/* void evalWeightedGrade()
	 * 計算此學生的加權平均分數
	 * 
	 * Pseudo code
	 * 對各科分數和對應權重的乘積作加總後，賦值給weightedGrade
	 * 
	 * Time estimate：O(1)
	 * 
	 * Example
	 * Student.evalWeightedGrade()
	 */
	public void evalWeightedGrade()
	{
		double sum = 0;
		for(int i = 0; i < grades.length; ++i) {
			sum += (grades[i] * weights[i]);
		}
		weightedGrade = (int) Math.round(sum);
	}
	
	// Getters & Setters
	public static String[] getSubjects()
	{
		return subjects;
	}
	
	public static double[] getWeights()
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
	
	public static void setWeights(double[] _weights)
	{	
		weights = _weights;
	}
	
	public void setRank(int _rank)
	{
		rank = _rank;
	}
	
}
