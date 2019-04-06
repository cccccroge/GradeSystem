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
			System.out.println("Failed to load grades input.\nFix setup and hit enter to try again.");
			Main.scannerSysIn.nextLine();
		}
		
		grade_data.evalRanks();
		
		while(true) {
			if (status == Status.START) {
				showHintStart();
				String cmd = Main.scannerSysIn.nextLine();
				handleStartCmd(cmd);
			} else if (status == Status.SCORE) {
				showHintScore();
				String cmd = Main.scannerSysIn.nextLine();
				handleScoreCmd(cmd);
			}
			System.out.print("\n");
		}
	}
	
	// Private Methods
	private void showHintStart()
	{
		System.out.println("******************************\n" 
						 + "Fantastic Console Grade System\n" 
						 + "******************************");
		System.out.println("Enter commands:");
		System.out.println("[ID]: a 9-digits number\n" + 
						   "K: Kill the program");
	}
	
	private void showHintScore()
	{
		System.out.println("********************************\n" 
						 + "Current inspecting ID: " 
						 + current_student.getId() + "\n"  
						 + "********************************");
		System.out.println("Enter commands: \n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill");
	}
	
	private void handleStartCmd(String cmd)
	{
		switch(cmd) {
		case "k":
		case "K":
			System.exit(0);
			break;
		default:
			registerId(cmd);
		}
	}
	
	private void handleScoreCmd(String cmd)
	{
		switch(cmd) {
		case "k":
		case "K":
			System.exit(0);
			break;
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
			System.out.println("Command " + cmd + " doesn't exist.");
			handleScoreCmd(Main.scannerSysIn.nextLine());
		}
	}
	
	private void showGrades()
	{
		String name = current_student.getName();
		int[] g = current_student.getGrades();
		String[] s = Student.getSubjects();
		
		System.out.println(name + "'s grades are:");
		for(int i = 0; i < g.length; ++i) {	
			System.out.printf("%-15s %s\n", s[i]+":", formattedScore(g[i]));
		}
	}
	
	private void showAverage()
	{
		String name = current_student.getName();
		int average = current_student.getWeightedGrade();
		System.out.println(name + "'s average is:\t" + average);
	}
	
	private void showRank()
	{
		String name = current_student.getName();
		int rank = current_student.getRank();
		System.out.println(name + "'s rank is:\t" + rank);
	}
	
	private void updateWeights()
	{
		while(true) {
			System.out.println("Current weights:");
			printWeights(Student.getWeights());
			
			System.out.println("\nEnter new weights:");
			float[] new_weights = readNewWeights();
			
			System.out.println("\nConfirm new weights:");
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
			System.out.println(str + " is a wrong student ID. Please enter again.");
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
	
	private void printWeights(float[] _weights)
	{
		String[] subjects = Student.getSubjects();
		for(int i = 0; i < _weights.length; ++i) {
			System.out.printf("%-15s %.1f%%\n", subjects[i]+":", _weights[i]*100);
		}
	}
	
	private float[] readNewWeights()
	{
		float[] weights ={ -1, -1, -1, -1, -1 };
		// repeat read process until weights is valid
		while(true) {
			String[] s = Student.getSubjects();
			// each subject's weight
			for(int i = 0; i < s.length; ++i) {
				System.out.print(s[i] + ":\t");
				try {
					String str = Main.scannerSysIn.nextLine();
					weights[i] =  Float.parseFloat(str) / 100f;
				} catch(Exception e) {
					System.out.println("Weight should be a floating numbers.");
					i -= 1;
				}
			}
			if(!isWeightsValid(weights)) {
				System.out.println("Invalid weights. Enter again:");
			} else if( Arrays.equals(weights, Student.getWeights()) ){
				System.out.println("Same weights as before. Enter again:");
			} else {
				break;
			}
		}
		
		return weights;
	}
	
	private boolean isWeightsValid(float[] _weights)
	{
		if(_weights.length != Student.getSubjects().length) {
			return false;
		}
		
		float sum = 0;
		for(float w : _weights) {
			sum += w;
		}
		return (sum == 1);
	}
}