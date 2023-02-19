/**
* Payload.java
*/

public abstract class Payload extends Item {
	protected double payloadWeight;;

	public Payload(double wgt) {
		super();
		this.payloadWeight = wgt;
	}

	public static Payload payloadFactory(String payloadType, String weight, String firstname, String lastname, String job ) throws InvalidInputException{
		Payload newPayload;
		double payloadWeight;
		try{
			payloadWeight = Double.parseDouble(weight);

		}catch(Exception e){
			throw new InvalidInputException("Invalid weight.");
		}
		if(payloadType.equals("P")){
			newPayload = new Person(firstname, lastname, payloadWeight);
		}

		else if(payloadType.equals("E")){
			newPayload = new Employee(firstname, lastname, job, payloadWeight);
		}

		else if(payloadType.equals("C")){
			newPayload = new Cargo(payloadWeight);
		}

		else{
			throw new InvalidInputException("Invalid Payload type");
		}

		return newPayload;

	}

	public double getWeight(){
		return this.payloadWeight;
	}

	public String toString(){
		String result = "ID: " + this.id + ", Weight: ";
		for (int i = 0; i < (4 - Integer.toString((int)this.getWeight()).length()); i++){
			result += " ";
		}
		result += this.getWeight() + " kg";
		return result;
	}
	
}

