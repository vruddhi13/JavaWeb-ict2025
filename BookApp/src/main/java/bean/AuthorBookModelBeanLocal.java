/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/SessionLocal.java to edit this template
 */
package bean;

import entity.Author;
import entity.Book;
import jakarta.ejb.Local;
import java.util.List;

/**
 *
 * @author HP
 */
@Local
public interface AuthorBookModelBeanLocal {
    
    void addBookToAuthor(int authorId, int bookId);
    void removeBookFromAuthor(int authorId, int bookId);
    
    Author createAuthor(String name);
    Book createBook(String title);
    List<Author> getAllAuthors();
    List<Book> getAllBooks();
    
}
