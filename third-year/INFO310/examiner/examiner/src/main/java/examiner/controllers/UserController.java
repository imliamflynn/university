package examiner.controllers;

import examiner.domain.User;
import examiner.services.ExaminerService;
import examiner.services.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserService userService;
    private ExaminerService examinerService;

    @Autowired
    public UserController(UserService u, ExaminerService e) {
        this.userService = u;
        this.examinerService = e;
    }

    @GetMapping("/register")
    public String showRegister(Model model) {
        User user = new User();
        model.addAttribute("registerRequest", user);

        return "register";
    }

    @PostMapping("/registerPost")
    public String register(@ModelAttribute("user") User user, HttpSession session) {
        System.out.println("Register request: " + user);
        User registeredUser = userService.registerUser(user.getUsername(), user.getPassword());
        System.out.println("Registered user: " + registeredUser);

        User authenticatedUser = userService.authenticate(user.getUsername(), user.getPassword());

        session.setAttribute("user_ID", authenticatedUser.getUserID());

//        System.out.println("==============================================");
//        System.out.println(session.getAttribute("user_ID"));
//        System.out.println("==============================================");
        return registeredUser == null ? "error" : "redirect:/registerstudent";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {
        User user = new User();
        model.addAttribute("loginRequest", user);

        return "login";
    }

    @PostMapping("/loginPost")
    public String login(@ModelAttribute User user, Model model, HttpSession session) {
        System.out.println("Login request: " + user);
        User authenticatedUser = userService.authenticate(user.getUsername(), user.getPassword());

        if (authenticatedUser != null) {
            model.addAttribute("userLogin", authenticatedUser.getUsername());
            /*List<Examiner> examiners = examinerService.getExaminers();
            model.addAttribute("examiners", examiners);*/

            session.setAttribute("user", authenticatedUser);
            session.setAttribute("userFirstName", authenticatedUser.getUsername());
            session.setAttribute("user_ID", authenticatedUser.getUserID());

            return "redirect:home";
        } else {
            return "error";
        }
    }

    @GetMapping("/editdetails")
    public String getStudents(Model model, HttpSession session) {
        model.addAttribute("userFirstName", session.getAttribute("userFirstName"));

        return "editdetails";
    }

}
