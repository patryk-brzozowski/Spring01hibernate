package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.PersonDetails;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDetailsDao {

    @PersistenceContext
    EntityManager entityManager;

    public void savePersonDetails (PersonDetails personDetails) {
        entityManager.persist(personDetails);
    }

    public void updatePersonDetails (PersonDetails personDetails) {
        entityManager.merge(personDetails);
    }

    public PersonDetails findById(long id) {
        return entityManager.find(PersonDetails.class, id);
    }

    public void deletePersonDetails(Long id) {
        PersonDetails personDetails = entityManager.find(PersonDetails.class, id);
        entityManager.remove(entityManager.contains(personDetails) ?
                personDetails : entityManager.merge(personDetails));
    }
}
