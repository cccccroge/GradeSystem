package testStudent;

import static org.junit.Assert.*;

import org.junit.Test;

import gradeSystem.Student;

public class TestEquals {

	@Test
	public void test1()
	{
		Student s1 = new Student("105062271", "何必問", new int[]{69, 77, 55, 0, 18});
		Student s2 = new Student("105062272", "何處尋", new int[]{56, 89, 85, 88, 87});
		assertFalse(s1.equals(s2));
	}
	
	@Test
	public void test2()
	{
		Student s1 = new Student("105062272", "何處尋", new int[]{69, 77, 55, 0, 18});
		Student s2 = new Student("105062272", "何處尋", new int[]{69, 77, 55, 0, 18});
		assertTrue(s1.equals(s2));
	}

}
