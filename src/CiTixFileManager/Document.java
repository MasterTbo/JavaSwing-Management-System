package CiTixFileManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Demonstrates CiTix Document or File
 * @author matjele7@gmail.com
 * @version 1.3
 */
public class Document {
    private Connection conn;
    private int docID;
    private String docName;
    private String docType;
    private String progId;
    
    PreparedStatement queryStmnt;
    ResultSet result;

    /**
     * Constructs a default constructor 
     */
    public Document() {
    }    
    
    /**
     * Constructs a document/file with a given ID, Name and Type
     * @param docID an ID for a document/file
     * @param progId a programme ID
     * @param docName a name of a document/file
     * @param docType a document/file type
     */
    public Document(int docID, String progId, String docName, String docType) {
        this.docID = docID;
        this.progId = progId;
        this.docName = docName;
        this.docType = docType;
    }

    /**
     * A getter for a document/file ID
     * @return a document/file ID
     */
    public int getDocID() {
        return docID;
    }

    /**
     * A setter for a document/file ID
     * @param docID an ID of a document/file
     */
    public void setDocID(int docID) {
        this.docID = docID;
    }

    /**
     * A getter for the programme ID
     * @return programme ID
     */
    public String getProgId() {
        return progId;
    }

    /**
     * A setter for the programme ID
     * @param progId a programme ID
     */
    public void setProgId(String progId) {
        this.progId = progId;
    }  
    

    /**
     * A getter for a document/file name
     * @return a document/file name
     */
    public String getDocName() {
        return docName;
    }

    /**
     * A setter for a document/file name
     * @param docName the name of a document/file
     */
    public void setDocName(String docName) {
        this.docName = docName;
    }

    /**
     * A getter for a document/file type
     * @return a document/file type
     */
    public String getDocType() {
        return docType;
    }

    /**
     * A setter for a document/file type
     * @param docType a document/file type
     */
    public void setDocType(String docType) {
        this.docType = docType;
    }
    
    /**
     * Models a function to insert record into database 
     */
    public void insertRecord(){        
        try {
            String insQuery = "INSERT INTO document(doc_ID, prog_ID, doc_Name, doc_Type)"
                    + "VALUES('"+ getDocID() + "', '" + getProgId() + "', '" + getDocName() + "', '" + getDocType() + "')";
            queryStmnt = conn.prepareStatement(insQuery);
            queryStmnt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data entered Succesful...");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Document.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Models a function to delete a record in a database
     */
    public void deleteRecord(){
        try {
            String delQuery = "DELETE FROM document "
                    + "WHERE doc_ID = ? " ;
            queryStmnt = conn.prepareStatement(delQuery);
            queryStmnt.setInt(1, getDocID());
            queryStmnt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record deleted");
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    /**
     * Demonstrates a searched record and add it to an array list of type document
     * @param docSearch an input string to search for a record in a table
     * @return the array list of the matching records in a table 
     */
    public ArrayList<Document> docList(String docSearch){
        ArrayList<Document> docArrList = new ArrayList<>();
        try {
            String srchDoc = "SELECT doc_ID, prog_ID, doc_Name, doc_Type FROM document "
                    + "WHERE doc_ID LIKE '%"+docSearch+"%' OR "
                    + "prog_ID LIKE '%"+docSearch+"%' OR "
                    + "doc_Name LIKE '%"+docSearch+"%' OR "
                    + "doc_Type LIKE '%"+docSearch+"%'";
            queryStmnt = conn.prepareStatement(srchDoc);
            result = queryStmnt.executeQuery();
            Document myDoc;
            while(result.next()){
                myDoc = new Document(result.getInt("doc_ID"), result.getString("prog_ID"), 
                        result.getString("doc_Name"), result.getString("doc_Type"));
                docArrList.add(myDoc);
            }
            conn.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return docArrList;
    }    
    
    /**
     * Models the connection to a database system
     * @return a database connection
     */
    public Connection dbConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql:"
                    + "//localhost:3306/citixpms", "root", "r00t101");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return conn;
    }
    
}