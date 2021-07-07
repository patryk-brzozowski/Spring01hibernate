package pl.coderslab.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Person;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PersonDao {

    @PersistenceContext
    EntityManager entityManager;

    public void savePerson (Person person) {
        entityManager.persist(person);
    }

    public void updatePerson (Person person) {
        entityManager.merge(person);
    }

    public Person findById(long id) {
        return entityManager.find(Person.class, id);
    }

    public void deletePerson(Long id) {
        Person person = entityManager.find(Person.class, id);
        entityManager.remove(entityManager.contains(person) ?
                person : entityManager.merge(person));
    }
}
