package gradeSystem;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class GradeData {

	// Fields
	private ArrayList<Student> studentList;
	
	// Constructor
	public GradeData()
	{
		studentList = new ArrayList<Student>();
	}
	
	// Public Methods
	public boolean loadInput()
	{
		try {
			Path path = Paths.get("input.txt");
			Scanner fileScanner = new Scanner(path, "utf-8");
			while(fileScanner.hasNextLine())
			{
				String[] strings = fileScanner.nextLine().split(" ");
				int[] grade = { Integer.parseInt(strings[2]), Integer.parseInt(strings[3]),
						Integer.parseInt(strings[4]), Integer.parseInt(strings[5]), Integer.parseInt(strings[6])};
				Student p = new Student(strings[0], strings[1], grade);
				studentList.add(p);
			}
			
			fileScanner.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	public Student getStudentById(String id)
	{
		if(!isIdValid(id)) {
			return null;
		}
		
		for(Student s : studentList) {
			if(s.getId().equals(id)) {
				return s;
			}
		}
		
		return null;
	}
	
	public void updateWeightedGrades()
	{
		for(Student s : studentList) {
			s.evalWeightedGrade();
		}
	}
	
	public void evalRanks()
	{
		Collections.sort(studentList);
		
		int rank = 0;
		Student prev_student = null;
		for(int i = studentList.size()-1; i != -1; --i) {
			Student cur_student = studentList.get(i);
			if(prev_student == null 
				|| cur_student.getWeightedGrade() != prev_student.getWeightedGrade()) {
				rank += 1;
			}
			cur_student.setRank(rank);
			prev_student = cur_student;
		}
	}
	
	// Private Methods
	private boolean isIdValid(String id)
	{
		if (!id.matches("\\d+")) {
			return false;
		} else if (id.length() != 9) {
			return false;
		} else {
			return true;
		}
	}
	
	// Getters & Setters
	public void setStudentList(ArrayList<Student> _studentList)
	{
		studentList = _studentList;
	}
}
