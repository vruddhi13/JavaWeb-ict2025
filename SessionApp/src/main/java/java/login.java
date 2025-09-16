/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package java;

import java.io.*;
import jakarta.servlet.*;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

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
            out.println("<title>Servlet login</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
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
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        /* Obtaining the output stream */
        PrintWriter out = response.getWriter();

        /* Memory variables that will hold the username and password */
        String username = "";
        String password = "";

        /* Retrieving all unexpired cookies */
        Cookie[] cookies = request.getCookies();

        /* If cookies were retrieved */
        if (cookies != null) {
            /* Traversing across all the cookies and extracting the username and password from the ValidUser and ValidPassword cookies respectively. */
            for (int i = 0; i < cookies.length; i++) {
                Cookie thisCookie = cookies[i];

                if (thisCookie.getName().equals("ValidUser")) {
                    username = thisCookie.getValue();
                } else if (thisCookie.getName().equals("ValidPassword")) {
                    password = thisCookie.getValue();
                }
            }
        }

        /* Generating the actual Login form user interface */
        out.println("<HTML><HEAD><TITLE>Login Form</TITLE></HEAD>");
        out.println("<BODY><FORM ACTION='/SessionApps/RememberMe' METHOD='post' NAME='frmLogin'>");
        out.println("<TABLE><TR><TD ALIGN='center'><IMG SRC='/security.jpg' WIDTH='64' HEIGHT='64' BORDER='0'>");

        out.println("<TABLE WIDTH='25%' BORDER='1' ALIGN='center' CELLPADDING='3' CELLSPACING='1' BORDERCOLOR='#000000'>");
        out.println("<TR BORDERCOLOR='#92CAEB' BGCOLOR='white'><TD COLSPAN='2'>Member Login</TD></TR>");
        out.println("<TR BORDERCOLOR='#E6F3FB'><TD ALIGN='right'>Username:</TD><TD>");
        out.println("<INPUT NAME='txtusername' TYPE='text' TABINDEX='1' VALUE='" + username + "' SIZE='15' MAXLENGTH='15'></TD>");
        out.println("</TR><TR BORDERCOLOR='#E6F3FB'><TD ALIGN='right'>Password:</TD><TD>");
        out.println("<INPUT NAME='txtpassword' TYPE='password' TABINDEX='2' VALUE='" + password + "' SIZE='15' MAXLENGTH='15'></TD></TR>");
        out.println("<TR BORDERCOLOR='#E6F3FB'><TD COLSPAN='2' ALIGN='right'>");
        out.println("<INPUT NAME='chkrem' TYPE='checkbox' VALUE='REMEMBER' TABINDEX='3'>REMEMBER ME</TD></TR>");
        out.println("<TR BORDERCOLOR='#E0EEF7'><TD COLSPAN='2' ALIGN='right'>");
        out.println("<INPUT NAME='submit' TYPE='submit' VALUE='Sign In' TABINDEX='4'></TD></TR>");
        out.println("</TABLE></TD></TR></TABLE></FORM></BODY></HTML>");

        /* Closing the output stream */
        out.close();
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
    public void doPost(HttpServletRequest request, HttpServletResponse response)
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
