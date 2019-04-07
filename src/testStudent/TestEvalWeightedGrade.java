package testStudent;

import static org.junit.Assert.*;

import org.junit.Test;

import gradeSystem.Student;

public class TestEvalWeightedGrade {

	/* Unit Test
	 * 測試 void Student.evalWeightedGrade()
	 */
	
	/* test1
	 * 1.加入一任意分數的學生，重置static的權重為各佔20%，呼叫s.evalWeightedGrade()
	 * 2.另外以此分數和加權計算出加權分數
	 * 3.assert equal on 以上兩個值
	 */
	@Test
	public void test1()
	{
		Student s = new Student("105062271", "何必問", new int[]{69, 77, 55, 0, 18});
		Student.setWeights(new double[]{0.2, 0.2, 0.2, 0.2, 0.2});
		s.evalWeightedGrade();
		int expected = (int) Math.round(69*0.2+77*0.2+55*0.2+0*0.2+18*0.2);
		assertEquals(expected, s.getWeightedGrade());
	}

	/* test2
	 * 1.加入一任意分數的學生，改變static的權重為
	 *   0% 0% 0% 50% 50%，再呼叫s.evalWeightedGrade()
	 * 2.另外以此分數和加權計算出加權分數
	 * 3.assert equal on 以上兩個值
	 */
	@Test
	public void test2()
	{
		Student s = new Student("105062271", "何必問", new int[]{69, 77, 55, 0, 18});
		Student.setWeights(new double[]{0, 0, 0, 0.5, 0.5});
		s.evalWeightedGrade();
		int expected = Math.round(18*0.5f);
		assertEquals(expected, s.getWeightedGrade());
	}
}
