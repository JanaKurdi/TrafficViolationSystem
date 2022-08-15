//Jana Kurdi/1906167/GAR/Jana/Assigment#2
public class Vehicle {
    /** Define the vehicle class */
  private String VehiclePlateNo;//the plate number of the vehicle
  private String VehicleType;//the type of the vehicle
  private String Brand;//the Brand of the vehicle
  private String VehicleModel;//the Model of the vehicle
  private String VehicleColor;//the Color of the vehicle
  private int  BuiltYear;//the Bulilt year of the vehicle
  
  public Vehicle(String plateNo,String VehicleType,String Brand,String VehicleModel,String VehicleColor,int  BuiltYear){
      /** Construct a Vehicle object */
      this.VehiclePlateNo=plateNo;
      this.VehicleType=VehicleType;
      this.Brand=Brand;
      this.VehicleModel=VehicleModel;
      this.VehicleColor=VehicleColor;
      this.BuiltYear=BuiltYear;
  }
  
   public String getVehiclePlateNo() {
        /** Return the plate number of this vehicle */
        return VehiclePlateNo;
    }
    
    public void setVehiclePlateNo(String VehiclePlateNo) {
        /** set a new plate number for this vehicle */
        this.VehiclePlateNo = VehiclePlateNo;
    }
    
    public String getVehicleType() {
         /** Return the type of this vehicle*/
        return VehicleType;
    }

    public void setVehicleType(String VehicleType) {
       /** set a new type for this vehicle */
        this.VehicleType = VehicleType;
    }

    public String getBrand() {
         /** Return the Brand of this vehicle*/
        return Brand;
    }
    
    public void setBrand(String Brand) {
        /** set a new brand for this vehicle */
        this.Brand = Brand;
    }
    
     public String getVehicleModel() {
     /** Return the Model of this vehicle*/
        return VehicleModel;
    }

    public void setVehicleModel(String VehicleModel) {
        /** set a new model for this vehicle */
        this.VehicleModel = VehicleModel;
    }
     
    public String getVehicleColor() {
         /** Return the color of this vehicle*/
        return VehicleColor;
    }
    
  public void setVehicleColor(String VehicleColor) {
      /** set a new color for this vehicle */
        this.VehicleColor = VehicleColor;
    }
    
    public int getBuiltYear() {
       /** Return the built year of this vehicle*/
        return BuiltYear;
    }

    public void setBuiltYear(int BuiltYear) {
        /** set a new built year for this vehicle */
        this.BuiltYear = BuiltYear;
    }
  }
