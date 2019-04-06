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
	
	// Entry Point
    public static void main(String[] args)
    {	
		GradeSystem gradeSystem = new GradeSystem();
		gradeSystem.run();
		scannerSysIn.close();
    }
    
    // Setters for redirect input
    public static void setScannerSysIn(Scanner scanner)
    {
    	scannerSysIn = scanner;
    }
}