
public class GradeSystem {
	
	// Fields
	public enum Status {
		START,
		SCORE,
		FINISH
	}
	Status status;
	
	Person current_person;
	GradeData grade_data;
	
	
	// Constructor
	public GradeSystem()
	{
		status = Status.START;
		current_person = null;
		grade_data = new GradeData();
	}
	
	// Public Methods
	public boolean run()
	{
		while(!grade_data.loadInput()) {
			System.out.println("Failed to load grades input.\nFix setup and hit enter to try again.");
			Main.scannerSysIn.nextLine();
		}
		
		while(true) {
			if (status == Status.START) {
				showHintStart();
				String cmd = Main.scannerSysIn.next();
				handleStartCmd(cmd);
				System.out.print("\n");
			} else if (status == Status.SCORE) {
				showHintScore();
				String cmd = Main.scannerSysIn.next();
				handleScoreCmd(cmd);
				System.out.print("\n");
			}
		}
	}
	
	// Private Methods
	private void showHintStart()
	{
		System.out.println("enter [ID] or 'K' to kill");
	}
	
	private void showHintScore()
	{
		System.out.println("Current ID: " + current_person.getId());
		System.out.println("enter commands: \n"
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
		case "K":
			System.exit(0);
			break;
		default:
			registerId(cmd);
		}
	}
	
	private void registerId(String id)
	{
		Person p = grade_data.getPersonById(id);
		
		if (p == null) {
			System.out.println(id + " is a wrong student ID. Please enter again.");
		} else {
			current_person = p;
			status = Status.SCORE;
		}
	}
	
	private void handleScoreCmd(String cmd)
	{
		switch(cmd) {
		case "K":
			System.exit(0);
			break;
		case "1":
			showGrades();
			break;
		case "5":
			status = Status.START;
			break;
		}
	}
	
	private void showGrades()
	{
		String name = current_person.getName();
		int[] grades = current_person.getGrades();
		int total = current_person.getWeightedGrade();
		System.out.println(name + "'s grades are: \n" + 
				"Lab1:\t" + formattedScore(grades[0])+ "\n" +
				"Lab2:\t" + formattedScore(grades[1])+ "\n" +
				"Lab3:\t" + formattedScore(grades[2])+ "\n" +
				"Midterm exam:\t" + formattedScore(grades[3])+ "\n" +
				"Final exam:\t" + formattedScore(grades[4]) + "\n" +
				"Total grade:\t" + formattedScore(total));
	}
	
	private String formattedScore(int score)
	{
		String s = Integer.toString(score);
		return (score >= 60) ? s : (s+"*");
	}
}
