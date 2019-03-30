import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
	
	// globals
	public static Scanner scannerSysIn = new Scanner(System.in);
	public static boolean isDigits(String str)
	{
		return str.matches("\\d+");
	}
	
	// main
    public static void main(String[] args)
    {
    	/*String filename="input.txt";
        Path pathToFile = Paths.get(filename);
        System.out.println(pathToFile.getAbsolutePath());*/
    	
		GradeSystem gradeSystem = new GradeSystem();
		gradeSystem.run();
    }

}