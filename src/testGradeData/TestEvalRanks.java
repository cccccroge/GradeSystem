package testGradeData;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import gradeSystem.GradeData;
import gradeSystem.Student;

public class TestEvalRanks {

	/* Unit Test
	 * 測試 void GradeData.evalRanks()
	 */ 
	
	/* test1
	 * 1.隨意新增三位不同分數的學生並放入list中，呼叫grade_data.evalRanks();
	 * 2.手動算三位學生的平均分並排名
	 * 3.assert equal on 三位學生的rank
	 */
	@Test
	public void test1() {
		GradeData grade_data = new GradeData();
		
		Student s1 = new Student("105062271", "何必問", new int[]{69, 77, 55, 0, 18});
		Student s2 = new Student("105062272", "何處尋", new int[]{56, 89, 85, 88, 87});
		Student s3 = new Student("105062273", "何大俠", new int[]{52, 0, 13, 14, 99});
		ArrayList<Student> list = new ArrayList<Student>(Arrays.asList(s1, s2, s3));
		grade_data.setStudentList(list);
		grade_data.evalRanks();
		
		assertEquals(2, s1.getRank());
		assertEquals(1, s2.getRank());
		assertEquals(3, s3.getRank());
	}

	/* test2
	 * 1.隨意新增三位不同分數，但平均分相同的學生並放入list中，呼叫grade_data.evalRanks();
	 * 2.三位學生平均分相同，預期三位學生的rank皆為第一
	 * 3.assert equal on 三位學生的rank
	 */
	@Test
	public void test2() {
		GradeData grade_data = new GradeData();
		
		Student s1 = new Student("105062271", "何必問", new int[]{50, 50, 50, 50, 50});
		Student s2 = new Student("105062272", "何處尋", new int[]{100, 100, 50, 0, 0});
		Student s3 = new Student("105062273", "何大俠", new int[]{0, 0, 50, 100, 100});
		ArrayList<Student> list = new ArrayList<Student>(Arrays.asList(s1, s2, s3));
		grade_data.setStudentList(list);
		grade_data.evalRanks();
		
		assertEquals(1, s1.getRank());
		assertEquals(1, s2.getRank());
		assertEquals(1, s3.getRank());
	}
}
