
package nam.dto;

public class Account {
    private int id;
    private String email;
    private String fullName;
    private String password;
    private String phone;
    private int status;
    private int role;

    public Account() {
    }

    public Account(int id, String email, String password, String fullName, String phone, int status, int role) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.password = password;
        this.phone = phone;
        this.status = status;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return  email + ", " + fullName + ", " + password + ", " + phone + ", " + status + ", " + role;
    }
    
    
}
