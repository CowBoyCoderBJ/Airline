/**
* Airline.java
*/

import java.util.ArrayList;

public class Airline {

    protected ArrayList<Flight> flights = new ArrayList<Flight>();
    protected ArrayList<Payload> payloads = new ArrayList<Payload>();

	public String addFlight(char type) throws InvalidInputException{
        if (type == 'C'){
            Commercial commFlight = new Commercial();
            flights.add(commFlight);
            return commFlight.toString();
            
        }

        else if(type == 'I'){
            Industrial indFlight = new Industrial();
            flights.add(indFlight);
            return indFlight.toString();
       
        }else{
            throw new InvalidInputException("Flight Creation command Incorrect");
        }
       
        }

        public Flight getFlight(int id){
            Flight currFlight = null;
            for (int i = 0; i<flights.size(); i++){
                if (flights.get(i).id == id){
                    currFlight = flights.get(i);
                }
            }
            return currFlight;
        }

        public void addPayload(Payload thePayload){
            payloads.add(thePayload);
        }

        public Payload getPayload(int id){
            Payload result = null;
            for (int i = 0; i < payloads.size(); i++){
                if (payloads.get(i).id == id){
                    result = payloads.get(i);
                }
            }
            return result;
        }

}
