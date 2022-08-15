//31/10/2020
import java.util.*;//for Scanner
import java.io.*;//for file and printwriter

public class IssueTicket {
    
  public static void main(String[] args) throws FileNotFoundException {
       /** Main method */
        File file1=new File("inputTraffic.txt");//create file instace
        File file2=new File("inputViolations.txt");//create file instace
        
        if(!file1.exists()||!file2.exists()){//check if the files are exists or not
            System.out.println("input file not found");
              System.exit(0);
        }
        
        Scanner input1=new Scanner(file1);//create a Scanner for file1
        Scanner input2=new Scanner(file2);//create a Scanner for file2
         
        PrintWriter output1=new PrintWriter("TrafficDB.txt");//create file output
        PrintWriter output2=new PrintWriter("TrafficTickets.txt"); //create file output
        
        /** Declare arrays and read size from input file */
        Vehicle[] Vehicles =new Vehicle[input1.nextInt()];//1D array for vehicle information
         Driver[] Drivers =new Driver[input1.nextInt()];//1D array for Driver information
         Violation[] Violations =new Violation[input1.nextInt()];//1D array for violation iformation
         
         /** Write formatted output to the file */
         output1.println("--------------- Welcome to Traffic  Database ---------------");
         output1.println();
         output1.println();
         output1.println();
          
         output2.println("--------------- Welcome to Traffic Ticket System ---------------");
         output2.println();
         output2.println();
         
         String command;//declare command
         int numOfVehicle=0;//count the number of vehicles
         int numOfDriver=0;//count the number of drivers
         int numOfViolation=0;//count the number of violation
         while (input1.hasNext()){
            command=input1.next();
            if(command.matches("Quit")){
                //command#1
               break;
           }
            
           if(command.matches("AddVehicle")){
              // command#2
           Vehicles[numOfVehicle]=getVehicle(input1);//use getVehicle method to print the information
           numOfVehicle++;//increment the counter
           }
           
            if(command.matches("AddViolation")){
                //command#4
              Violations[numOfViolation]=getViolation(input1);//use getViolation method to print the information
             numOfViolation++;//increment the counter
            }
            
           if(command.matches("AddDriver")){
               //Command#3
            Drivers[numOfDriver] =getDriver(input1);//use getDriver method to print the information
            numOfDriver++;//increment the counter
           }
         }
         
           for(int i=0;i<Vehicles.length;i++){
         output1.println("	Vehicle No.: "+Vehicles[i].getVehiclePlateNo()+"	Type: "+Vehicles[i].getVehicleType()+"	Brand: "+Vehicles[i].getBrand()+"	Model: "+Vehicles[i].getVehicleModel()+"	Color: "+Vehicles[i].getVehicleColor()+"	Mfg. Year: "+Vehicles[i].getBuiltYear());
           output1.println("------------------------------------------------------");
           output1.println();
           output1.println();
            }
            for (int i=0;i<Violations.length;i++){
            output1.println("	Violation Code: "+Violations[i].getViolationCode()+"	Violation Description: " +Violations[i].getDescription());
              output1.println("------------------------------------------------------");
              output1.println();
              output1.println();   
            }
            for(int i=0;i<Drivers.length;i++){
             output1.println("	Driver ID: "+Drivers[i].getNationalID()+"	Name: "+Drivers[i].getFrist_name()+" "+Drivers[i].getLast_name());
             output1.println("------------------------------------------------------");
             output1.println();
             output1.println();
                
            }
        
          input1.close();//close the file
            output1.close();//close the file
       Ticket tick[]=new Ticket[input2.nextInt()];//1D array for ticket information
       int numOftick=0;//count the number of thickets
       String command2;//declare second command
       while(input2.hasNext()){
           command2=input2.next();
           if(command2.matches("Quit")){
               //Command #1
              NumOfViolationsperDriver(Drivers,tick,output2);//use NumOfViolationsperDriver method to get the number of violation per driver
           }
           if(command2.matches("IssueTicket")){
               //Command #2
           tick[numOftick]=GenerateTicket(input2,Violations,Vehicles,Drivers,output2);//use GenerateTicket to Generate Ticket
           PrintTicket(tick[numOftick],output2);//use PrintTicket to print ticket information
            numOftick++;//increment th counter
           }
       }
         
        // input1.close();//close the file
         input2.close();//close the file
        // output1.close();//close the file
         output2.close();//close the file
     }
  /**----------------------------------------------------------------------------------------------------------------------------*/
   private static Vehicle getVehicle(Scanner input){
       /** define varibles for v object */
      String numPlate=input.next();
      String type=input.next();
      String brand=input.next();
      String model=input.next();
      String color=input.next();
      int year=input.nextInt();
      Vehicle v=new Vehicle(numPlate,type,brand,model,color,year);//create Vehicle object 
        return v;//return the object
         
   }  
    /**----------------------------------------------------------------------------------------------------------------------------*/
    private static Violation getViolation(Scanner input){
         /** define varibles for vio object */
        int code=input.nextInt();
        String des=input.next().replace('_',' ');
        double amount=input.nextDouble();
        Violation vio=new Violation (code,des,amount);//create Violation object 
        return vio;//return the object
        }    
    /**----------------------------------------------------------------------------------------------------------------------------*/
    private static Driver getDriver(Scanner input){
         /** define varibles for d object */
        String ID=input.next();
        String first=input.next();
        String last=input.next();
        int year=input.nextInt();
        int month=input.nextInt();
        int day=input.nextInt();
        Date dob=new Date(year,month-1,day);
        Driver d=new Driver(ID,first,last,dob);//create Driver object 
        return d;//return the object
    }
     /**----------------------------------------------------------------------------------------------------------------------------*/
    private static Ticket GenerateTicket(Scanner input,Violation[]listViolation,Vehicle[]listVehicle,Driver[]listDriver,PrintWriter fWrite){
        /**Method that Generate Ticket */
       int code=input.nextInt();
       String plate=input.next();
       String ID=input.next();
       String loc=input.next();
       int year=input.nextInt();
       int month=input.nextInt();
       int day=input.nextInt();
       Date dot=new Date(year,month,day);//dot= date of ticket
       boolean ins=input.nextBoolean();
       boolean fahas=input.nextBoolean();
       Violation violations=checkViolation(code,listViolation);
       Vehicle vehicles=checkVehicle(plate,listVehicle);
       Driver Drivers=checkDriver(ID,listDriver);
       Ticket tick=new Ticket (System.currentTimeMillis(),violations,vehicles,Drivers,loc,dot,ins,fahas);//create Ticket object
      return tick;//return object
    }
    /**----------------------------------------------------------------------------------------------------------------------------*/
    public static void PrintTicket(Ticket tempticket,PrintWriter fWrite){
        /** Method that print tickets details */
        fWrite.println("Ticket No. "+tempticket.getTicketNo());
        fWrite.println();
        fWrite.println("Violation Details");
        fWrite.println("	Violation Code: "+tempticket.getViolation().getViolationCode());
        fWrite.println("	Violation Description: "+tempticket.getViolation().getDescription());
        fWrite.println("	Violation Penalty: "+tempticket.getViolation().getAmount());
        fWrite.println();
        fWrite.println("Vehicle Details");
        fWrite.println("	Number Plate: "+tempticket.getVehicle().getVehiclePlateNo());
        fWrite.println("	Type: "+tempticket.getVehicle().getVehicleType());
        fWrite.println("	Brand: "+tempticket.getVehicle().getBrand());
        fWrite.println("	Model: "+tempticket.getVehicle().getVehicleModel());
        fWrite.println("	Color: "+tempticket.getVehicle().getVehicleColor());
        fWrite.println("	Built Year: "+tempticket.getVehicle().getBuiltYear());
        fWrite.println();
        fWrite.println("Violator Details");
        fWrite.println("	National ID: "+tempticket.getViolator().getNationalID());
        fWrite.println("	Full Name: "+tempticket.getViolator().getFrist_name()+" "+tempticket.getViolator().getLast_name());
        fWrite.println();
        fWrite.println("Ticket Details");
        fWrite.println("	Date: "+tempticket.getViolationDate().getYear()+"-"+tempticket.getViolationDate().getDate()+"-"+tempticket.getViolationDate().getMonth());
        fWrite.println("	Location: "+tempticket.getLocation());
        fWrite.println();
        fWrite.println("Total Penalty: "+tempticket.CalculateFinalFine());
        fWrite.println("───────────────────────────────────────────────────────");
     }
    /**----------------------------------------------------------------------------------------------------------------------------*/
    public static void NumOfViolationsperDriver(Driver[]alldrivers,Ticket[]alltickets,PrintWriter fWrite){
        /** Method that print number of violation per driver*/
     fWrite.println("--------Total violation(s) by driver--------");
     fWrite.println();
     fWrite.println("Driver ID           Driver Name        Total Violation(s)");
     fWrite.println();
     int count;
     for(int i=0;i<alldrivers.length;i++){
         count=0;
     for(int j=0;j<alltickets.length;j++){
         if(alldrivers[i].getNationalID().matches(alltickets[j].getViolator().getNationalID()))
             count++;
     }
     fWrite.println(alldrivers[i].getNationalID()+"\t "+alldrivers[i].getFrist_name()+" "+alldrivers[i].getLast_name()+"\t\t\t\t"+count);
     }
    }
   /**----------------------------------------------------------------------------------------------------------------------------*/
   public static Violation checkViolation(int code,Violation []listViolation){
        /** Method to check Violation array */
       for(int i=0;i<listViolation.length;i++){
           if(listViolation[i].getViolationCode()==code)
               return listViolation[i];//if they are matches return the array of i
       }
       return null;//if not return null
   } 
    /**----------------------------------------------------------------------------------------------------------------------------*/
   public static Vehicle checkVehicle (String plate,Vehicle[]listVehicle){
       /** Method to check Vehicle array */
       for(int i=0;i<listVehicle.length;i++){
           if(listVehicle[i].getVehiclePlateNo().matches(plate))
               return listVehicle[i];//if they are matches return the array of i
       }
       return null;//if not return null
   }
    /**----------------------------------------------------------------------------------------------------------------------------*/
   public static Driver checkDriver(String ID,Driver[]listDriver){
       /** Method to check Driver array */
       for(int i=0;i<listDriver.length;i++){
           if(listDriver[i].getNationalID().matches(ID))
               return listDriver[i];//if they are matches return the array of i
       }
       return null;//if not return null
   }
  
}
  
  
  










