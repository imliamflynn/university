package examiner.controllers;

import examiner.domain.Committee;
import examiner.domain.Examiner;
import examiner.domain.Student;
import examiner.domain.User;
import examiner.services.CommitteeService;
import examiner.services.ExaminerService;
import examiner.services.UserService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CommitteeSelectionController {

    private ExaminerService examinerService;
    private UserService uS;
    private CommitteeService cS;

    @Autowired
    public CommitteeSelectionController(ExaminerService e, UserService uS, CommitteeService cS) {
        this.examinerService = e;
        this.uS = uS;
        this.cS = cS;
    }

    @GetMapping("/committeeselection")
    public String showCommitteeSelection(Model model, HttpSession session) {
        model.addAttribute("userFirstName", session.getAttribute("userFirstName"));
        List<Examiner> examiners = examinerService.getExaminers();
        model.addAttribute("examiners", examiners);

        return "committeeselection";
    }

    @GetMapping("/add/{id}")
    public String addExaminer(Model model, @PathVariable("id") Long id, HttpSession session) {
        model.addAttribute("userFirstName", session.getAttribute("userFirstName"));
        Examiner examiner = examinerService.getExaminerById(id);
        model.addAttribute("examiner", examiner);

        Object currentUserIDObj = session.getAttribute("user_ID");

        String currentUserIDString = currentUserIDObj.toString();

        long currentUserID = Long.parseLong(currentUserIDString);

        User currentUser = uS.getUserById(currentUserID);

        Student userStudent = currentUser.getStudent();

        Committee studentCommittee = userStudent.getCommittee();

        List<Examiner> currentCommittee = studentCommittee.getExaminers();

        currentCommittee.add(examiner);

        studentCommittee.setExaminers(currentCommittee);

        cS.saveCommittee(studentCommittee);

        return "add";
    }

}
