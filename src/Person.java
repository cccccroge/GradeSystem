
public class Person {
	
	public Person(String i, String n, int[] a){
		id = i;
		name = n;
		assignment = a;
	}
	
	public String getId(){
		return id;
	}
	public String getName(){
		return name;
	}
	public int[] getAssignment(){
		return assignment;
	}
	String id;
	String name;
	int[] assignment;
	
}