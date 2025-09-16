/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collection;
import model.Employee;
import model.OptimizedLogic;


/**
 *
 * @author HP
 */
@WebServlet(name = "EmpServlet", urlPatterns = {"/EmpServlet"})
public class EmpServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmpServlet</title>");
            out.println("</head>");
            out.println("<body>");
            
//            DataLogic d1 = new DataLogic();
//            d1.removeEmployee(1);

            OptimizedLogic op = new OptimizedLogic();
            
            op.insertEmployee(3, "Lisa", 20000);
            op.insertEmployee(4,"Jennie", 4000000);
            op.insertEmployee(5, "Jisso", 4667888);
           
            
            Collection<Employee> employee = op.getAllEmployee();
            
            out.println("<h1>Employee List</h1>");
            out.println("<table border='1'>");
            out.println("<tr><th>Emp No</th><th>Emp Name</th><th>Salary  </th> </tr>");
            
            
            for(Employee e : employee)
            {
                out.println("<tr>");
                out.println("<td>"+e.getEmpno()+"</td>");
                out.println("<td>"+e.getEmpname()+"</td>");
                out.println("<td>"+e.getSalary()+"</td>");
                
                out.println("</tr>");
                
            }
            
            out.println("<br/>Gross Total = "+op.getGrossSalary()+ " Max Salary =" + op.getmaxSalary());
                    
            
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
