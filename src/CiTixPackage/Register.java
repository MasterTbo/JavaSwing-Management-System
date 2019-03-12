package CiTixPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author matjele7@gmail.com | Student No: 3879462
 */
public class Register {

    private int userType;
    private double userIDNo;
    private String progID, userFName, userLName, userDoB,
            userEmail, streetName, city, province;
    private int zipCode;

    private String uName;
    private Connection conn;
    PreparedStatement queryStmnt;
    ResultSet result;

    public Register() {
    }

    public Register(int userType, String progID,
            String userFName, String userLName, double userIDNo, String userEmail,
            String streetName, String city, String province, int zipCode) {
        this.userType = userType;
        this.userIDNo = userIDNo;
        this.progID = progID;
        this.userFName = userFName;
        this.userLName = userLName;
        //this.userDoB = userDoB;
        this.userEmail = userEmail;
        this.streetName = streetName;
        this.city = city;
        this.province = province;
        this.zipCode = zipCode;
        this.uName = "";
    }

    public double getUserID() {
        return userIDNo;
    }

    public void setUserID(double userIDNo) {
        this.userIDNo = userIDNo;
    }

    public String getProgID() {
        return progID;
    }

    public void setProgID(String progID) {

        this.progID = progID;
    }

    public String getUserFName() {
        return userFName;
    }

    public void setUserFName(String userFNane) {
        this.userFName = userFNane;
    }

    public String getUserLName() {
        return userLName;
    }

    public void setUserLName(String userLName) {
        this.userLName = userLName;
    }

    public String getUserDoB() {
        return userDoB;
    }

    public void setUserDoB(String userDoB) {
        this.userDoB = userDoB;
    }
    
    

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public double getUserIDNo() {
        return userIDNo;
    }

    public void setUserIDNo(double userIDNo) {
        this.userIDNo = userIDNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String country) {
        this.province = country;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public void insertUser() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/citixpms", "root", "r00t101");

            if (getUserType() == 1) {
                String insertUser = "INSERT INTO administrator(user_Type_ID, prog_ID, "
                        + "admin_FName, admin_LName, admin_ID_Number, admin_Email, street_Name,"
                        + " city, province, zip_Code) "
                        + "VALUES('" + getUserType() + "', '" + getProgID() + "', '"
                        + getUserFName() + "', '" + getUserLName() + "', '" + getUserIDNo() + "', '" 
                        + getUserEmail() + "', '" + getStreetName() + "', '" + getCity() + "', '"
                        + getProvince() + "', '" + getZipCode() + "')";
                getLoginDetails();
                queryStmnt = conn.prepareStatement(insertUser);
                queryStmnt.executeUpdate();
            } else {
                String insertUser = "INSERT INTO student(user_Type_ID, prog_ID, std_FName, "
                        + "std_LName, std_ID_Number, std_Email, street_Name, city, Province, zip_Code) "
                        + "VALUES('" + getUserType() + "', '" + getProgID() + "', '"
                        + getUserFName() + "', '" + getUserLName() + "', '" + getUserIDNo() + "', '" 
                        + getUserEmail() + "', '" + getStreetName() + "', '" + getCity() + "', '"
                        + getProvince() + "', '" + getZipCode() + "')";
                queryStmnt = conn.prepareStatement(insertUser);
                queryStmnt.executeUpdate();
                //JOptionPane.showMessageDialog(null, "User Registration Successf");
                getLoginDetails();
            }
            //conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void insertLoginDetails() {
        if (getLoginDetails() == true) {
            try {
                String logQuery = "INSERT INTO login (user_Type_ID, user_Name, user_Password) "
                        + "VALUES('" + getUserType() + "', '" + getuName() + "', '" + getUserEmail() + "')";
                queryStmnt = conn.prepareStatement(logQuery);
                queryStmnt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Login Details Succesfull");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
//        try {
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public boolean getLoginDetails() {
        boolean isValid = false;
        String name = "";
        if (getUserIDNo() == 0 || getUserType() == 0
                || getProgID().equals(" ") || getUserFName().equals(" ")
                || getUserLName().equals(" ") || getUserEmail().equals(" ")
                || getStreetName().equals(" ") || getCity().equals(" ") || getZipCode() == 0) {
            JOptionPane.showMessageDialog(null, "Please fill in all the spaces in a form");
        } else {
            if (getUserEmail().contains("@")) {
                int i = 0;
                do {
                    if (getUserEmail().charAt(i) == '@') {
                        isValid = true;
                    } else {
                        name += getUserEmail().charAt(i);
                        isValid = false;
                    }
                    ++i;
                } while (!isValid);
                //JOptionPane.showMessageDialog(null, "User Registration Successf\nUser name: " + getuName() + "\nPassword: " + getUserEmail());
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Email Address");
            }
            setuName(name);
        }
        return isValid;
    }

    public Connection dbConnection() {
        return conn;
    }
}
