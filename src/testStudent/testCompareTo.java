package testStudent;

import static org.junit.Assert.*;

import org.junit.Test;
import gradeSystem.Student;

public class testCompareTo {

	/* Unit Test
	 * ���� int Student.compareTo(Student another)
	 */
	
	/* test1
	 * 1.�[�J���ǥ͡A�e�̤��Ƹ���̰��A�A�I�ss1.compareTo(s2)
	 * 2.�e�̥������ƴ�h��̷|�j��0�A�w���^�ǭ����j��0
	 * 3.assert true on (return value > 0)
	 */
	@Test
	public void test1() {
		Student s1 = new Student("962001051", "���§�", new int[]{81, 32, 50, 90, 93});
		Student s2 = new Student("962001052", "���z��", new int[]{15, 32, 70, 100, 100});
		assertTrue(s1.compareTo(s2) > 0);
	}
	
	/* test2
	 * 1.�[�J���ǥ͡A��̤��Ƥ��P����l�[�v���ƬۦP�A�A�I�ss1.compareTo(s2)
	 * 2.�e�̥������ƴ�h��̷|����0�A�w���^�ǭ�������0
	 * 3.assert true on (return value == 0)
	 */
	@Test
	public void test2() {
		Student s1 = new Student("962001051", "���§�", new int[]{80, 80, 80, 80, 80});
		Student s2 = new Student("962001052", "���z��", new int[]{100, 60, 100, 60, 80});
		assertTrue(s1.compareTo(s2) == 0);
	}
	
	/* test3
	 * 1.�[�J���ǥ͡A��̤��Ƥ��P����l�[�v���ƬۦP�A����
	 *   �A�����v�������Q��ĤG��ǥͪ��v���A�ç�s���ǥ�
	 *   ���[�v���ơA�̫�I�ss1.compareTo(s2)
	 * 2.�e�̥������ƴ�h��̷|�p��0�A�w���^�ǭ����p��0
	 * 3.assert true on (return value < 0)
	 */
	@Test
	public void test3() {
		Student s1 = new Student("962001051", "���§�", new int[]{80, 80, 80, 80, 80});
		Student s2 = new Student("962001052", "���z��", new int[]{100, 60, 100, 60, 80});
		Student.setWeights(new double[]{0.3, 0.1, 0.3, 0.1, 0.2});
		s1.evalWeightedGrade();
		s2.evalWeightedGrade();
		assertTrue(s1.compareTo(s2) < 0);
	}
}
