package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Author;
import pl.coderslab.dao.AuthorDao;

@Controller
@RequestMapping(value = "/author")
public class AuthorController {

    private final AuthorDao authorDao;

    @Autowired
    public AuthorController(AuthorDao authorDao) {
        this.authorDao = authorDao;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String saveBook(@RequestBody Author author) {
        authorDao.saveAuthor(author);
        return "Author added";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String updateAuthor(@RequestBody Author author) {
        authorDao.updateAuthor(author);
        return "Author updated";
    }

    @RequestMapping(value = "/{id}")
    @ResponseBody
    public String findById(@PathVariable long id) {
        return authorDao.findById(id).toString();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteBook(@PathVariable long id) {
        authorDao.deleteAuthor(id);
        return "Author deleted";
    }


}
