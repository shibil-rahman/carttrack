package Model;

public class Users {
    private String name, phone, password,vision;

    public Users() {

    }

    public Users(String name, String phone, String password,String vision) {
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.vision=vision;
    }

    public String getName() {
        return name;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}



