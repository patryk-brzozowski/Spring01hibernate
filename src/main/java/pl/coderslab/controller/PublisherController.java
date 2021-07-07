package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.PublisherDao;
import pl.coderslab.model.Publisher;

@Controller
@RequestMapping(value = "/publisher")
public class PublisherController {

    private final PublisherDao publisherDao;

    @Autowired
    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String savePublisher(@RequestBody Publisher publisher) {
        publisherDao.savePublisher(publisher);
        return "Publisher added";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String updatePublisher(@RequestBody Publisher publisher) {
        publisherDao.updatePublisher(publisher);
        return "Publisher updated";
    }

    @RequestMapping(value = "/{id}")
    @ResponseBody
    public String findById(@PathVariable long id) {
        return publisherDao.findById(id).toString();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public String deletePublisher(@PathVariable long id) {
        publisherDao.deletePublisher(id);
        return "Publisher deleted";
    }
}
