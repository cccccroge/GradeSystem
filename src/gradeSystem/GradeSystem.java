package gradeSystem;
import java.util.Arrays;

public class GradeSystem {
	
	// Fields
	private enum Status {
		START,
		SCORE,
		FINISH
	}
	private Status status;
	
	private Student current_student;
	private GradeData grade_data;
	
	// Constructor
	public GradeSystem()
	{
		status = Status.START;
		current_student = null;
		grade_data = new GradeData();
	}
	
	// Public Methods
	public void run()
	{
		while(!grade_data.loadInput()) {
			System.out.print("Failed to load grades input.\nFix setup and hit enter to try again.\n");
			Main.scannerSysIn.nextLine();
		}
		
		grade_data.evalRanks();
		
		while(true) {
			if (status == Status.START) {
				showHintStart();
				String cmd = Main.scannerSysIn.nextLine();
				if(handleStartCmd(cmd))
					break;
			} else if (status == Status.SCORE) {
				showHintScore();
				String cmd = Main.scannerSysIn.nextLine();
				if(handleScoreCmd(cmd))
					break;
			}
			System.out.print("\n");
		}
	}
	
	// Private Methods
	private void showHintStart()
	{
		System.out.print("******************************\n" 
					   + "Fantastic Console Grade System\n" 
					   + "******************************\n"
					   + "Enter commands:\n"
					   + "[ID]: a 9-digits number\n"
					   + "K: Kill the program\n");
	}
	
	private void showHintScore()
	{
		System.out.print("********************************\n" 
						 + "Current inspecting ID: " 
						 + current_student.getId() + "\n"  
						 + "********************************\n");
		System.out.print("Enter commands:\n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill\n");
	}
	
	private boolean handleStartCmd(String cmd)
	{
		switch(cmd) {
		case "k":
		case "K":
			return true;
		default:
			registerId(cmd);
			return false;
		}
	}
	
	private boolean handleScoreCmd(String cmd)
	{
		switch(cmd) {
		case "k":
		case "K":
			return true;
		case "1":
			showGrades();
			break;
		case "2":
			showRank();
			break;
		case "3":
			showAverage();
			break;
		case "4":
			updateWeights();
			grade_data.updateWeightedGrades();
			grade_data.evalRanks();
			break;
		case "5":
			status = Status.START;
			break;
		default:
			System.out.print("Command " + cmd + " doesn't exist.\n");
			handleScoreCmd(Main.scannerSysIn.nextLine());
		}
		return false;
	}
	
	private void showGrades()
	{
		String name = current_student.getName();
		int[] g = current_student.getGrades();
		String[] s = Student.getSubjects();
		
		System.out.print(name + "'s grades are:\n");
		for(int i = 0; i < g.length; ++i) {	
			System.out.printf("%-15s %s\n", s[i]+":", formattedScore(g[i]));
		}
	}
	
	private void showAverage()
	{
		String name = current_student.getName();
		int average = current_student.getWeightedGrade();
		System.out.print(name + "'s average is:\t" + average + "\n");
	}
	
	private void showRank()
	{
		String name = current_student.getName();
		int rank = current_student.getRank();
		System.out.print(name + "'s rank is:\t" + rank + "\n");
	}
	
	private void updateWeights()
	{
		while(true) {
			System.out.print("Current weights:\n");
			printWeights(Student.getWeights());
			
			System.out.print("\nEnter new weights:\n");
			double[] new_weights = readNewWeights();
			
			System.out.print("\nConfirm new weights:\n");
			printWeights(new_weights);
			System.out.print("Are the weights above correct? (y/n)\t");
			String cmd = Main.scannerSysIn.nextLine();
			if(cmd.equals("Y") || cmd.equals("y")) {
				Student.setWeights(new_weights);
				break;
			}
		}
	}
	
	private void registerId(String _str)
	{
		String str = _str;
		Student s = grade_data.getStudentById(str);
		while(s == null) {
			System.out.print(str + " is a wrong student ID. Please enter again.\n");
			str = Main.scannerSysIn.nextLine();
			s = grade_data.getStudentById(str);
		}
		current_student = s;
		status = Status.SCORE;
	}
	
	private String formattedScore(int score)
	{
		String s = Integer.toString(score);
		return (score >= 60) ? s : (s+"*");
	}
	
	private void printWeights(double[] _weights)
	{
		String[] subjects = Student.getSubjects();
		for(int i = 0; i < _weights.length; ++i) {
			System.out.printf("%-15s %.1f%%\n", subjects[i]+":", _weights[i]*100);
		}
	}
	
	private double[] readNewWeights()
	{
		double[] weights ={ -1, -1, -1, -1, -1 };
		// repeat read process until weights is valid
		while(true) {
			String[] s = Student.getSubjects();
			// each subject's weight
			for(int i = 0; i < s.length; ++i) {
				System.out.print(s[i] + ":\t");
				try {
					String str = Main.scannerSysIn.nextLine();
					weights[i] =  Double.parseDouble(str) / 100;
				} catch(Exception e) {
					System.out.print("Weight should be a floating number.\n");
					i -= 1;
				}
			}
			if(!isWeightsValid(weights)) {
				System.out.print("Invalid weights. Enter again:\n");
			} else if( Arrays.equals(weights, Student.getWeights()) ){
				System.out.print("Same weights as before. Enter again:\n");
			} else {
				break;
			}
		}
		
		return weights;
	}
	
	private boolean isWeightsValid(double[] _weights)
	{
		if(_weights.length != Student.getSubjects().length) {
			return false;
		}
		
		double sum = 0;
		for(double w : _weights) {
			sum += w;
		}
		return (sum == 1);
	}
	
	public GradeData getGradeData()
	{
		return grade_data;
	}
}
