package testStudent;

import static org.junit.Assert.*;

import org.junit.Test;

import gradeSystem.Student;

public class TestEquals {

	/* Unit Test
	 * ���� boolean Student.equals(Object o)
	 */
	
	/* test1
	 * 1.�s�W���ǥ͡A��̸�T���P
	 * 2.�w�����۵�
	 * 3.assert false on return value
	 */
	@Test
	public void test1()
	{
		Student s1 = new Student("105062271", "�󥲰�", new int[]{69, 77, 55, 0, 18});
		Student s2 = new Student("105062272", "��B�M", new int[]{56, 89, 85, 88, 87});
		assertFalse(s1.equals(s2));
	}
	
	/* test2
	 * 1.�s�W���ǥ͡A��̸�T�ۦP
	 * 2.�w���۵�
	 * 3.assert true on return value
	 */
	@Test
	public void test2()
	{
		Student s1 = new Student("105062272", "��B�M", new int[]{69, 77, 55, 0, 18});
		Student s2 = new Student("105062272", "��B�M", new int[]{69, 77, 55, 0, 18});
		assertTrue(s1.equals(s2));
	}

}
