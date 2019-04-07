package integrationTest;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gradeSystem.Main;

public class integrationTest {

	/* Integration Test
	 * ���վ��{�����B�@
	 */
	
	private ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private PrintStream originalOut = System.out;

	@Before
	public void setUpStream()
	{
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void restoreStream()
	{
	    System.setOut(originalOut);
	}
	
	/* test1
	 * �H�@���ʪ��r��@�������ϥΪ̪�input�A����{����A
	 * ��w�����r��@assert equal
	 * 
	 * 1.�i�J�t�ΡG�w������w��e���βĤ@�h����
	 * 2.��J�Ǹ�962001051�G�w����ܲĤG�h����
	 * 3.��J1�G�w����ܩҦ���ؤ��ƫ�A��ܲĤG�h����
	 * 4.��J2�G�w����ܱƦW��A��ܲĤG�h����
	 * 5.��J3�G�w����ܥ[�v�������A��ܲĤG�h����
	 * 6.��J4�G�w����ܧ���v��������
	 * 7.���O��J���Ӭ�ت��v���G�w����ܽT�{�v��������
	 * 8.��Jy�G�w���v���w�Q��s�A����ܲĤG�h����
	 * 9.��J2�G�w����ܱƦW��]���ɪ��ƦW�����ܤj���v���ܤơ^�A��ܲĤG�h����
	 * 10.��J3�G�w����ܥ[�v�������]���ɪ������������ܤj���v���ܤơ^�A��ܲĤG�h����
	 * 11.��J5�G���X�Ǹ�962001051�������A�w������w��e���βĤ@�h����
	 * 12.��J�Ǹ�962001051�G�w����ܲĤG�h����
	 * 13.��J3�G�w����ܥ[�v�������]���ɪ����������P�W�@����s�L�᪺���ƬۦP�^�A��ܲĤG�h����
	 * 14.��Jk�G�����t��
	 */
	@Test
	public void test1()
	{
		String allInput = "962001051\n"
						+ "1\n"
						+ "2\n"
						+ "3\n"
						+ "4\n"
						+ "10\n15\n15\n30\n30\ny\n"
						+ "2\n"
						+ "3\n"
						+ "5\n"
						+ "962001051\n"
						+ "3\n"
						+ "k\n";
		ByteArrayInputStream allInputStream = new ByteArrayInputStream(allInput.getBytes());
		Main.setScannerSysIn(new Scanner(allInputStream));
		
		Main.main(null);
		
		String expect = "******************************\n"
				+ "Fantastic Console Grade System\n"
				+ "******************************\n"
				+ "Enter commands:\n"
				+ "[ID]: a 9-digits number\n"
				+ "K: Kill the program\n\n"

				+ "********************************\n"
				+ "Current inspecting ID: 962001051\n"
				+ "********************************\n"
				+ "Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n"
				+ "���§�'s grades are:\n"
				+ "Lab1:           81\n"
				+ "Lab2:           32*\n"
				+ "Lab3:           50*\n"
				+ "Midterm exam:   90\n"
				+ "Final exam:     93\n\n"

				+"********************************\n"
				+ "Current inspecting ID: 962001051\n"
				+ "********************************\n"
				+ "Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n"
				+ "���§�'s rank is:	12\n\n"

				+ "********************************\n"
				+ "Current inspecting ID: 962001051\n"
				+ "********************************\n"
				+ "Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n"
				+ "���§�'s average is:	69\n\n"

				+ "********************************\n"
				+ "Current inspecting ID: 962001051\n"
				+ "********************************\n"
				+ "Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n"
				+ "Current weights:\n"
				+ "Lab1:           20.0%\n"
				+ "Lab2:           20.0%\n"
				+ "Lab3:           20.0%\n"
				+ "Midterm exam:   20.0%\n"
				+ "Final exam:     20.0%\n\n"

				+ "Enter new weights:\n"
				+ "Lab1:	Lab2:	Lab3:	Midterm exam:	Final exam:\t\n"
				+ "Confirm new weights:\n"
				+ "Lab1:           10.0%\n"
				+ "Lab2:           15.0%\n"
				+ "Lab3:           15.0%\n"
				+ "Midterm exam:   30.0%\n"
				+ "Final exam:     30.0%\n"
				+ "Are the weights above correct? (y/n)\t\n"
				+ "********************************\n"
				+ "Current inspecting ID: 962001051\n"
				+ "********************************\n"
				+ "Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n"
				+ "���§�'s rank is:	14\n\n"

				+ "********************************\n"
				+ "Current inspecting ID: 962001051\n"
				+ "********************************\n"
				+ "Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n"
				+ "���§�'s average is:	75\n\n"

				+ "********************************\n"
				+ "Current inspecting ID: 962001051\n"
				+ "********************************\n"
				+ "Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n\n"

				+ "******************************\n"
				+ "Fantastic Console Grade System\n"
				+ "******************************\n"
				+ "Enter commands:\n"
				+ "[ID]: a 9-digits number\n"
				+ "K: Kill the program\n\n"

				+ "********************************\n"
				+ "Current inspecting ID: 962001051\n"
				+ "********************************\n"
				+ "Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n"
				+ "���§�'s average is:	75\n\n"

				+ "********************************\n"
				+ "Current inspecting ID: 962001051\n"
				+ "********************************\n"
				+ "Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n";

		assertEquals(expect, outContent.toString());
	}
	
	/* test2
	 * �H�@���ʪ��r��@�������ϥΪ̪�input�A����{����A
	 * ��w�����r��@assert equal
	 * 
	 * 1.�i�J�t�ΡG�w������w��e���βĤ@�h����
	 * 2.��J�Ǹ�985002201�G�w����ܲĤG�h����
	 * 3.��J1�G�w����ܩҦ���ؤ��ƫ�A��ܲĤG�h����
	 * 4.��J2�G�w����ܱƦW��A��ܲĤG�h����
	 * 5.��J3�G�w����ܥ[�v�������A��ܲĤG�h����
	 * 6.��J4�G�w����ܧ���v��������
	 * 7.���O��J���Ӭ�ت��v���A���v���M������100%�G�w������v���M���~�A���s��J�v��
	 * 8.���O��J�|�Ӭ�ت��v���A�Ĥ����v����J�D�k�r���]���O�Ʀr�^�G�w����ܫD�k�v���A���s��J�Ĥ����v��
	 * 9.��J�Ĥ��쪺���T�v���G�w����ܽT�{�v��������
	 * 10.��Jy�G�w���v���w�Q��s�A����ܲĤG�h����
	 * 11.��J2�G�w����ܱƦW��]���ɪ��ƦW�����ܤj���v���ܤơ^�A��ܲĤG�h����
	 * 12.��J3�G�w����ܥ[�v�������]���ɪ������������ܤj���v���ܤơ^�A��ܲĤG�h����
	 * 13.��J5�G���X�Ǹ�985002201�������A�w������w��e���βĤ@�h����
	 * 14.��J�s���Ǹ�962001051�G�w����ܲĤG�h����
	 * 15.��J2�G�w����ܱƦW�]�v���w��s�A���ƦW���Ptest1�����P�ӤH���ƦW���P�^�A��ܲĤG�h����
	 * 16.��Jk�G�����t��
	 */
	@Test
	public void test2()
	{
		String allInput = "985002201\n"
						+ "1\n"
						+ "2\n"
						+ "3\n"
						+ "4\n"
						+ "5\n5\n5\n40\n40\n"
						+ "5\n5\n5\n40\nfdsgdfgdf\n45\ny\n"
						+ "2\n"
						+ "3\n"
						+ "5\n"
						+ "962001051\n"
						+ "2\n"
						+ "k\n";
		ByteArrayInputStream allInputStream = new ByteArrayInputStream(allInput.getBytes());
		Main.setScannerSysIn(new Scanner(allInputStream));
		
		Main.main(null);
		
		String expect = "******************************\n"
				+ "Fantastic Console Grade System\n"
				+ "******************************\n"
				+ "Enter commands:\n"
				+ "[ID]: a 9-digits number\n"
				+ "K: Kill the program\n\n"

				+ "********************************\n"
				+ "Current inspecting ID: 985002201\n"
				+ "********************************\n"
				+ "Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n"
				+ "Ĭ�G's grades are:\n"
				+ "Lab1:           81\n"
				+ "Lab2:           91\n"
				+ "Lab3:           85\n"
				+ "Midterm exam:   84\n"
				+ "Final exam:     90\n\n"

				+ "********************************\n"
				+ "Current inspecting ID: 985002201\n"
				+ "********************************\n"
				+ "Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n"
				+ "Ĭ�G's rank is:	10\n\n"

				+ "********************************\n"
				+ "Current inspecting ID: 985002201\n"
				+ "********************************\n"
				+ "Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n"
				+ "Ĭ�G's average is:	87\n\n"

				+ "********************************\n"
				+ "Current inspecting ID: 985002201\n"
				+ "********************************\n"
				+ "Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n"
				+ "Current weights:\n"
				+ "Lab1:           10.0%\n"
				+ "Lab2:           15.0%\n"
				+ "Lab3:           15.0%\n"
				+ "Midterm exam:   30.0%\n"
				+ "Final exam:     30.0%\n\n"

				+ "Enter new weights:\n"
				+ "Lab1:	Lab2:	Lab3:	Midterm exam:	Final exam:	Invalid weights. Enter again:\n"
				+ "Lab1:	Lab2:	Lab3:	Midterm exam:	Final exam:	Weight should be a floating number.\n"
				+ "Final exam:\t\n"
				+ "Confirm new weights:\n"
				+ "Lab1:           5.0%\n"
				+ "Lab2:           5.0%\n"
				+ "Lab3:           5.0%\n"
				+ "Midterm exam:   40.0%\n"
				+ "Final exam:     45.0%\n"
				+ "Are the weights above correct? (y/n)\t\n"
				+ "********************************\n"
				+ "Current inspecting ID: 985002201\n"
				+ "********************************\n"
				+ "Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n"
				+ "Ĭ�G's rank is:	9\n\n"

				+ "********************************\n"
				+ "Current inspecting ID: 985002201\n"
				+ "********************************\n"
				+ "Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n"
				+ "Ĭ�G's average is:	87\n\n"

				+ "********************************\n"
				+ "Current inspecting ID: 985002201\n"
				+ "********************************\n"
				+ "Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n\n"

				+ "******************************\n"
				+ "Fantastic Console Grade System\n"
				+ "******************************\n"
				+ "Enter commands:\n"
				+ "[ID]: a 9-digits number\n"
				+ "K: Kill the program\n\n"

				+ "********************************\n"
				+ "Current inspecting ID: 962001051\n"
				+ "********************************\n"
				+ "Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n"
				+ "���§�'s rank is:	10\n\n"

				+ "********************************\n"
				+ "Current inspecting ID: 962001051\n"
				+ "********************************\n"
				+ "Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n";

		assertEquals(expect, outContent.toString());
	}
}
