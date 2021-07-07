package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveBook (Book book) {
        entityManager.persist(book);
    }

    public void updateBook (Book book) {
        entityManager.merge(book);
    }

    public Book findById(long id) {
        return entityManager.find(Book.class, id);
    }

    public void deleteBook(Long id) {
        Book book = entityManager.find(Book.class, id);
        entityManager.remove(entityManager.contains(book) ?
                book : entityManager.merge(book));
    }

    public List<Book> getAll() {
        return entityManager.createQuery("SELECT b FROM Book b").getResultList();
    }

    public List<Book> findAllByRating(int rating) {
        Query query = entityManager.createQuery("SELECT book FROM Book book WHERE book.rating = :rating");
        query.setParameter("rating", rating);
        return query.getResultList();
    }

    public List<Book> getBooksWithPublisher() {
        return entityManager.createQuery("SELECT b FROM Book b WHERE b.publisher IS NOT NULL ").getResultList();
    }

    public List<Book> getBooksByPublisher(Publisher publisher) {
        Query query = entityManager.createQuery("SELECT b FROM Book b JOIN b.publisher WHERE b.publisher = :publisher ");
        query.setParameter("publisher", publisher);
        return query.getResultList();
    }

    public List<Book> getBooksByAuthor(Author author) {
        Query query = entityManager.createQuery("SELECT DISTINCT b FROM Book b JOIN FETCH b.authors WHERE :author MEMBER OF b.authors");
        query.setParameter("author", author);
        return query.getResultList();
    }
}
