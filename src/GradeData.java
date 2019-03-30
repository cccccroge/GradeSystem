import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class GradeData {

	// Fields
	ArrayList<Person> personList;
	
	// Constructor
	public GradeData()
	{
		personList = new ArrayList<Person>();
	}
	
	// Public Methods
	public boolean loadInput()
	{
		try {
			Path path = Paths.get("src/input.txt");
			Scanner fileScanner = new Scanner(path, "utf-8");
			while(fileScanner.hasNextLine())
			{
				String[] strings = fileScanner.nextLine().split(" ");
				int[] grade = { Integer.parseInt(strings[2]), Integer.parseInt(strings[3]),
						Integer.parseInt(strings[4]), Integer.parseInt(strings[5]), Integer.parseInt(strings[6])};
				Person p = new Person(strings[0], strings[1], grade);
				personList.add(p);
			}
			
			fileScanner.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Person getPersonById(String id)
	{
		if(!isIdValid(id)) {
			return null;
		}
		
		for(Object obj : personList) {
			if(((Person)obj).getId().equals(id)) {
				return (Person)obj;
			}
		}
		
		return null;
	}
	
	// Private Methods
	private boolean isIdValid(String id)
	{
		if (!Main.isDigits(id)) {
			return false;
		} else if (id.length() != 9) {
			return false;
		} else {
			return true;
		}
	}
	
}
