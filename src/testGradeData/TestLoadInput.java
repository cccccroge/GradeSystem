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

	@Test
	public void test1()
	{
		GradeData grade_data = new GradeData();
		assertTrue(grade_data.loadInput());
	}
	
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
