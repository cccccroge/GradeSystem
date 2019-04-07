package testStudent;

import static org.junit.Assert.*;

import org.junit.Test;

import gradeSystem.Student;

public class TestEvalWeightedGrade {

	@Test
	public void test1()
	{
		Student s = new Student("105062271", "何必問", new int[]{69, 77, 55, 0, 18});
		Student.setWeights(new double[]{0.2, 0.2, 0.2, 0.2, 0.2});
		s.evalWeightedGrade();
		int expected = (int) Math.round(69*0.2+77*0.2+55*0.2+0*0.2+18*0.2);
		assertEquals(expected, s.getWeightedGrade());
	}

	@Test
	public void test2()
	{
		Student s = new Student("105062271", "何必問", new int[]{69, 77, 55, 0, 18});
		Student.setWeights(new double[]{0, 0, 0, 0.5, 0.5});
		s.evalWeightedGrade();
		int expected = Math.round(18*0.5f);
		assertEquals(expected, s.getWeightedGrade());
	}
	
	@Test
	public void test3()
	{
		Student s = new Student("985002201", "蘇亮", new int[]{81, 91, 85, 84, 90});
		Student.setWeights(new double[]{0.2, 0.2, 0.2, 0.2, 0.2});
		s.evalWeightedGrade();
		int expected = 86;
		assertEquals(expected, s.getWeightedGrade());
	}
}
