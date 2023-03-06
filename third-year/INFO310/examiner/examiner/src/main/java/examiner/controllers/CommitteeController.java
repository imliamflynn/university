/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examiner.controllers;

import examiner.domain.Committee;
import examiner.domain.Examiner;
import examiner.domain.Student;
import examiner.domain.User;
import examiner.services.CommitteeService;
import examiner.services.StudentService;
import examiner.services.UserService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Enrico
 */
@Controller
public class CommitteeController {

    private UserService uS;
    private StudentService sS;
    private CommitteeService cS;

    @Autowired
    public CommitteeController(CommitteeService cS, UserService uS, StudentService sS) {
        this.cS = cS;
        this.uS = uS;
        this.sS = sS;
    }

    @GetMapping("/mycommittee")
    public String getStudents(Model model, HttpSession session) {
        model.addAttribute("userFirstName", session.getAttribute("userFirstName"));

        Object currentUserIDObj = session.getAttribute("user_ID");

        String currentUserIDString = currentUserIDObj.toString();

        long currentUserID = Long.parseLong(currentUserIDString);

        User currentUser = uS.getUserById(currentUserID);

        Student userStudent = currentUser.getStudent();

        Committee studentCommittee = userStudent.getCommittee();

        System.out.println("==================================================");
        System.out.println();
        System.out.println(studentCommittee.getCommitteeID());
        System.out.println();
        System.out.println("==================================================");

//        Committee committee = cS.getCommittee(studentCommittee.getCommitteeID());
//        model.addAttribute("committee", committee);
//        model.addAttribute("committeeExaminers", committeeExaminers);
//
//        Examiner examiner = new Examiner();
//        model.addAttribute("examiner", examiner);
        List<Examiner> committeeExaminers = cS.getCommitteeExaminers(studentCommittee.getCommitteeID());
        model.addAttribute("committeeExaminers", committeeExaminers);

        Examiner examiner = new Examiner();
        model.addAttribute("examiner", examiner);

        return "mycommittee";

    }

    @GetMapping("/deleteCommitteeExaminer/{examinerID}")
    public String getStudents(Model model, HttpSession session, @PathVariable("examinerID") Long examinerID) {
        cS.deleteCommitteeExaminer(examinerID);

        return "redirect:/mycommittee";
    }

//    @GetMapping("/user/{userid}/student/{studentid}/showcommittee/{committeeid}")
//    public String showCommittee(Model model, HttpSession session, @PathVariable("userid") Long userID, @PathVariable("studentid") Long studentID, @PathVariable("committeeid") Long committeeID) {
//
//        User user = uS.getUserById(userID);
//        Student userStudent = user.getStudent();
//        Committee studentCommittee = userStudent.getCommittee();
//
////        if (Objects.equals(user.getUserID(), userID)
////                && Objects.equals(userStudent.getStudentID(), studentID)
////                && Objects.equals(studentCommittee.getCommitteeID(), committeeID)) {
//        List<Examiner> committeeExaminers = cS.getCommitteeExaminers(committeeID);
////
////            for (Examiner committeeExaminer : committeeExaminers) {
////
//        Committee committee = cS.getCommittee(committeeID);
//        model.addAttribute("committee", committee);
//        model.addAttribute("committeeExaminers", committeeExaminers);
//
//        Examiner examiner = new Examiner();
//        model.addAttribute("examiner", examiner);
////            }
////
//        return "mycommittee";
////        }
////
////        return "error";
//
//    }
}
