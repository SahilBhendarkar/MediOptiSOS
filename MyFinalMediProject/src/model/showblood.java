package model;

public class showblood {


    private	int id;
    private String name;
    private	String address;
    private	String age;
    private	String gender;
    private	String bloodType;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getBloodType() {
        return bloodType;
    }
    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    public showblood(String name, String address, String age, String gender, String bloodType) {
        super();
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.bloodType = bloodType;
    }

    public showblood() {
        super();
    }
    @Override
    public String toString() {
        return "showblood [id=" + id + ", name=" + name + ", address=" + address + ", age=" + age
                + ", gender=" + gender + ", bloodType=" + bloodType + "]";
    }




}
