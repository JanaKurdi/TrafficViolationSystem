import java.util.*;//for Date
import java.text.*;//to claculate Driver age
public class Ticket {
    /** Define the Ticket class */
  private long ticketNo;//the number of the ticket
  private Violation violation;//aggregating with Violation class
  private Vehicle vehicle;////aggregating with Vehicle class
  private Driver violator;//aggregating with river class
  String location;//the location of the ticket
  Date violationDate;//the date of the ticket
  boolean hasValidIsurance;//check the insurance
  boolean hasValidFahas;//check the fahas
  
  public Ticket(long ticketNo,Violation violation,Vehicle vehicle,Driver violator,String location,Date violationDate,boolean hasValidIsurance,boolean hasValidFahas){
      /** Construct a Ticket object */
      this.ticketNo=ticketNo;
      this.violation=violation;
      this.vehicle=vehicle;
      this.violator=violator;
      this.location=location;
      this.violationDate=violationDate;
      this.hasValidIsurance=hasValidIsurance;
      this.hasValidFahas=hasValidFahas;
}
    public long getTicketNo() {
         /** Return the number of this ticket */
        return ticketNo;
    }

    public void setTicketNo(long ticketNo) {
         /** set a new number for this ticket */
        this.ticketNo = ticketNo;
    }
     
    public Violation getViolation() {
         /** Return the violation */
        return violation;
    }
    
    public void setViolation(Violation violation) {
        /** set a new violaton for this ticket */
        this.violation = violation;
    }

    public Vehicle getVehicle() {
         /** Return the vehicle */
        return vehicle;
    }
    
     public void setVehicle(Vehicle vehicle) {
         /** set a new vehicle for this ticket */
        this.vehicle = vehicle;
    }

    public Driver getViolator() {
         /** Return the violator */
        return violator;
    }
    
   public void setViolator(Driver violator) {
       /** set a new violator for this ticket */
        this.violator = violator;
    }
   
    public String getLocation() {
         /** Return the locatin of this ticket */
        return location;
    }
    
     public void setLocation(String location) {
         /** set a new location for this ticket */
        this.location = location;
    }

    public Date getViolationDate() {
         /** Return the date of this ticket */
        return violationDate;
    }

    public void setViolationDate(Date violationDate) {
        /** set a new date for this ticket */
        this.violationDate = violationDate;
    }

    public boolean getHasValidIsurance() {
         /** Return the result of insurance vaildation */
        return hasValidIsurance;
    }
    
  public void setHasValidIsurance(boolean hasValidIsurance) {
      /** set a new result for isurance */
        this.hasValidIsurance = hasValidIsurance;
    }
  
    public boolean getHasValidFahas() {
         /** Return the result of fahas vaildation */
        return hasValidFahas;
    }

   public void setHasValidFahas(boolean hasValidFahas) {
       /** set a new result for fahas */
        this.hasValidFahas = hasValidFahas;
    }
  public double CalculateFinalFine(){
      /** method that calulate the fine and return it */
   double fine=0;
   if(!hasValidIsurance)//if the insurnce is not valid 
       fine+=100;//pay 100 SAR
   if(!hasValidFahas)//if the fahas is not valid 
       fine+=150;//pay 150 SAR
    if(calculateDriverAge(new Date ())<22)//check if the driver is underage
           fine+=1000;//pay 1000 SAR
  return violation.getAmount()+fine;
   }
  
public int calculateDriverAge(Date currentDate){
    /** method that clculate the age of the driver */
   SimpleDateFormat date=new  SimpleDateFormat("yyyyMMdd");
   int dateOfBirth=Integer.parseInt(date.format(violator.getDob()));
   int current=Integer.parseInt(date.format(this.violationDate));
   int age=(current-dateOfBirth)/10000;
   return age;
}
      
}    
  
  
  
    

