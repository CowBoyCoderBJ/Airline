
public class TestPhase6 {
	public static void main(String [] args) {
		
		// Now we can test some stuff!
		Payload somePayload = null;
		try {
			somePayload = Payload.payloadFactory("C", "10", null, null, null);
		}
		catch (InvalidInputException reason) {
			System.out.println("Shouldn't be here!");
		}
		System.out.println(somePayload);
		
		try {
			somePayload = Payload.payloadFactory("E", "10", "Bob", "Tomato", "Complaining");
		}
		catch (InvalidInputException reason) {
			System.out.println("Shouldn't be here!");
		}
		System.out.println(somePayload);
		
		try {
			somePayload = Payload.payloadFactory("P", "10", "Larry", "Cucumber", null);
		}
		catch (InvalidInputException reason) {
			System.out.println("Shouldn't be here!");
		}
		System.out.println(somePayload);
		
	}

}
