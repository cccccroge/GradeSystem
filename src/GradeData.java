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
			Path path = Paths.get("input.txt") ;		
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
			e.printStackTrace();
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
		
		int total = studentList.size();
		for(int i = 0; i < total; ++i) {
			studentList.get(i).setRank(total - i);
		}
	}
	
	// Private Methods
	private boolean isIdValid(String id)
	{
		if (!Main.isDigits(id)) {
			return false;
		} else if (id.length() != 9) {
			return false;
		} else {
			return true;
		}
	}
	
}
