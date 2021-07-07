package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.AuthorRepository;
import pl.coderslab.repository.PublisherRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/publisherform")
public class PublisherFormController {

    private PublisherRepository publisherDao;
    private BookDao bookDao;
    private final AuthorRepository authorDao;


    @Autowired
    public PublisherFormController(PublisherRepository publisherDao, BookDao bookDao, AuthorRepository authorDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    @RequestMapping("")
    public String getForm(Model model){
        model.addAttribute("publisher", new Publisher());
        return "/publisherform.jsp";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addPublisher(@Valid Publisher publisher, BindingResult result) {
        if(result.hasErrors()) {
            return "/publisherform.jsp";
        }
        publisherDao.save(publisher);
        return "/publisherform/show";
    }

    @RequestMapping(value = "/show")
    public String showPublishers(Model model){
        List<Publisher> publishers = publisherDao.findAll();
        model.addAttribute("publishers", publishers);
        return "/publishers.jsp";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateAuthorForm(@PathVariable long id, Model model) {
        Publisher publisher = publisherDao.findPublishersById(id);
        model.addAttribute("publisher", publisher);
        return "/publisherform.jsp";
    }
}
