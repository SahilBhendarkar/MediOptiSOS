package model;

public class ambulance {


    private	int idambulance;
    private String name;
    private	String ph_no;
    private	String pickup_location;
    private	String date_time;
    private	String destination;
    public int getIdambulance() {
        return idambulance;
    }
    public void setIdambulance(int idambulance) {
        this.idambulance = idambulance;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPh_no() {
        return ph_no;
    }
    public void setPh_no(String ph_no) {
        this.ph_no = ph_no;
    }
    public String getPickup_location() {
        return pickup_location;
    }
    public void setPickup_location(String pickup_location) {
        this.pickup_location = pickup_location;
    }
    public String getDate_time() {
        return date_time;
    }
    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public ambulance(int idambulance, String name, String ph_no, String pickup_location, String date_time,
                     String destination) {
        super();
        this.idambulance = idambulance;
        this.name = name;
        this.ph_no = ph_no;
        this.pickup_location = pickup_location;
        this.date_time = date_time;
        this.destination = destination;
    }
    public ambulance(String name, String ph_no, String pickup_location, String date_time, String destination) {
        super();
        this.name = name;
        this.ph_no = ph_no;
        this.pickup_location = pickup_location;
        this.date_time = date_time;
        this.destination = destination;
    }
    public ambulance() {
        super();
    }





}
