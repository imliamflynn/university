/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examiner.controllers;

import examiner.domain.Committee;
import examiner.services.ViewCommitteesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

/**
 *
 * @author Enrico
 */
@Controller
public class ViewCommitteesController {

    private ViewCommitteesService vCS;

    @Autowired
    public ViewCommitteesController(ViewCommitteesService vCS) {
        this.vCS = vCS;
    }

    @GetMapping("/viewcommittees")
    public String showCommittees(Model model, HttpSession session) {
        model.addAttribute("userFirstName", session.getAttribute("userFirstName"));
        List<Committee> committees = vCS.getCommittees();
        model.addAttribute("committees", committees);

        Committee committee = new Committee();
        model.addAttribute("committee", committee);

        return "viewcommittees";
    }

//    @GetMapping("/edit/{id}")
//    public String editCommittee(Model model, @PathVariable("id") Long id) {
//        Committee committee = vCS.getCommitteeById(id);
//        model.addAttribute("committee", committee);
//
//        return "edit";
//    }
//
//    @PostMapping("/editCommittee/{id}")
//    public String editCommittee(@ModelAttribute("committee") Committee c, @PathVariable("id") Long id) {
//        c.setCommitteeID(id);
//        vCS.editCommmittee(c);
//
//        return "redirect:/examiner";
//    }
//    @PostMapping("/saveCommittee")
//    public String saveExaminer(@ModelAttribute("examiner") Examiner e) {
//        examinerService.insertorEditExaminer(e);
//
//        return "redirect:/examiner";
//    }
}
