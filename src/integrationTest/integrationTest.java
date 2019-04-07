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
	 * 測試整支程式的運作
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
	 * 以一次性的字串作為模擬使用者的input，執行程式後再
	 * 對預期的字串作assert equal
	 * 
	 * 1.進入系統：預期顯示歡迎畫面及第一層提示
	 * 2.輸入學號962001051：預期顯示第二層提示
	 * 3.輸入1：預期顯示所有科目分數後，顯示第二層提示
	 * 4.輸入2：預期顯示排名後，顯示第二層提示
	 * 5.輸入3：預期顯示加權平均分，顯示第二層提示
	 * 6.輸入4：預期顯示更改權重的提示
	 * 7.分別輸入五個科目的權重：預期顯示確認權重的提示
	 * 8.輸入y：預期權重已被更新，並顯示第二層提示
	 * 9.輸入2：預期顯示排名後（此時的排名應有很大機率有變化），顯示第二層提示
	 * 10.輸入3：預期顯示加權平均分（此時的平均分應有很大機率有變化），顯示第二層提示
	 * 11.輸入5：跳出學號962001051的介面，預期顯示歡迎畫面及第一層提示
	 * 12.輸入學號962001051：預期顯示第二層提示
	 * 13.輸入3：預期顯示加權平均分（此時的平均分應與上一次更新過後的分數相同），顯示第二層提示
	 * 14.輸入k：結束系統
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
				+ "李威廷's grades are:\n"
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
				+ "李威廷's rank is:	12\n\n"

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
				+ "李威廷's average is:	69\n\n"

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
				+ "李威廷's rank is:	14\n\n"

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
				+ "李威廷's average is:	75\n\n"

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
				+ "李威廷's average is:	75\n\n"

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
	 * 以一次性的字串作為模擬使用者的input，執行程式後再
	 * 對預期的字串作assert equal
	 * 
	 * 1.進入系統：預期顯示歡迎畫面及第一層提示
	 * 2.輸入學號985002201：預期顯示第二層提示
	 * 3.輸入1：預期顯示所有科目分數後，顯示第二層提示
	 * 4.輸入2：預期顯示排名後，顯示第二層提示
	 * 5.輸入3：預期顯示加權平均分，顯示第二層提示
	 * 6.輸入4：預期顯示更改權重的提示
	 * 7.分別輸入五個科目的權重，但權重和不等於100%：預期顯示權重和錯誤，重新輸入權重
	 * 8.分別輸入四個科目的權重，第五科權重輸入非法字元（不是數字）：預期顯示非法權重，重新輸入第五科權重
	 * 9.輸入第五科的正確權重：預期顯示確認權重的提示
	 * 10.輸入y：預期權重已被更新，並顯示第二層提示
	 * 11.輸入2：預期顯示排名後（此時的排名應有很大機率有變化），顯示第二層提示
	 * 12.輸入3：預期顯示加權平均分（此時的平均分應有很大機率有變化），顯示第二層提示
	 * 13.輸入5：跳出學號985002201的介面，預期顯示歡迎畫面及第一層提示
	 * 14.輸入新的學號962001051：預期顯示第二層提示
	 * 15.輸入2：預期顯示排名（權重已更新，此排名應與test1中的同個人之排名不同），顯示第二層提示
	 * 16.輸入k：結束系統
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
				+ "蘇亮's grades are:\n"
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
				+ "蘇亮's rank is:	10\n\n"

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
				+ "蘇亮's average is:	87\n\n"

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
				+ "蘇亮's rank is:	9\n\n"

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
				+ "蘇亮's average is:	87\n\n"

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
				+ "李威廷's rank is:	10\n\n"

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
