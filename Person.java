/**
* Person.java
*/

public class Person extends Payload {
	private String firstName;
	private String lastName;

	public Person(String fn, String ln, double wt) {
		super(wt);
		this.firstName = fn;
		this.lastName = ln;
	}

	public int getID(){
        return 300000000 + Item.getTotalNumberOfItems();
    }

	public String toString(){
		return super.toString() + ", Name: " + this.firstName;
	}
}
