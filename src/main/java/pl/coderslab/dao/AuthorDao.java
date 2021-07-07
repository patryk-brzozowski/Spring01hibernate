package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void saveAuthor (Author author) {
        entityManager.persist(author);
    }

    public void updateAuthor (Author author) {
        entityManager.merge(author);
    }

    public Author findById(long id) {
        return entityManager.find(Author.class, id);
    }

    public void deleteAuthor(Long id) {
        Author author = entityManager.find(Author.class, id);
        entityManager.remove(entityManager.contains(author) ?
                author : entityManager.merge(author));
    }

    public List<Author> getAll() {
        return entityManager.createQuery("SELECT a FROM Author a").getResultList();
    }
}
