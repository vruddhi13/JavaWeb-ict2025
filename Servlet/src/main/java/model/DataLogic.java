/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author HP
 */
public class DataLogic {
    
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    
    public DataLogic(){
        try {
            //Load the driver
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:33013/dbemployee?useSSL=false", "root", "");
            
            if(con!=null)
            {
                System.out.println("Connection Established!!");
            }
            else{
                System.out.println("Could not connect to databse");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
        }
        catch(SQLException sq)
        {
            System.out.println("Could not connect to Database");
        }
    }
    
    public Collection<Employee> getAllEmployee()
    {
        Collection<Employee> employee = new ArrayList<>();
        
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from tblemp");
            
            while(rs.next())
            {
                Employee e = new Employee();
                e.setEmpno(rs.getInt("empno"));
                e.setEmpname(rs.getString("empname"));
                e.setSalary(rs.getDouble("salary"));
                
                employee.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return employee;
    }
    
    public void insertEmployee(int empno, String empname, double salary)
    {
        try {
            Statement stmt = con.createStatement();
            String insert = "insert into tblemp values("+empno+","+empname+","+salary+")";
            stmt.executeUpdate(insert);
        } catch (SQLException e) {
            Logger.getLogger(DataLogic.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void removeEmployee(int empno)
    {
        try {
            
            Statement stmt = con.createStatement();
            String del = "delete from tblemp where empno="+empno;
            stmt.executeUpdate(del);
        } 
        catch (SQLException e) {
            Logger.getLogger(DataLogic.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static void main(String[] args) {
       
    }
}



