package complexdata;

public class ComplexData {
    private String name;
    private int age;
    private long ssn;
    private String telephone;
    private String dob;

    public ComplexData() {
    }

    public ComplexData(String name, int age, long ssn, String telephone, String dob) {
        this.name = name;
        this.age = age;
        this.ssn = ssn;
        this.telephone = telephone;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "ComplexData{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ssn=" + ssn +
                ", telephone='" + telephone + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
