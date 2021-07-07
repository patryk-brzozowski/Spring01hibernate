package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;
@Controller
public class ValidationController {
    @Autowired
    private Validator validator;

    @GetMapping("/validate")
    public String validate(Model model) {
        Book book = new Book();
        Set<ConstraintViolation<Book>> validate = validator.validate(book);
        System.out.println(validate);

        for (ConstraintViolation<Book> violation : validate) {
            System.out.println(violation.getPropertyPath() + " : " + violation.getMessage());
        }
        model.addAttribute("errors", validate);

        return "/validate.jsp";
    }

    @GetMapping("/validatepublisher")
    public String validatePublisher(Model model) {
        Publisher publisher = new Publisher();
        publisher.setName("gffggf");
        publisher.setNip("46456");
        publisher.setRegon("54353");
        Set<ConstraintViolation<Publisher>> validate = validator.validate(publisher);
        System.out.println(validate);

        for (ConstraintViolation<Publisher> violation : validate) {
            System.out.println(violation.getPropertyPath() + " : " + violation.getMessage());
        }
        model.addAttribute("errors", validate);

        return "/validate.jsp";
    }

}