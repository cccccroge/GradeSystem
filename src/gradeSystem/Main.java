package gradeSystem;
import java.util.Scanner;

public class Main {
	
	// globals
	public static Scanner scannerSysIn = new Scanner(System.in);
	
	// Entry Point
    public static void main(String[] args)
    {	
    	/*double[] weights ={ -1, -1, -1, -1, -1 };
    	String s1 = "30";
    	String s2 = "30";
    	String s3 = "15";
    	String s4 = "15";
    	String s5 = "10";
    	weights[0] =  Double.parseDouble(s1) / 100;
    	weights[1] =  Double.parseDouble(s2) / 100;
    	weights[2] =  Double.parseDouble(s3) / 100;
    	weights[3] =  Double.parseDouble(s4) / 100;
    	weights[4] =  Double.parseDouble(s5) / 100;
    	double sum = 0;
		for(double w : weights) {
			sum += w;
		}
    	System.out.println(sum == 1);*/
    	
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