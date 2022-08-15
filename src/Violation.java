//Jana Kurdi/1906167/GAR/Jana/Assigment#2
public class Violation {
    /** Define the violation class */
  private int violationCode;//the code of the violation
  private String description;//the description of violation
  private double amount;//the amount of violation

 public Violation(int violationCode,String description,double amount){
     /** Construct a Violation object */
     this.violationCode=violationCode;
     this.description=description;
     this.amount=amount;
     
 }
     public int getViolationCode() {
        /** Return the code of this violation */
        return violationCode;
    }
    
    public void setViolationCode(int violationCode) {
        /** set a new code for this violation */
        this.violationCode = violationCode;
    }

    public String getDescription() {
      /** Return the description of this violation */
        return description;
    }
    
    public void setDescription(String description) {
        /** set a new description for this violation */
        this.description = description;
    }

    public double getAmount() {
    /** Return the amount of this violation */
        return amount;
    }
    
    public void setAmount(double amount) {
     /** set a new amount for this violation */
        this.amount = amount;
    }
 }
