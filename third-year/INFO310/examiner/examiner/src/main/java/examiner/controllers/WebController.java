package examiner.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String showIndex() {
        return "index";
    }

    @GetMapping("/convenor")
    public String showConvenor() {
        return "convenor";
    }

    @GetMapping("/home")
    public String showHome(Model model, HttpSession session) {
        model.addAttribute("userFirstName", session.getAttribute("userFirstName"));

        return "home";
    }

    @GetMapping("/thankyou")
    public String showThankYou(Model model, HttpSession session) {
        model.addAttribute("userFirstName", session.getAttribute("userFirstName"));

        return "thankyou";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userFirstName");
        session.removeAttribute("user");

        return "home";
    }

    @GetMapping("/userselection")
    public String showUserSelection(HttpSession session) {
        return "userselection";
    }
//
//    @GetMapping("/viewcommittees")
//    public String showViewCommittees(){
//        return "viewcommittees";
//    }
}
