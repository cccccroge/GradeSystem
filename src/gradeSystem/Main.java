package gradeSystem;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import javafx.scene.shape.Path;

public class Main {
	
	// globals
	public static Scanner scannerSysIn = new Scanner(System.in);
	
	// main
    public static void main(String[] args)
    {	/*
		GradeSystem gradeSystem = new GradeSystem();
		gradeSystem.run();
		scannerSysIn.close();*/
    	try {
			java.nio.file.Path p = Files.move(Paths.get("input.txt"), Paths.get("../input.txt"), StandardCopyOption.ATOMIC_MOVE);
			System.out.println(p.toAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}