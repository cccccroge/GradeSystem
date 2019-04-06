package testGradeData;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import gradeSystem.GradeData;
import gradeSystem.Student;

public class TestUpdateWeightedGrades {

	@Test
	public void test1() {
		GradeData grade_data = new GradeData();
		
		Student s1 = new Student("105062271", "何必問", new int[]{69, 77, 55, 0, 18});
		Student s2 = new Student("105062272", "何處尋", new int[]{56, 89, 85, 88, 87});
		Student s3 = new Student("105062273", "何大俠", new int[]{52, 0, 13, 14, 99});
		ArrayList<Student> list = new ArrayList<Student>(Arrays.asList(s1, s2, s3));
		grade_data.setStudentList(list);
		grade_data.updateWeightedGrades();
		
		int expect1 = Math.round(69*0.2f + 77*0.2f + 55*0.2f + 0*0.2f + 18*0.2f);
		assertEquals(expect1, list.get(0).getWeightedGrade());
		int expect2 = Math.round(56*0.2f + 89*0.2f + 85*0.2f + 88*0.2f + 87*0.2f);
		assertEquals(expect2, list.get(1).getWeightedGrade());
		int expect3 = Math.round(52*0.2f + 0*0.2f + 13*0.2f + 14*0.2f + 99*0.2f);
		assertEquals(expect3, list.get(2).getWeightedGrade());
	}

	@Test
	public void test2() {
		GradeData grade_data = new GradeData();
		
		Student s1 = new Student("105062271", "何必問", new int[]{23, 15, 100, 100, 2});
		Student s2 = new Student("105062272", "何處尋", new int[]{66, 89, 77, 12, 16});
		Student s3 = new Student("105062273", "何大俠", new int[]{9, 8, 7, 6, 5});
		ArrayList<Student> list = new ArrayList<Student>(Arrays.asList(s1, s2, s3));
		grade_data.setStudentList(list);
		Student.setWeights(new float[]{0.1f, 0.05f, 0.375f, 0.1f, 0.375f});
		grade_data.updateWeightedGrades();
		
		int expect1 = Math.round(23*0.1f + 15*0.05f + 100*0.375f + 100*0.1f + 2*0.375f);
		assertEquals(expect1, list.get(0).getWeightedGrade());
		int expect2 = Math.round(66*0.1f + 89*0.05f + 77*0.375f + 12*0.1f + 16*0.375f);
		assertEquals(expect2, list.get(1).getWeightedGrade());
		int expect3 = Math.round(9*0.1f + 8*0.05f + 7*0.375f + 6*0.1f + 5*0.375f);
		assertEquals(expect3, list.get(2).getWeightedGrade());
	}

}
