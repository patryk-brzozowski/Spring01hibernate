package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;

    public void savePublisher (Publisher publisher) {
        entityManager.persist(publisher);
    }

    public void updatePublisher (Publisher publisher) {
        entityManager.merge(publisher);
    }

    public Publisher findById(long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void deletePublisher(long id) {
        Publisher publisher = entityManager.find(Publisher.class, id);
        entityManager.remove(entityManager.contains(publisher) ?
                publisher : entityManager.merge(publisher));
    }

    public List<Publisher> getAll() {
        return entityManager.createQuery("SELECT p FROM Publisher p").getResultList();
    }
}
