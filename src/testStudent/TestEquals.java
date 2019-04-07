package testStudent;

import static org.junit.Assert.*;

import org.junit.Test;

import gradeSystem.Student;

public class TestEquals {

	/* Unit Test
	 * 測試 boolean Student.equals(Object o)
	 */
	
	/* test1
	 * 1.新增兩位學生，兩者資訊不同
	 * 2.預期不相等
	 * 3.assert false on return value
	 */
	@Test
	public void test1()
	{
		Student s1 = new Student("105062271", "何必問", new int[]{69, 77, 55, 0, 18});
		Student s2 = new Student("105062272", "何處尋", new int[]{56, 89, 85, 88, 87});
		assertFalse(s1.equals(s2));
	}
	
	/* test2
	 * 1.新增兩位學生，兩者資訊相同
	 * 2.預期相等
	 * 3.assert true on return value
	 */
	@Test
	public void test2()
	{
		Student s1 = new Student("105062272", "何處尋", new int[]{69, 77, 55, 0, 18});
		Student s2 = new Student("105062272", "何處尋", new int[]{69, 77, 55, 0, 18});
		assertTrue(s1.equals(s2));
	}

}
