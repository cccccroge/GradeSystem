package testStudent;

import static org.junit.Assert.*;

import org.junit.Test;
import gradeSystem.Student;

public class testCompareTo {

	@Test
	public void test1() {
		Student s1 = new Student("962001051", "§õ«Â§Ê", new int[]{81, 32, 50, 90, 93});
		Student s2 = new Student("962001052", "§õ®z§Ê", new int[]{15, 32, 70, 100, 100});
		assertTrue(s1.compareTo(s2) > 0);
	}
	
	@Test
	public void test2() {
		Student s1 = new Student("962001051", "§õ«Â§Ê", new int[]{80, 80, 80, 80, 80});
		Student s2 = new Student("962001052", "§õ®z§Ê", new int[]{100, 60, 100, 60, 80});
		assertTrue(s1.compareTo(s2) == 0);
	}
	
	@Test
	public void test3() {
		Student s1 = new Student("962001051", "§õ«Â§Ê", new int[]{80, 80, 80, 80, 80});
		Student s2 = new Student("962001052", "§õ®z§Ê", new int[]{100, 60, 100, 60, 80});
		Student.setWeights(new double[]{0.3, 0.1, 0.3, 0.1, 0.2});
		s1.evalWeightedGrade();
		s2.evalWeightedGrade();
		assertTrue(s1.compareTo(s2) < 0);
	}
}
