import java.util.Scanner;

public class Main {
	
	// globals
	public static Scanner scannerSysIn = new Scanner(System.in);
	
	// main
    public static void main(String[] args)
    {	
		GradeSystem gradeSystem = new GradeSystem();
		gradeSystem.run();
		scannerSysIn.close();
    }

}