package pl.coderslab.controller;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.BookDao;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/authorform")
public class AuthorFormController {


    private PublisherDao publisherDao;
    private BookDao bookDao;
    private AuthorDao authorDao;

//    OGARNĄĆ USUWANIE

    @Autowired
    public AuthorFormController(PublisherDao publisherDao, BookDao bookDao, AuthorDao authorDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
        this.authorDao = authorDao;
    }

    @RequestMapping("")
    public String getForm(Model model){
        model.addAttribute("author", new Author());
        return "/authorform.jsp";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addAuthor(@Valid Author author, BindingResult result) {
        if(result.hasErrors()) {
            return "/authorform.jsp";
        }
        authorDao.saveAuthor(author);
        return "/authorform/show";
    }

    @RequestMapping(value = "/show")
    public String showAuthors(Model model){
        List<Author> authors = authorDao.getAll();
        model.addAttribute("authors", authors);
        return "/authors.jsp";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateAuthorForm(@PathVariable long id, Model model) {
        Author author = authorDao.findById(id);
        model.addAttribute("author", author);
        return "/authorform.jsp";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteAuthorForm(@PathVariable long id, Model model) {
        Author author = authorDao.findById(id);
        model.addAttribute("author", author);
        return "/authordelete.jsp";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateAuthor(@Valid Author author, BindingResult result) {
        if(result.hasErrors()) {
            return "/authorform.jsp";
        }
        authorDao.updateAuthor(author);
        return "/authorform/show";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String deleteAuthor(@RequestParam long id) {
        authorDao.deleteAuthor(id);
        return "Author deleted";
    }

}
