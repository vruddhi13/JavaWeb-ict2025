/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoJava_code;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.*;
import entity.*;
import daoJava_code.AuthorBookModel;
/**
 *
 * @author HP
 */
public class TestAuthorBook {
    
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookpub");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        Author a1 = new Author("J.K.Rowl");
        Author a2 = new Author("George R.R");
        
        
        Book b1 = new Book("Harry Potter");
        Book b2 = new Book("Game of throns");
        Book b3 = new Book("eva");
        
        em.persist(a1);
        em.persist(a2);
        em.persist(b1);
        em.persist(b2);
        em.persist(b3);
        
        em.getTransaction().commit();
        
        //operations
        AuthorBookModel model = new AuthorBookModel();
        model.addBookToAuthor(a1.getAuthorId(), b1.getBookId());
        model.addBookToAuthor(a1.getAuthorId(), b3.getBookId());
        model.addBookToAuthor(a2.getAuthorId(), b2.getBookId());
        
        model.showAuthorWiseBooks();
        model.showBookWiseAuthors();
        
        model.removeBookFromAuthor(a1.getAuthorId(), b1.getBookId());
        model.showAuthorWiseBooks();
        
    }
    
}
