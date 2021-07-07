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
import pl.coderslab.repository.AuthorRepository;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping(value = "/authorform")
public class AuthorFormController {


    private PublisherDao publisherDao;
    private BookDao bookDao;
    private final AuthorRepository authorDao;

//    OGARNĄĆ USUWANIE

    @Autowired
    public AuthorFormController(PublisherDao publisherDao, BookDao bookDao, AuthorRepository authorDao) {
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
        authorDao.save(author);
        return "/authorform/show";
    }

    @RequestMapping(value = "/show")
    public String showAuthors(Model model){
        List<Author> authors = authorDao.findAll();
        model.addAttribute("authors", authors);
        return "/authors.jsp";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateAuthorForm(@PathVariable long id, Model model) {
        Author author = authorDao.findAuthorById(id);
        model.addAttribute("author", author);
        return "/authorform.jsp";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteAuthorForm(@PathVariable long id, Model model) {
        Author author = authorDao.findAuthorById(id);
        List<Book> books = author.getBooks();
        for (Book book : books) {
            List<Author> authors = book.getAuthors();
            authors.removeIf(auth -> auth.getId() == author.getId());
            bookDao.updateBook(book);
        }
        model.addAttribute("author", author);
        return "/authordelete.jsp";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String updateAuthor(@Valid Author author, BindingResult result) {
        if(result.hasErrors()) {
            return "/authorform.jsp";
        }
        authorDao.save(author);
        return "/authorform/show";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public String deleteAuthor(@RequestParam long id) {
        authorDao.deleteById(id);
        return "/authorform/show";
    }

    @RequestMapping(value = "/show/pesel", method = RequestMethod.POST)
    public String showAuthorByPesel(Model model, @RequestParam String pesel){
        Author author = authorDao.findAuthorByPesel(pesel);
        model.addAttribute("authors", Arrays.asList(author));
        return "/authors.jsp";
    }

    @RequestMapping(value = "/show/email", method = RequestMethod.POST)
    public String showAuthorByEmail(Model model, @RequestParam String email){
        Author author = authorDao.findAuthorByEmail(email);
        model.addAttribute("authors", Arrays.asList(author));
        return "/authors.jsp";
    }

    @RequestMapping(value = "/show/lastName", method = RequestMethod.POST)
    public String showAuthorsByLastName(Model model, @RequestParam String lastName){
        List<Author> authors = authorDao.findAuthorsByLastName(lastName);
        model.addAttribute("authors", authors);
        return "/authors.jsp";
    }
}
