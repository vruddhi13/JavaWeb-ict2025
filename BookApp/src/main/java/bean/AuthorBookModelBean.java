/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB40/StatelessEjbClass.java to edit this template
 */
package bean;

import entity.Author;
import entity.Book;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author HP
 */
@Stateless
public class AuthorBookModelBean implements AuthorBookModelBeanLocal {
    
    @PersistenceContext(unitName="bookpub")
    EntityManager em;

    @Override
    public void addBookToAuthor(int authorId, int bookId) {
        Author author = em.find(Author.class, authorId);
        Book book = em.find(Book.class, bookId);
        if(author!=null && book!=null){
            if (!author.getBooks().contains(book)) {
                author.getBooks().add(book);
            }
            if (!book.getAuthors().contains(author)) {
                book.getAuthors().add(author); // Update inverse side for consistency
            }
            em.merge(author);
        }
    }

    @Override
    public void removeBookFromAuthor(int authorId, int bookId) {
        Author author = em.find(Author.class, authorId);
        Book book = em.find(Book.class, bookId);
        if(author!=null && book!=null){
            author.getBooks().remove(book);
            em.merge(author);
        }
    }

    @Override
    public List<Author> getAllAuthors() {
        return em.createQuery("SELECT DISTINCT a FROM Author a LEFT JOIN FETCH a.books",Author.class).getResultList();
    }

    @Override
    public List<Book> getAllBooks() {
        return em.createQuery("SELECT DISTINCT b FROM Book b LEFT FETCH b.authors",Book.class).getResultList();
    }

    @Override
    public Author createAuthor(String name) {
        Author author = new Author(name);
        em.persist(author);
        return author;
    }

    @Override
    public Book createBook(String title) {
        Book book = new Book(title);
        em.persist(book);
        return book;
    }

   
}

