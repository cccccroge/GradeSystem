package testStudent;

import static org.junit.Assert.*;

import org.junit.Test;
import gradeSystem.Student;

public class testCompareTo {

	/* Unit Test
	 * 測試 int Student.compareTo(Student another)
	 */
	
	/* test1
	 * 1.加入兩位學生，前者分數較後者高，再呼叫s1.compareTo(s2)
	 * 2.前者平均分數減去後者會大於0，預期回傳值應大於0
	 * 3.assert true on (return value > 0)
	 */
	@Test
	public void test1() {
		Student s1 = new Student("962001051", "李威廷", new int[]{81, 32, 50, 90, 93});
		Student s2 = new Student("962001052", "李弱廷", new int[]{15, 32, 70, 100, 100});
		assertTrue(s1.compareTo(s2) > 0);
	}
	
	/* test2
	 * 1.加入兩位學生，兩者分數不同但初始加權分數相同，再呼叫s1.compareTo(s2)
	 * 2.前者平均分數減去後者會等於0，預期回傳值應等於0
	 * 3.assert true on (return value == 0)
	 */
	@Test
	public void test2() {
		Student s1 = new Student("962001051", "李威廷", new int[]{80, 80, 80, 80, 80});
		Student s2 = new Student("962001052", "李弱廷", new int[]{100, 60, 100, 60, 80});
		assertTrue(s1.compareTo(s2) == 0);
	}
	
	/* test3
	 * 1.加入兩位學生，兩者分數不同但初始加權分數相同，之後
	 *   再改變權重成有利於第二位學生的權重，並更新兩位學生
	 *   的加權分數，最後呼叫s1.compareTo(s2)
	 * 2.前者平均分數減去後者會小於0，預期回傳值應小於0
	 * 3.assert true on (return value < 0)
	 */
	@Test
	public void test3() {
		Student s1 = new Student("962001051", "李威廷", new int[]{80, 80, 80, 80, 80});
		Student s2 = new Student("962001052", "李弱廷", new int[]{100, 60, 100, 60, 80});
		Student.setWeights(new double[]{0.3, 0.1, 0.3, 0.1, 0.2});
		s1.evalWeightedGrade();
		s2.evalWeightedGrade();
		assertTrue(s1.compareTo(s2) < 0);
	}
}
