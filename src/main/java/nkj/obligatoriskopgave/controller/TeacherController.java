package nkj.obligatoriskopgave.controller;

import nkj.obligatoriskopgave.model.Teacher;
import nkj.obligatoriskopgave.repository.TeacherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TeacherController {

    TeacherRepository teacherRepository;

    public TeacherController(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @GetMapping("/createTeacher")
    public String createTeacher(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "createTeacher";
    }

    @PostMapping("/createTeacher")
    public String createTeacher(@ModelAttribute Teacher teacher, HttpServletRequest request){
        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        Teacher s = new Teacher(fName, lName);
        teacherRepository.save(s);
        return "redirect:/";
    }
}
