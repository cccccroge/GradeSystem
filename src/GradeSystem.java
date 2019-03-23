public class GradeSystem {
	
	// member variables
	public enum Status {
		START,
		SCORE,
		FINISH
	}
	Status status;
	
	// member methods
	public GradeSystem(){
		status = Status.START;
	}
	
	public boolean run()
	{
		while(true) {
			if (status == Status.START) {
				showHintStart();
				String cmd = Main.scanner.next();
				handle_start(cmd);
			} else if (status == Status.SCORE) {
				showHintScore();
				String cmd = Main.scanner.next();
				handle_score(cmd);
			}
		}
	}
	
	private void showHintStart()
	{
		System.out.println("enter [ID] or 'K' to kill");
	}
	
	private void showHintScore()
	{
		System.out.println("enter command: \n"
				+ "1: Grade\n"
				+ "2: Rank\n"
				+ "3: Average\n"
				+ "4: Update weights\n"
				+ "5: Exit\n"
				+ "K: Kill");
	}
	
	private void handle_start(String cmd)
	{
		switch(cmd) {
		case "K":
			kill();
		default:
			handle_id(cmd);
		}
	}
	
	private void kill()
	{
		System.exit(0);
	}
	
	
	private void handle_id(String str)
	{
		if (!checkID(str)) {
			System.out.println("Wrong student ID. Please enter again.");
		} else {
			System.out.println("Id is: " + str);
			status = Status.SCORE;
		}
	}
	
	private boolean checkID(String id)
	{
		return true;
	}
	
	private void handle_score(String cmd)
	{
		switch(cmd) {
		case "K":
			kill();
		case "5":
			status = Status.START;
			
		}
	}
	
}