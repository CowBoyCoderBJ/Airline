/**
* Industrial.java
*/

public class Industrial extends Flight {
    public void book(Payload payload) throws InvalidBookingException {
        if (payload instanceof Cargo || payload instanceof Employee){
            super.book(payload);;
        }else
            throw new InvalidBookingException("Flight - " + this.id + " is full!");
            
        
    }

    public String toString(){
        return "Industrial " + super.toString();
    }

    public int getID(){
        this.id = 200000000 + Item.getTotalNumberOfItems();
        return this.id;
    }
}
