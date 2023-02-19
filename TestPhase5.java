/*
 * WARNING:
 * ============================================================================
 * THE FORMAT USED FOR THIS TEST CODE IS (WEIGHT, FIRSTNAME, LASTNAME, JOB)
 * PLEASE EDIT THIS FILE SO THAT THE CONSTRUCTOR SIGNATURES MATCH YOUR OWN
 * ============================================================================
 * 
 */
public class TestPhase5 {
    public static void main(String [] args) {
        //EDIT THE BELOW CODE TO MATCH YOUR CONSTRUCTOR SIGNATURES
        //===========================================================================
        Employee arthur = new Employee("Arthur", "Mcclain", "Pilot",140);
        Person brennan = new Person("Brennan", "Cope", 32);
        Cargo goodToGo = new Cargo(150);
        Cargo tooHeavy = new Cargo(201);
        Payload franciszek = new Person("Franciszek", "Arias",199.0);
        
        /* THE FOLLOWING EMPLOYEE OBJECT WAS JUST TO TEST ANOTHER CONSTRUCTOR
         * THIS CONSTRUCTOR HAD THE SIGNATURE (WEIGHT, PERSON, JOB)
         * IT IS NOT REQUIRED, HOWEVER YOU MAY UNCOMMENT IT AND IMPLEMENT IT IF YOU'D LIKE
         * KEEP IN MIND IT WILL AFFECT THE FOLLOWING ID NUMBERS BY 1
         */
        //Employee newHire = new Employee(2, brennan, "Flight Attendant");
        
        //===========================================================================
        //PAST HERE SHOULD BE FINE
        
        Flight industFlight = new Industrial();
        Flight commercFlight = new Commercial();
        
        //TESTING PAYLOADS
        System.out.println("Should print: \"ID: 300000000, Weight: 140.0 kg, Name: Arthur, EMP: 500000000, Job: Pilot\"");
        System.out.println(arthur + "\n");
        
        System.out.println("Should print: \"ID: 300000001, Weight: 32.0 kg, Name: Brennan\"");
        System.out.println(brennan + "\n");
        
        System.out.println("Should print: \"ID: 400000002, Weight: 150.0 kg\"");
        System.out.println(goodToGo + "\n");
        
        System.out.println("Should print: \"ID: 400000003, Weight: 201.0 kg\"");
        System.out.println(tooHeavy + "\n\n");
        //=======================================================================
        
        //TESTING FLIGHTS
        try{
            System.out.println("Adding Payloads to Industrial flight");
            industFlight.book(goodToGo);
            System.out.println("Should print: \"Industrial Flight 200000005 has a payload size of 1\"");
            System.out.println(industFlight + "\n");
            
            industFlight.book(tooHeavy);
            
            System.out.println("THIS SHOULD NOT PRINT");
        } catch(InvalidBookingException e){
            System.out.println("Failed to add cargo, reason: too heavy. Weight: " + tooHeavy.getWeight() + "\n");
        }
        
        try{
            System.out.println("Adding Payloads to Commercial Flight");
            commercFlight.book(arthur);
            System.out.println("Should print: \"Commercial Flight 100000006 has a payload size of 1\"");
            System.out.println(commercFlight + "\n");
            
            commercFlight.book(brennan);
            commercFlight.book(goodToGo);
            System.out.println("THIS SHOULD ALSO NOT PRINT");
        }catch(InvalidBookingException e){
            System.out.println("Should print: \"Commercial Flight 100000006 has a payload size of 2\"");
            System.out.println(commercFlight + "\n");
        }
        
        System.out.println("Should print: \"ID: 300000004, Weight: 199.0 kg, Name: Franciszek\"");
        System.out.println(franciszek + "\n");
        
        //UNCOMMENT IF YOU ARE TESTING THE EXTRA EMPLOYEE CONSTRUCTOR
		Employee newHire = new Employee("Arthurnew", "Mcclain", "Pilotnew",1400);
        System.out.println("Should print: \"ID: 300000005, Weight:  2.0 kg, Name: Brennan, EMP: 500000001, Job: Flight Attendant\"");
        System.out.println(newHire);
        
    }

}
