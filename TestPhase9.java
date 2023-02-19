

public class TestPhase9 {
    public static void main(String [] args) {
        Airline air = new Airline();
        try {
			Payload p =Payload.payloadFactory("E", "30", "Jesse", "Rocket", "Trainer");
			air.addPayload(p);
            System.out.println("One Payload added");
		} catch (InvalidInputException e) {
			System.out.println("Should not be here!");
		}

        try {
			Payload p =Payload.payloadFactory("E", "30", "Jesse", "Rocket", "Trainer");
			air.addPayload(p);
            air.addPayload(p);
            System.out.println("Should not be here!");
		} catch (InvalidInputException e) {
			// System.out.println("cant add");
		}
        

    }
    
}
