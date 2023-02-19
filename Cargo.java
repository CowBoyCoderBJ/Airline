/**
* Cargo.java
*/

public class Cargo extends Payload {
	private double weight;

	public Cargo(double w) {
		super(w);
		this.weight = weight;
	}
	
	public int getID(){

        return 400000000 + Item.getTotalNumberOfItems();
    }

}
