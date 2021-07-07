package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.Author;

import java.util.List;


public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findAuthorByEmail(String email);

    Author findAuthorByPesel(String pesel);

    List<Author> findAuthorsByLastName (String lastName);
}
