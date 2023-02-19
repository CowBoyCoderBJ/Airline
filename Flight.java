/**
* Flight.java
*/

import java.util.ArrayList;

public abstract class Flight extends Item {
    protected ArrayList <Payload> listPayload = new ArrayList<Payload>();
    protected ArrayList <Payload> samePayloads = new ArrayList <Payload>();
    private final int MAX_WEIGHT = 200;
    private final int MAX_PAYLOAD = 100;
    protected boolean hasTakenoff = false;
    

    public void book(Payload payload) throws InvalidBookingException {
        if(samePayloads.contains(payload) || listPayload.contains(payload)){
            if(samePayloads.contains(payload)){
                throw new InvalidBookingException("This Payload is already booked on this flight!");
            }
            else
                throw new InvalidBookingException("This Payload is already booked on other flight!");
            
        }else
            if (payload.getWeight() <= MAX_WEIGHT && listPayload.size()<MAX_PAYLOAD){
                listPayload.add(payload);
                samePayloads.add(payload);
            }else
                throw new InvalidBookingException("Flight - " + this.id + " is full!");
            }

    public boolean canTakeoff(){
        if (hasTakenoff == false && listPayload.size() >=2){
            for (int i = 0; i < listPayload.size(); i++){
                if (listPayload.get(i) instanceof Employee){
                    return true;
                }
            }
        }
        return false;
    }

    public String doTakeoff(){
        if (canTakeoff()){
            hasTakenoff = true;
            return "Flight " + this.id + " takes off at the speed of light!";
        }
        return "Flight " + this.id + " can not take off";
    }

    public String toString(){
        return "Flight "  + id +  " has a payload size of " + listPayload.size();
    }
}
