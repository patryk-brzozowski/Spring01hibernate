package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PersonDao;
import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.model.Person;
import pl.coderslab.model.PersonDetails;

@Controller
@RequestMapping(value = "/person")
public class PersonController {

    private final PersonDao personDao;
    private final PersonDetailsDao personDetailsDao;

    @Autowired
    public PersonController(PersonDao personDao, PersonDetailsDao personDetailsDao) {
        this.personDao = personDao;
        this.personDetailsDao = personDetailsDao;
    }

    @RequestMapping(value = "")
    @ResponseBody
    public String addPerson() {
        Person person = new Person();
        person.setLogin("login");
        person.setEmail("email@wp.pl");
        person.setPassword("admin");

        PersonDetails personDetails = new PersonDetails();
        personDetails.setPerson(person);
        personDetails.setCity("Lublin");
        personDetails.setFirstName("Janusz");
        personDetails.setLastName("Tracz");

        person.setPersonDetails(personDetails);
        personDao.savePerson(person);

        return "New person added";
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public String updatePerson() {
        Person person = personDao.findById(1);
        person.setLogin("login2");
        person.setEmail("email2@wp.pl");
        person.setPassword("admin2");

        personDao.updatePerson(person);

        return "Person updated";
    }

    @RequestMapping(value = "/details", method = RequestMethod.PUT)
    @ResponseBody
    public String updatePersonDetails() {
        PersonDetails personDetails = personDetailsDao.findById(1);
        personDetails.setStreet("Gliniana");
        personDetails.setStreetNumber(12);

        personDetailsDao.updatePersonDetails(personDetails);

        return "Person details updated";
    }

    @RequestMapping(value = "/", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletePerson() {
        personDao.deletePerson(1L);

        return "Person deleted";
    }

    @RequestMapping(value = "/{id}")
    @ResponseBody
    public String getPerson(@PathVariable Long id) {
        return personDao.findById(id).toString();
    }

    @RequestMapping(value = "/details/{id}")
    @ResponseBody
    public String getPersonDetails(@PathVariable Long id) {
        return personDetailsDao.findById(id).toString();
    }

    @GetMapping("/personform")
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "/form.jsp";
    }

//    @PostMapping("/personold")
//    public String addPerson(String login, String password, String email) {
//        Person person = new Person();
//        person.setLogin(login);
//        person.setPassword(password);
//        person.setEmail(email);
//        System.out.println(person);
//        return "success.jsp";
//    }

    @PostMapping("/personform")
    public String addPerson(Person person) {
        System.out.println(person);
        return "/form.jsp";
    }
}
