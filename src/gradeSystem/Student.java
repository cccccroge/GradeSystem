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
	 * �M�w���Student���[�v���Ƥj�p�t�Z
	 * @param another�G�������Student
	 * @return int�G���Ʈt�Z
	 * 
	 * Pseudo code
	 * �^�ǩI�s�̪��[�v���ƴ�h�Ѽƾǥͪ��[�v����
	 * 
	 * Time estimate�GO(1)
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
	 * �M�w���Student�O�_��ƬۦP
	 * @param o�G�����������
	 * @return boolean�G�O�_�ۦP
	 * 
	 * Pseudo code
	 * 1.���ˬd�Ӫ��󫬧O�O�_��Student�A�Y�D�h�^��false
	 * 2.�Y�O�A�A�ˬd���Student��id, name, grades�T���ܼƬO�_�����ۦP
	 *   �Y�O
	 * 
	 * Time estimate�GO(1)
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
	 * �p�⦹�ǥͪ��[�v��������
	 * 
	 * Pseudo code
	 * ��U����ƩM�����v�������n�@�[�`��A��ȵ�weightedGrade
	 * 
	 * Time estimate�GO(1)
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
