package zti_lab.zti_lab01;

public class Person {
    private String fname;
    private String lname;
    private String city;

    public Person(String fname, String lname, String city) {
    this.fname = fname;
    this.lname = lname;
    this.city = city;
}

public String getFname() {
    return fname;
}

public String getLname() {
    return lname;
}

public String getCity() {
    return city;
}
}