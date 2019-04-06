package testStudent;

import static org.junit.Assert.*;

import org.junit.Test;

import gradeSystem.Student;

public class TestEvalWeightedGrade {

	@Test
	public void test1()
	{
		Student s = new Student("105062271", "何必問", new int[]{69, 77, 55, 0, 18});
		Student.setWeights(new float[]{0.2f, 0.2f, 0.2f, 0.2f, 0.2f});
		s.evalWeightedGrade();
		int expected = Math.round(69*0.2f+77*0.2f+55*0.2f+0*0.2f+18*0.2f);
		assertEquals(expected, s.getWeightedGrade());
	}

	@Test
	public void test2()
	{
		Student s = new Student("105062271", "何必問", new int[]{69, 77, 55, 0, 18});
		Student.setWeights(new float[]{0, 0, 0, 0.5f, 0.5f});
		s.evalWeightedGrade();
		int expected = Math.round(18*0.5f);
		assertEquals(expected, s.getWeightedGrade());
	}
}
