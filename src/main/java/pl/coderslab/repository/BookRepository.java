package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Category;
import pl.coderslab.model.Publisher;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findBookByTitle(String title);

    List<Book> findBooksByCategory(Category category);

    List<Book> findBooksByCategoryId(Long id);

    List<Book> findBooksByAuthors(Author author);

    List<Book> findBooksByPublisher(Publisher publisher);

    List<Book> findBooksByRating(int rating);

    Book findFirstByCategoryOrderByTitle(Category category);

    Book findById(long id);

}
