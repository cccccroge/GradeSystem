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
				+ "§õ«Â§Ê's grades are:\n"
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
				+ "§õ«Â§Ê's rank is:	12\n\n"

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
				+ "§õ«Â§Ê's average is:	69\n\n"

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
				+ "§õ«Â§Ê's rank is:	14\n\n"

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
				+ "§õ«Â§Ê's average is:	75\n\n"

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
				+ "§õ«Â§Ê's average is:	75\n\n"

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
				+ "Ä¬«G's grades are:\n"
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
				+ "Ä¬«G's rank is:	10\n\n"

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
				+ "Ä¬«G's average is:	87\n\n"

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
				+ "Ä¬«G's rank is:	9\n\n"

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
				+ "Ä¬«G's average is:	87\n\n"

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
				+ "§õ«Â§Ê's rank is:	10\n\n"

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
