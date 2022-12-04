package com.akhil.salesken.controller;

import com.akhil.salesken.entity.Student;
import com.akhil.salesken.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String listAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @RequestMapping(value = "/students/new", method = RequestMethod.GET)
    public String addNewStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "new_student";
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @RequestMapping(value = "/students/edit/{id}", method = RequestMethod.GET)
    public String editStudent(@PathVariable Long id, Model model) {
        model.addAttribute("user", studentService.getStudent(id));
        return "edit_student";
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.POST)
    public String updateStudent(@PathVariable Long id,
                             @ModelAttribute("user") Student student, Model model) {
        studentService.deleteStudent(id);
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

//    @RequestMapping(value = "/students/{sem}", method = RequestMethod.GET)
//    public String delStudent(@PathVariable int sem) {
//        studentService.averageMarks(sem);
//        return "redirect:/students";
//    }

    @RequestMapping(value = "/students/avg", method = RequestMethod.GET)
    public String averageStudents(Model model) {
        List<Float> ans = studentService.averageMarks();
        model.addAttribute("average1",ans.get(0));
        model.addAttribute("average2", ans.get(1));
        return "redirect:/average";
    }
}
