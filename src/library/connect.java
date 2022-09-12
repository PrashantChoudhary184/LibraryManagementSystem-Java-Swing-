/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package library;

/**
 *
 * @author Prashant Choudhary
 */
import java.sql.*;
/**
 *
 * @author Prashant Choudhary
 */
class connect 
{
    Connection con;
    
    Connection connectDB()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e){}
        try
        {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root","prashant");
        }
        catch(SQLException e)
        {
            
        }
        System.out.print("connection found  :  "+con);
        return(con);
    }
    public static void main(String args[])
    {
        connect c1=new connect();
        c1.connectDB();
    }
    
}
