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
		
		int expect1 = (int) Math.round(69*0.2 + 77*0.2 + 55*0.2 + 0*0.2 + 18*0.2);
		assertEquals(expect1, list.get(0).getWeightedGrade());
		int expect2 = (int) Math.round(56*0.2 + 89*0.2 + 85*0.2 + 88*0.2 + 87*0.2);
		assertEquals(expect2, list.get(1).getWeightedGrade());
		int expect3 = (int) Math.round(52*0.2 + 0*0.2 + 13*0.2 + 14*0.2 + 99*0.2);
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
		Student.setWeights(new double[]{0.1, 0.05, 0.375, 0.1, 0.375});
		grade_data.updateWeightedGrades();
		
		int expect1 = (int) Math.round(23*0.1 + 15*0.05 + 100*0.375 + 100*0.1 + 2*0.375);
		assertEquals(expect1, list.get(0).getWeightedGrade());
		int expect2 = (int) Math.round(66*0.1 + 89*0.05 + 77*0.375 + 12*0.1 + 16*0.375);
		assertEquals(expect2, list.get(1).getWeightedGrade());
		int expect3 = (int) Math.round(9*0.1 + 8*0.05 + 7*0.375 + 6*0.1 + 5*0.375);
		assertEquals(expect3, list.get(2).getWeightedGrade());
	}

}
