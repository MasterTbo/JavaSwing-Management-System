package CiTixPackage;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Demonstrate a login to the CiTix Programme Management System
 *
 * @author matjele7@gmail.com
 * @version 1.3.1
 */
public class Login {

    private static Connection con;
    private String userLogName;
    private String userPassword;
    private Boolean isValid;

    //Default constructor
    public Login(){}
    
    /**
     * Construct the connection to the database and user login
     * @param userLogName the user login user name
     * @param userPassword the user login user password
     */
    public Login(String userLogName, String userPassword) {
        this.userLogName = userLogName;
        this.userPassword = userPassword;
        this.isValid = false;
    }

    /**
     * A getter for the user's login name
     *
     * @return the user login name
     */
    public String getUserLogName() {
        return userLogName;
    }

    /**
     * A setter for the user's login name
     *
     * @param userLogName the user's login name
     */
    public void setUserLogName(String userLogName) {
        this.userLogName = userLogName;
    }

    /**
     * A getter for the user's login password
     *
     * @return the user's login password
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * A setter for the user's login password
     *
     * @param userPassword a login user's password
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * Models a boolean function to authenticate user input credentials
     *
     * @return the isValid true/false
     */
    public boolean logIn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/citixpms", "root", "r00t101");
            Statement stmt = (Statement) con.createStatement();
            String uName = getUserLogName(), uPass = getUserPassword();
            String query = "SELECT user_Name, user_Password FROM login WHERE user_Name =? && user_Password =?";

            PreparedStatement qStatement = con.prepareStatement(query);
            qStatement.setString(1, uName);
            qStatement.setString(2, uPass);

            ResultSet authResult = qStatement.executeQuery();
            if (authResult.next() && !getUserLogName().equals("") && !getUserPassword().equals("")) {
                JOptionPane.showMessageDialog(null, "Login Succesful!\n" + uName + " : " + uPass);
                isValid = true;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password\n" + uName + " : " + uPass);
                isValid = false;
            }
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return isValid;
    }

    public String getLogedUser() {
        String uName = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/citixpms", "root", "r00t101");
            Statement stmt = (Statement) con.createStatement();
            String qName = "SELECT std_FName FROM student, login, usertype"
                    + " WHERE login.user_Type_ID = usertype.user_Type_ID &&"
                    + "	usertype.user_Type_ID = student.user_Type_ID &&"
                    + "    student.std_Email = '" + getUserPassword() + "'";
            PreparedStatement qStmt = con.prepareStatement(qName);            
            ResultSet res = qStmt.executeQuery();
            while(res.next()){
                uName = res.getString("std_FName");
            }
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return uName;
    }

    /**
     * Models a boolean function when the user log out
     *
     * @return isValid
     */
    public boolean logOut() {
        isValid = false;
        JOptionPane.showMessageDialog(null, "Loged Out!");
        return isValid;
    }

}
