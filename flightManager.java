import javax.swing.*;
import java.io.*;
import java.util.*;

public class flightManager
{
        public static ArrayList<String []> airportList = new ArrayList<String[]>();
        public static ArrayList<String []> flightList = new ArrayList<String[]>();
        
        /*
	@authors Ian McKay and Adam Swayne
	Input: 
        Output:
	*/
        
        public static void main(String[] args) 
	{
                boolean isFiles = validateFiles();
		if(isFiles){
			readInFiles();
			programLauncher(args);
		
		
		}
        }
	
        /*
	@authors Ian Mckay
	Input: 
        Output:
	*/
        
        public static void readInFiles()
	{
		try
		{
			FileReader airportFile = new FileReader("Airports.txt");
			FileReader flightFile = new FileReader("Flights.txt");
			Scanner in = new Scanner(airportFile);
			
			while(in.hasNext())
			{
				//splits the data, 
				airportList.add(in.nextLine().split(","));
			}
			
			in = new Scanner(airportFile);
			
			while(in.hasNext())
			{
				//splits the data,
				flightList.add(in.nextLine().split(","));
			}
			
			in.close();
			airportFile.close();
			flightFile.close();
                        
                        
                        
		}
		catch(FileNotFoundException e)
		{
			System.out.print("FileNotFoundException : " + e.getMessage());
		}
		catch(IOException e)
		{
			System.out.print("IOException : " + e.getMessage());
		}
	}
	
	/*
	@authors 
	Input: 
        Output:
	*/
        
        public static boolean validateFiles()
	{
		File airportFile = new File("Airports.txt");
		File flightFile = new File("Flights.txt");
		if(airportFile.exists() && flightFile.exists()){
                        return true;
                }
		return false;
        }
        
         /*
	@authors 
	Input: 
        Output:
	*/
        
	public static boolean validateAirport(String airportCode, int num)
	{
		String validationOf;
		boolean isValid=false
		switch(num)
			{
				case 1:       
					validationOf = "airportName"; 
					break;
					
				case 2:       
					validationOf = "airportCode";
					isValid=true;
					
					for (int i=0; i<airportCode.length(); i++){
						if (!Character.isUpperCase(airportCode.charAt(i))) isValid= false;
					}
					if (airportCode.length()!=3) isValid= false;
					break;
					
				default:      
					System.out.print("error 3 \nValidation incomplete");
			}
		return isValid;
        }
        
         /*
	@authors 
	Input: 
        Output:
	*/
        
	public static boolean validateFlight(String input, int num)
	{
		
		String validateOf;
		switch(num)
			{
				case 1:{       
					validateOf = "flightNum";
					
					break;
				case 2:       
					validateOf = "DepartAirportCode";
					
					break;
				case 3:       
					validateOf = "ArriveAirportCode"; 
					break;
				case 4:       
					validateOf = "DepartureTime"; 
					break;
				case 5:       
					validateOf = "ArrivalTime"; 
					break;
				case 6:       
					validateOf = "DaysRunning"; 
					break;
				case 7:       
					validateOf = "StartDate"; 
					break;
				case 8:       
					validateOf = "EndDate"; 
					break;
				default:      System.out.print("error 3 \nValidation incomplete");
			}
		return true;
        
        }
        
         /*
	@authors 
	Input: 
        Output:
	*/
        
	public static void programLauncher(String[] input)
	{
		
		try {
			switch(input[0])
			{
				case "AA":       addAirport(input[1],input[2]); break;
				case "EA":       editAirport(input[1],input[2]); break;
				case "DA":       deleteAirport(input[1]); break;
				case "EF":       editFlight(input[1],input[2],input[3],input[4]); break;
				case "DF":       deleteFlight(input[1]); break;
				case "SF":       searchFlight(input[1],input[2]); break;
				case "SD":       searchDate(input[1],input[2],input[3]); break;
				default:         System.out.print("error 2 \n method " + input[0] + " not found");
			}
			
		}
		catch(ArrayIndexOutOfBoundsException exception)
		{
			System.out.print("error 1 \nNot enough objects to pass into program");
		}
        }
        
        /*
	@authors 
	Input: 
        Output:
	*/
        
        public static void addAirport(String airport,String airportCode)
	{
        	//figure out which input is the airport name and whihc one is the airport code, then send it off to validation
        }
        
        /*
	@authors 
	Input: 
        Output:
	*/
        
        public static void editAirport(String airportCode,String airport)
	{
        	
        }
        
        /*
	@authors 
	Input: 
        Output:
	*/
        
        public static void deleteAirport(String airportCode)
	{
        	
        }
        
        /*
	@authors 
	Input: 
        Output:
	*/
        
        public static void editFlight(String flightNum,String flightDays, String startFlight, String endFlight)
	{
        	
        }
        
        /*
	@authors 
	Input: 
        Output:
	*/
        
        public static void deleteFlight(String flightNum)
	{

        }
        
        /*
	@authors 
	Input: 
        Output:
	*/
        
        public static void searchFlight(String airportDepart,String airportArrive)
	{

        }
        
        /*
	@authors 
	Input: 
        Output:
	*/
        
        public static void searchDate(String airportDepart,String airportArrive, String date)
	{
		
        }
	
	/*
	@authors Adam Swayne
	Input: 
        Output:
	*/
        
        public static void sortFiles()
	{
		writeToAirports();
		writeToFlights();
        }
        
        /*
	@authors Ian McKay
	Input: 
        Output:
	*/
        
        public static void writeToAirports()
	{
               try
        	{
		       PrintWriter outFile = new PrintWriter("Airports.txt");
		       String currentLine = "";
		       for (int i = 0; i <airportList.size(); i++)
		       {
			       currentLine = airportList.get(i)[0];
			       for(int j = 1; j<airportList.get(i).length;j++)
			       {
				       currentLine = currentLine + "," + airportList.get(i)[j];
			       }
			       //prints each line to the text file
			       outFile.println(currentLine);
		       }
		       outFile.close();
		}
		catch(IOException e)
        	{
            		System.out.print("IOException : " + e.getMessage());
		}
        }
	
	/*
	@authors Ian McKay
	Input: 
        Output:
	*/
        
        public static void writeToFlights()
	{
		try
        	{
		       PrintWriter outFile = new PrintWriter("Flights.txt");
		       String currentLine = "";
		       for (int i = 0; i <flightList.size(); i++)
		       {
			       currentLine = flightList.get(i)[0];
			       for(int j = 1; j<flightList.get(i).length;j++)
			       {
				       currentLine = currentLine + "," + flightList.get(i)[j];
			       }
			       //prints each line to the text file
			       outFile.println(currentLine);
		       }
		       outFile.close();
		}
		catch(IOException e)
        	{
            		System.out.print("IOException : " + e.getMessage());
		}
               
        }
}
