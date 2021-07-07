package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.model.Author;
import pl.coderslab.model.Book;
import pl.coderslab.dao.BookDao;
import pl.coderslab.model.Publisher;
import pl.coderslab.dao.PublisherDao;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Controller
@RequestMapping(value = "/book")
public class BookController {

    private final BookDao bookDao;
    private final PublisherDao publisherDao;
    private final AuthorDao authorDao;

    @Autowired
    public BookController(BookDao bookDao, PublisherDao publisherDao, AuthorDao authorDao) {
        this.bookDao = bookDao;
        this.publisherDao = publisherDao;
        this.authorDao = authorDao;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
//    public String saveBook(@RequestBody Book book) {
    public String saveBook() {
        Publisher publisher = new Publisher();
        publisher.setName("publisher");
        publisherDao.savePublisher(publisher);
        Author author1 = authorDao.findById(1);
        Author author2 = authorDao.findById(2);
        Book book = new Book();
        book.setTitle("Thinking in Java ");
        book.setPublisher(publisher);
        book.addAuthors(author1);
        book.addAuthors(author2);
        bookDao.saveBook(book);
        return "Id dodanej książki to:" + book.getId();
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String updateBook(@RequestBody Book book) {
        bookDao.updateBook(book);
        return "Book updated";
    }

    @RequestMapping(value = "/{id}")
    @ResponseBody
    public String findById(@PathVariable long id) {
        return bookDao.findById(id).toString();
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        bookDao.deleteBook(id);
        return "Book deleted";
    }

    @RequestMapping(value = "/getall")
    @ResponseBody
    public String getAll() {
        System.out.println(bookDao.getAll());
        return "Lista zwrócona do konsoli";
    }

    @RequestMapping(value = "/getallwithpublisher")
    @ResponseBody
    public String getBooksWithPublisher() {
        System.out.println(bookDao.getBooksWithPublisher());
        return "Lista zwrócona do konsoli";
    }

    @RequestMapping(value = "/getallbypublisher")
    @ResponseBody
    public String getBooksByPublisher() {
        Publisher publisher = publisherDao.findById(1);
        System.out.println(bookDao.getBooksByPublisher(publisher));
        return "Lista zwrócona do konsoli";
    }

    @RequestMapping(value = "/getallbyauthor")
    @ResponseBody
    public String getBooksByAuthor() {
        Author author = authorDao.findById(1);
        System.out.println(bookDao.getBooksByAuthor(author));
        return "Lista zwrócona do konsoli";
    }

}
