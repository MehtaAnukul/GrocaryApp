package classobj;

/**
 * Created by Anukul-PC on 06-07-2018.
 */
public class AdminLoginModel {

    private String userName = "admin";
    private String password = "password";

    public AdminLoginModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    public AdminLoginModel(){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
