/**
* Main.java
*
* COMP 1020 SECTION A0?
* Ali Neshati (A03)
* ASSIGNMENT 3
* @author Bhavik Jain, 7927054
* @version 10th April, 2022
*
* PURPOSE: To make classes of objects
* Bonus part completed
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Main {
    private final static String FILE_NAME = "TestPhaseBen.txt";
    
    public static void main(String[] args){
        Airline newAirline= new Airline();
        readInputFile(FILE_NAME, newAirline);
    }
    

    public static void readInputFile(String fileName, Airline airline){
        try{
            FileReader theFile = new FileReader(fileName);
            BufferedReader inFile = new BufferedReader(theFile);
            Scanner input = new Scanner(inFile);
            String line;
                while(input.hasNextLine()){
                    line = input.nextLine();
                    if(line!=null){
                        String[] data = line.strip().trim().split(" ");
                        if (data[0].equals("*")){
                                processComment(line);
                        }else
                            try{
                                parseCommand(data, airline);
                            }catch (InvalidInputException e){
                                System.out.println(e);
                            }
                            
                    }
                } 
        
        theFile.close();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void parseCommand(String [] tokens, Airline air) throws InvalidInputException{
        if(tokens[0].equals("CREATE-FLIGHT")){
            if (tokens[1].equals("C")){
                System.out.println(air.addFlight('C'));
            }
            else if(tokens[1].equals("I")){
                System.out.println(air.addFlight('I'));
            }else
                throw new InvalidInputException("Command not found");
        }
        else if(tokens[0].equals("GET-FLIGHT")){
            if(air.getFlight(Integer.parseInt(tokens[1])) == null){
                throw new InvalidInputException("Flight " + tokens[1] + " not found");
            }else
                System.out.println(air.getFlight(Integer.parseInt(tokens[1])).toString());
        }

        else if(tokens[0].equals("CREATE-PAYLOAD")){
            if (tokens[1].equals("P")){
                Payload newPayl = Payload.payloadFactory(tokens[1], tokens[2], tokens[3], tokens[4], null);
                air.addPayload(newPayl);
                
                
            }
            else if(tokens[1].equals("E")){
                Payload newPayl = Payload.payloadFactory(tokens[1], tokens[2], tokens[3], tokens[4], tokens[5]);
                air.addPayload(newPayl);
            }
            else if(tokens[1].equals("C")){
                Payload newPayl = Payload.payloadFactory(tokens[1], tokens[2], null, null, null);
                air.addPayload(newPayl);
            }else
                throw new InvalidInputException("Command not found");
            
        }

        else if(tokens[0].equals("GET-PAYLOAD")){
            if (air.getPayload(Integer.parseInt(tokens[1])) == null){
                throw new InvalidInputException("Payload " + tokens[1] + " not found.");
            }else{
                System.out.println(air.getPayload(Integer.parseInt(tokens[1])));
            }
        }

        else if (tokens[0].equals("ASSIGN-PAYLOAD")){
            if (air.getFlight(Integer.parseInt(tokens[1])) == null){
                throw new InvalidInputException("flightID " + tokens[1] + " not found.");
            }else{
                if (air.getPayload(Integer.parseInt(tokens[2])) == null){
                    throw new InvalidInputException("Payload " + tokens[2] + " not found.");
                }else{
                    Flight newFlight = air.getFlight(Integer.parseInt(tokens[1]));
                    Payload newPayl = air.getPayload(Integer.parseInt(tokens[2]));
                    try{
                        newFlight.book(newPayl);
                    }catch(InvalidBookingException e){
                        System.out.println(e.getMessage());
                    }
                    
                }
            }
        }

        else if (tokens[0].equals("TAKEOFF")){
            if (air.getFlight(Integer.parseInt(tokens[1])) == null){
                throw new InvalidInputException("Flight - " + tokens[1] +" doesnot exist");
            }else{
                Flight newFlight = air.getFlight(Integer.parseInt(tokens[1]));
                System.out.println(newFlight.doTakeoff());
            }

        }

        else{
            throw new InvalidInputException("Invalid token");
        }
            
        
    }

    public static void processComment(String line){
        String result = "";
        String[] words = line.split("\\s+");
        for (int i = 1; i < words.length;i++){
            if (words[i] != " "){
                result += words[i] + " ";
            }
        }
        
    }

	
}


