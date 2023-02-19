/**
* item.java
*/

public abstract class Item {
	protected int id;
	protected static int totalItems = 0;
	
	public Item() {
		this.id = getID();
		totalItems++;
	}

	public static int getTotalNumberOfItems(){
		return totalItems;
	}

	public int getID(){
		return id;
	}
	
}
