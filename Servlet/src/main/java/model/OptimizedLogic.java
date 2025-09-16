/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author HP
 */
public class OptimizedLogic {
    
    Connection con;
    Statement stmt;
    ResultSet rs;
    
    public OptimizedLogic(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:33013/dbemployee?useSSL=false", "root", "");
        } catch (ClassNotFoundException ex) {
             System.out.println("Driver not found");
        }
        catch(SQLException sq)
        {
            System.out.println("Could not connect to Database");
        }
    }
    
    public Collection<Employee> getAllEmployee(){
        Collection<Employee> employees = new ArrayList();
        
        try{
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery("select * from tblemp");
            
            while(rs.next())
            {
                Employee e = new Employee();
                e.setEmpno(rs.getInt("empno"));
                e.setEmpname(rs.getString("empname"));
                e.setSalary(rs.getDouble("salary"));
               
                
                employees.add(e);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return employees;
    }
    
    public void insertEmployee(int empno, String empname, double salary){
        try {
            String insert = "insert into tblemp values(?,?,?)";
            
            PreparedStatement stmt = con.prepareStatement(insert);
            stmt.setInt(1, empno);
            stmt.setString(2, empname);
            stmt.setDouble(3, salary);
            
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error"+e);
        }
    }
    
    public void RemoveEmployee(int empno){
        try {
            
            String del = "delete from tblemp where empno=?";
            PreparedStatement stmt = con.prepareStatement(del);
            
            stmt.setInt(1, empno);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error"+e);
        }
        
    }
    
    
    public double getGrossSalary()
    {
        double x =0;
        try {
            
            CallableStatement cs = con.prepareCall("{call grossSalary(?)}");
            cs.registerOutParameter(1, java.sql.Types.DOUBLE);
            ResultSet st = cs.executeQuery();
            
            x = cs.getDouble(1);
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return x;
    }
    
    
    public double getmaxSalary(){
        double msal =0;
        try {
            
            CallableStatement cs = con.prepareCall("{?=call maxSalary()}");
            cs.registerOutParameter(1, java.sql.Types.DOUBLE);
            
            cs.execute();
            
            msal = cs.getDouble(1);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return msal;
    }
    
}
