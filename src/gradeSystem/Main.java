package gradeSystem;
import java.util.Scanner;

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