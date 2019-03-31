
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
			} else if (status == Status.SCORE) {
				showHintScore();
				String cmd = Main.scannerSysIn.next();
				handleScoreCmd(cmd);
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
		System.out.println(name + "'s grades are: " + grades[0]+ " " +
				grades[1] + " " + grades[2] + " " + grades[3] + " " + grades[4]);
	}
}
