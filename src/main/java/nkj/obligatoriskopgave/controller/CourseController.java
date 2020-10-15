package nkj.obligatoriskopgave.controller;

import nkj.obligatoriskopgave.model.Course;
import nkj.obligatoriskopgave.repository.CourseRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CourseController {

    CourseRepository courseRepository;

    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/createCourse")
    public String createCourse(Model model) {
        model.addAttribute("course", new Course());
        return "createCourse";
    }

    @PostMapping("/createCourse")
    public String createCourse(@ModelAttribute Course course, HttpServletRequest request){
        String cName = request.getParameter("courseName");
        Course s = new Course(cName);
        courseRepository.save(s);
        return "redirect:/";
    }
}
