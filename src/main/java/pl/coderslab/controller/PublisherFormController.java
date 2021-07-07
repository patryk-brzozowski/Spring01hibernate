package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.PublisherRepository;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/publisherform")
public class PublisherFormController {

    private final PublisherRepository publisherDao;
    private final BookDao bookDao;


    @Autowired
    public PublisherFormController(PublisherRepository publisherDao, BookDao bookDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
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
    public String updatePublisherForm(@PathVariable long id, Model model) {
        Publisher publisher = publisherDao.findPublishersById(id);
        model.addAttribute("publisher", publisher);
        return "/publisherform.jsp";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deletePublisherForm(@PathVariable long id, Model model) {
        Publisher publisher = publisherDao.findPublishersById(id);
        model.addAttribute("publisher", publisher);
        return "/publisherdelete.jsp";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updatePublisher(@Valid Publisher publisher, BindingResult result) {
        if(result.hasErrors()) {
            return "/publisherform.jsp";
        }
        publisherDao.save(publisher);
        return "/publisherform/show";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deletePublisher(@RequestParam long id) {
        Publisher publisher = publisherDao.findPublishersById(id);
        List<Book> books = bookDao.getAll();
        for (Book book : books) {
            if(book.getPublisher().getId() == publisher.getId()) {
                book.setPublisher(null);
                bookDao.updateBook(book);
            }
        }
        publisherDao.deleteById(id);
        return "/publisherform/show";
    }

    @RequestMapping(value = "/show/nip", method = RequestMethod.POST)
    public String showPublisherByNip(Model model, @RequestParam String nip){
        Publisher publisher = publisherDao.findPublisherByNip(nip);
        model.addAttribute("publishers", Arrays.asList(publisher));
        return "/publishers.jsp";
    }

    @RequestMapping(value = "/show/regon", method = RequestMethod.POST)
    public String showPublisherByRegon(Model model, @RequestParam String regon) {
        Publisher publisher = publisherDao.findPublisherByRegon(regon);
        model.addAttribute("publishers", Arrays.asList(publisher));
        return "/publishers.jsp";
    }
}
