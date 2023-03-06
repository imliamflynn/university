/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examiner.controllers;

import examiner.domain.Committee;
import examiner.domain.Student;
import examiner.domain.User;
import examiner.services.CommitteeService;
import examiner.services.StudentService;
import examiner.services.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author USER
 */
@Controller
public class StudentController {

    private StudentService sS;
    private UserService uS;
    private CommitteeService cS;

    @Autowired
    public StudentController(StudentService sS, UserService uS, CommitteeService cS) {
        this.sS = sS;
        this.uS = uS;
        this.cS = cS;
    }

    @GetMapping("/registerstudent")
    public String showRegisterStudent(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);

        return "registerstudent";
    }

    @PostMapping("/registerNewStudent")
    public String registerNewStudent(@ModelAttribute("student") Student s, HttpSession session) {

        Object currentUserIDObj = session.getAttribute("user_ID");

//        System.out.println("==============================================");
//        System.out.println(session.getAttribute("user_ID") + "Please don't be null this time");
//        System.out.println("==============================================");
        String currentUserIDString = currentUserIDObj.toString();

        long currentUserID = Long.parseLong(currentUserIDString);

        User currentUser = uS.getUserById(currentUserID);

        sS.registerStudent(s);

        Committee newCommittee = new Committee();

        cS.saveCommittee(newCommittee);

        uS.registerStudentUser(currentUser, s, newCommittee);

        return "redirect:/login";
    }

}
