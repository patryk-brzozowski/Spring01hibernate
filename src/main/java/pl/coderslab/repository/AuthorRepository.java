package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.model.Author;

import java.util.List;


public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findAuthorById(long id);

    Author findAuthorByEmail(String email);

    Author findAuthorByPesel(String pesel);

    List<Author> findAuthorsByLastName (String lastName);

    @Query("SELECT a FROM Author a WHERE a.email LIKE ?1%")
    List<Author> findAuthorsByEmailStartingWith(String letters);

    @Query("SELECT a FROM Author a WHERE a.pesel LIKE ?1%")
    List<Author> findAuthorsByPeselStartingWith(String numbers);
}
