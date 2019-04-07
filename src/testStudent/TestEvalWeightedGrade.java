package testStudent;

import static org.junit.Assert.*;

import org.junit.Test;

import gradeSystem.Student;

public class TestEvalWeightedGrade {

	/* Unit Test
	 * ���� void Student.evalWeightedGrade()
	 */
	
	/* test1
	 * 1.�[�J�@���N���ƪ��ǥ͡A���mstatic���v�����U��20%�A�I�ss.evalWeightedGrade()
	 * 2.�t�~�H�����ƩM�[�v�p��X�[�v����
	 * 3.assert equal on �H�W��ӭ�
	 */
	@Test
	public void test1()
	{
		Student s = new Student("105062271", "�󥲰�", new int[]{69, 77, 55, 0, 18});
		Student.setWeights(new double[]{0.2, 0.2, 0.2, 0.2, 0.2});
		s.evalWeightedGrade();
		int expected = (int) Math.round(69*0.2+77*0.2+55*0.2+0*0.2+18*0.2);
		assertEquals(expected, s.getWeightedGrade());
	}

	/* test2
	 * 1.�[�J�@���N���ƪ��ǥ͡A����static���v����
	 *   0% 0% 0% 50% 50%�A�A�I�ss.evalWeightedGrade()
	 * 2.�t�~�H�����ƩM�[�v�p��X�[�v����
	 * 3.assert equal on �H�W��ӭ�
	 */
	@Test
	public void test2()
	{
		Student s = new Student("105062271", "�󥲰�", new int[]{69, 77, 55, 0, 18});
		Student.setWeights(new double[]{0, 0, 0, 0.5, 0.5});
		s.evalWeightedGrade();
		int expected = Math.round(18*0.5f);
		assertEquals(expected, s.getWeightedGrade());
	}
}
