package testGradeData;

import static org.junit.Assert.*;
import gradeSystem.GradeData;
import gradeSystem.Student;

import org.junit.Test;

public class TestGetStudentById {

	/* Unit Test
	 * ���� Student GradeData.getStudentById(String id)
	 */ 
	
	/* test1
	 * 1.��Ū�J�ɮסA������id��"10506227"���ǥ�
	 * 2.�]���Ǹ����F9��A�w���|�o��null
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
	 * 1.��Ū�J�ɮסA������id��"2.718"���ǥ�
	 * 2.�]���Ǹ����O�s���ơA�w���|�o��null
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
	 * 1.Ū�J�ɮסA��id��"962001051"���ǥ�
	 * 2.�}��input.txt�A�d�ݸӾǥͪ���ơA�ñj��إߤ@�ӲŦX�Ӹ�ƪ��ǥ�
	 * 3.assert equal on s
	 */
	@Test
	public void test3() 
	{
		GradeData grade_data = new GradeData();
		grade_data.loadInput();
		Student s = grade_data.getStudentById("962001051");
		Student s_expect = new Student("962001051", "���§�", new int[]{81, 32, 50, 90, 93});
		assertEquals(s_expect, s);
	}

}
