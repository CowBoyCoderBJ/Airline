/**
* Commercial.java
*/

public class Commercial extends Flight{

    public Commercial(){
    }

    public void book(Payload payload) throws InvalidBookingException {
            if (payload instanceof Person || payload instanceof Employee){
                    super.book(payload);;
            }else
                throw new InvalidBookingException("Flight - " + this.id + " is full!");
        
    }

    public String toString(){
        return "Commercial " + super.toString();
    }

    public int getID(){
        this.id = 100000000 + Item.getTotalNumberOfItems();
        return this.id;
    }

}