package testGradeData;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.junit.Test;
import gradeSystem.GradeData;

public class TestLoadInput {

	/* Unit Test
	 * 測試  boolean GradeData.loadInput()
	 */ 
	
	/* test1
	 * 1.直接呼叫grade_data.loadInput()，正常讀入檔案
	 * 2.不會有exception，預期回傳true
	 * 3.assert true on return value
	 */
	@Test
	public void test1()
	{
		GradeData grade_data = new GradeData();
		assertTrue(grade_data.loadInput());
	}
	
	/* test2
	 * 1.強制將檔案移至上一層的位置，再呼叫grade_data.loadInput()
	 * 2.將會catch exception，預期回傳false
	 * 3.assert false on return value
	 */
	@Test
	public void test2()
	{
		GradeData grade_data = new GradeData();
		Path source_path = Paths.get("input.txt");
		Path target_path = Paths.get("../input.txt");
		try {
			Files.move(source_path, target_path, StandardCopyOption.ATOMIC_MOVE);
			assertFalse(grade_data.loadInput());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				Files.move(target_path, source_path, StandardCopyOption.ATOMIC_MOVE);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
