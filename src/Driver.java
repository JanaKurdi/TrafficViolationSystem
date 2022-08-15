import java.util.*;//for Date

public class Driver {
    /** Define the Driver class */
  private String nationalID; //the national ID of the Driver
  private String First_name; //the first name of the Driver
  private String Last_name;//the last name of the Driver
  private Date dob;//the date of birth of the Driver
  
  public Driver(String nationalID,String First_name,String Last_name,Date dob){
       /** Construct a Driver object */
      this.nationalID=nationalID;
      this.First_name=First_name;
      this.Last_name=Last_name;
      this.dob=dob;
  }

    public String getNationalID() {
     /** Return the national ID of this Driver */
        return nationalID;
    }
    
    public void setNationalID(String nationalID) {
      /** set a new national ID for this Driver */
        this.nationalID = nationalID;
    }

    public String getFrist_name() {
  /** Return the first name of this Driver */
        return First_name;
    }

    public void setFrist_name(String Frist_name) {
        /** set a new first name for this Driver */
        this.First_name = Frist_name;
    }
     
    public String getLast_name() {
    /** Return the last name of this Driver */
        return Last_name;
    }

    public void setLast_name(String Last_name) {
     /** set a new last name for this Driver */
        this.Last_name = Last_name;
    }
     
    public Date getDob() {
   /** Return the date of birth of this Driver */
        return dob;
    }
    
    public void setDob(Date dob) {
   /** set a new dete of birth for this Driver */
        this.dob = dob;
    }
  }
