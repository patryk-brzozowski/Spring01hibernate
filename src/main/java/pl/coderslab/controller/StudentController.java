package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @RequestMapping("/form")
    public String getForm(Model model){
        model.addAttribute("student", new Student());
        return "/student.jsp";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    @ResponseBody
    public String createStudent(Student student) {
        System.out.println(student);
        return "student created";
    }

    @ModelAttribute("genders")
    public List<String> genders(){
        List<String> genders = new ArrayList<>();
        genders.add("Male");
        genders.add("Female");
        return genders;
    }

    @ModelAttribute("countries")
    public List<String> countries() {
        return Arrays.asList("Poland", "Germany", "France", "Russia", "Denmark");
    }

    @ModelAttribute("skills")
    public List<String> skills() {
        List<String> skills = new ArrayList<>();
        skills.add("php");
        skills.add("java");
        skills.add("ruby");
        skills.add("python");

        return skills;
    }

    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        List<String> skills = new ArrayList<>();
        skills.add("soccer");
        skills.add("sailing");
        skills.add("cooking");
        skills.add("computer games");

        return skills;
    }
}
