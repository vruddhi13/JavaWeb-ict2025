/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import bean.AuthorBookModelBeanLocal;
import entity.Author;
import entity.Book;
import jakarta.ejb.EJB;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author HP
 */
@WebServlet(name = "AuthorBookServlet", urlPatterns = {"/AuthorBookServlet"})
public class AuthorBookServlet extends HttpServlet {
    @EJB
    private AuthorBookModelBeanLocal model;

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
            out.println("<title>Servlet AuthorBookServlet</title>");
            out.println("</head>");
            out.println("<body>");
            
//            Author a1 = new Author("J.P. Shah");
//            Book b1 = new Book("Harry Potter");

//            model.createAuthor("J.P.Shah");
//            model.createBook("Harry Potter");
//            
//            List<Author> authors = model.getAllAuthors();
//            List<Book> books = model.getAllBooks();
//            
//            if(!authors.isEmpty() && !books.isEmpty()){
//                Author a1 = authors.get(0);
//                Book b1 = books.get(0);
//                
//                model.addBookToAuthor(a1.getAuthorId(), b1.getBookId());
//                out.println("<h2>Test Data Created and Relationship Established.</h2>");
//            }else {
//             out.println("<h2>Error: Could not retrieve Authors or Books for testing.</h2>");
//        }
//            
//            
//            
//            out.println("<h3>Author Wise Books: </h3>");
//            
//            for(Author a : authors){
//                out.println("<b>"+a.getName()+ "</b><br>");
//                for(Book b : a.getBooks()){
//                    out.println("-"+b.getTitle()+"<br>");
//                }
//                out.println("<br>");
//            }
//            
//            out.println("<h3>Book-Wise Authors: </h3>");
//            
//            for(Book b: books){
//                out.println("<b>"+ b.getTitle() + "<b></br>");
//                for(Author a: b.getAuthors()){
//                    out.println("-"+a.getName()+"<br>");
//                }
//                out.println("<br>");
//            }

                Author a1 = model.createAuthor("JJJJ");
                Book b1 = model.createBook("gdhsd");
                
                model.addBookToAuthor(a1.getAuthorId(), b1.getBookId());
                out.println(a1.getAuthorId()+ "- "+b1.getBookId());
                
               List<Author> authors = model.getAllAuthors();
                for (Author a : authors) {
                    out.println("<b>" + a.getName() + "</b><br>");
                    for (Book b : a.getBooks()) {
                        out.println("-" + b.getTitle() + "<br>");
                    }
                    out.println("<br>");
                }
            
            out.println("<h1>Servlet AuthorBookServlet at " + request.getContextPath() + "</h1>");
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
