package testGradeData;

import static org.junit.Assert.*;
import gradeSystem.GradeData;
import gradeSystem.Student;

import org.junit.Test;

public class TestGetStudentById {

	@Test
	public void test1() 
	{
		GradeData grade_data = new GradeData();
		Student s = grade_data.getStudentById("10506227");
		assertNull(s);
	}
	
	@Test
	public void test2() 
	{
		GradeData grade_data = new GradeData();
		Student s = grade_data.getStudentById("2.718");
		assertNull(s);
	}
	
	@Test
	public void test3() 
	{
		GradeData grade_data = new GradeData();
		grade_data.loadInput();
		Student s = grade_data.getStudentById("962001051");
		Student s_expect = new Student("962001051", "§õ«Â§Ê", new int[]{81, 32, 50, 90, 93});
		assertEquals(s_expect, s);
	}

}
