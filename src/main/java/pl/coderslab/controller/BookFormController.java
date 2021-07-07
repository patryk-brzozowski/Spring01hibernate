package pl.coderslab.controller;

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
import pl.coderslab.model.Category;
import pl.coderslab.model.Publisher;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.CategoryRepository;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/bookform")
public class BookFormController {

    private PublisherDao publisherDao;
    private BookRepository bookDao;
    private AuthorDao authorDao;
    private CategoryRepository categoryDao;

    @Autowired
    public BookFormController(PublisherDao publisherDao, BookRepository bookDao, AuthorDao authorDao, CategoryRepository categoryDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
        this.authorDao = authorDao;
        this.categoryDao = categoryDao;
    }

    @RequestMapping("")
    public String getForm(Model model){
        model.addAttribute("book", new Book());
        return "/bookform.jsp";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String addBook(@Valid Book book, BindingResult result) {
        if(result.hasErrors()) {
            return "/bookform.jsp";
        }
        bookDao.save(book);
        return "/bookform/show";
    }

    @RequestMapping(value = "/show")
    public String showBooks(Model model){
        List<Book> books = bookDao.findAll();
        model.addAttribute("books", books);
        return "/books.jsp";
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String updateBookForm( @PathVariable long id, Model model) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "/bookform.jsp";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBookForm(@PathVariable long id, Model model) {
        Book book = bookDao.findById(id);
        model.addAttribute("book", book);
        return "/bookdelete.jsp";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String updateBook(@Valid Book book, BindingResult result) {
        if(result.hasErrors()) {
            return "/bookform.jsp";
        }
        bookDao.save(book);
        return "Book updated";
    }
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public String deleteBook(@RequestParam long id) {
        bookDao.deleteById(id);
        return "Book deleted";
    }

    @ModelAttribute("ratings")
    public List<String> ratings() {
        return Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers() {
        return publisherDao.getAll();
    }

    @ModelAttribute("authors")
    public List<Author> authors() {
        return authorDao.getAll();
    }

    @ModelAttribute("categories")
    public List<Category> categories() {
        return categoryDao.findAll();
    }

    @RequestMapping(value = "/show/rating")
    public String showBooksByRating(Model model, @RequestParam int rating){
        List<Book> books = bookDao.findBooksByRating(rating);
        model.addAttribute("books", books);
        return "/books.jsp";
    }

    @RequestMapping(value = "/show/publisher")
    public String showBooksByPublisher(Model model, @RequestParam int id){
        Publisher publisher = publisherDao.findById(id);
        List<Book> books = bookDao.findBooksByPublisher(publisher);
        model.addAttribute("books", books);
        return "/books.jsp";
    }

}
