package testGradeData;

import static org.junit.Assert.*;
import gradeSystem.GradeData;
import gradeSystem.Student;

import org.junit.Test;

public class TestGetStudentById {

	/* Unit Test
	 * 測試 Student GradeData.getStudentById(String id)
	 */ 
	
	/* test1
	 * 1.不讀入檔案，直接拿id為"10506227"的學生
	 * 2.因為學號不達9位，預期會得到null
	 * 3.assert null on s
	 */
	@Test
	public void test1() 
	{
		GradeData grade_data = new GradeData();
		Student s = grade_data.getStudentById("10506227");
		assertNull(s);
	}
	
	/* test2
	 * 1.不讀入檔案，直接拿id為"2.718"的學生
	 * 2.因為學號不是連續整數，預期會得到null
	 * 3.assert null on s
	 */
	@Test
	public void test2() 
	{
		GradeData grade_data = new GradeData();
		Student s = grade_data.getStudentById("2.718");
		assertNull(s);
	}
	
	/* test3
	 * 1.讀入檔案，拿id為"962001051"的學生
	 * 2.開啟input.txt，查看該學生的資料，並強制建立一個符合該資料的學生
	 * 3.assert equal on s
	 */
	@Test
	public void test3() 
	{
		GradeData grade_data = new GradeData();
		grade_data.loadInput();
		Student s = grade_data.getStudentById("962001051");
		Student s_expect = new Student("962001051", "李威廷", new int[]{81, 32, 50, 90, 93});
		assertEquals(s_expect, s);
	}

}
