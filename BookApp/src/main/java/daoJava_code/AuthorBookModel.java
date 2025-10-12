/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daoJava_code;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.*;
import entity.*;
import java.util.*;

/**
 *
 * @author HP
 */
public class AuthorBookModel {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("bookpub");
    EntityManager em = emf.createEntityManager();
    
    //add book to author
    public void addBookToAuthor(int authorId, int bookId){
        em.getTransaction().begin();
        Author author = em.find(Author.class, authorId);
        Book book = em.find(Book.class, bookId);
        author.getBooks().remove(book);
        em.merge(author);
        em.getTransaction().commit();
        System.out.println("Book removed from author successfully!!");
    }
    
    public void showAuthorWiseBooks(){
        List<Author> authors = em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
        System.out.println("\n Author-wise books:");
        for(Author a : authors){
            System.out.println("\nAuthor: "+a.getName());
            
            for(Book b: a.getBooks())
            {
                System.out.println(" - "+b.getTitle());
            }
        }
    }
    
    public void removeBookFromAuthor(int authorId, int bookId){
        em.getTransaction().begin();
        Author author = em.find(Author.class, authorId);
        Book book = em.find(Book.class, bookId);
        
        author.getBooks().remove(book);
        em.merge(author);
        em.getTransaction().commit();
        System.out.println("book Removed from author successfully!! ");
    }
    
    public void showBookWiseAuthors(){
        List<Book> books = em.createQuery("SELECT b FROM Book b", Book.class).getResultList();
        System.out.println("\n Book-wise Authors");
        for(Book b : books){
            System.out.println("\nBooks: "+b.getTitle() );
            
            for(Author a : b.getAuthors())
            {
                System.out.println("-"+a.getName());
            }
        }
    }
    
}
