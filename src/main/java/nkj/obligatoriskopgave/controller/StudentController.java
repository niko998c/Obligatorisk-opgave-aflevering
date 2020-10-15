package nkj.obligatoriskopgave.controller;

import nkj.obligatoriskopgave.model.Student;
import nkj.obligatoriskopgave.model.Teacher;
import nkj.obligatoriskopgave.repository.CourseRepository;
import nkj.obligatoriskopgave.repository.StudentRepository;
import nkj.obligatoriskopgave.repository.TeacherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class StudentController {

    StudentRepository studentRepository;
    TeacherRepository teacherRepository;
    CourseRepository courseRepository;

    public StudentController(StudentRepository studentRepository, TeacherRepository teacherRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.courseRepository = courseRepository;
    }

    @GetMapping("/")
    public String index(@ModelAttribute Student student, @ModelAttribute Teacher teacher, Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("teachers", teacherRepository.findAll());
        model.addAttribute("courses", courseRepository.findAll());
        return "index";
    }

    @GetMapping("/createStudent")
    public String createTeacher(Model model) {
        model.addAttribute("student", new Student());
        return "createStudent";
    }

    @PostMapping("/createStudent")
    public String createStudent(@ModelAttribute Student student, HttpServletRequest request){
        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        Student s = new Student(fName, lName);
        studentRepository.save(s);
        return "redirect:/";
    }
}