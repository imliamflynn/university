package examiner.controllers;

import examiner.domain.Examiner;
import examiner.services.ExaminerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ExaminersController {

    private ExaminerService examinerService;

    @Autowired
    public ExaminersController(ExaminerService e) {
        this.examinerService = e;
    }

    @GetMapping("/examiner")
    public String showExaminers(Model model, HttpSession session) {
        model.addAttribute("userFirstName", session.getAttribute("userFirstName"));
        List<Examiner> examiners = examinerService.getExaminers();
        model.addAttribute("examiners", examiners);

        Examiner examiner = new Examiner();
        model.addAttribute("examiner", examiner);

        return "examiner";
    }

    @PostMapping("/saveExaminer")
    public String saveExaminer(@ModelAttribute("examiner") Examiner e) {
        examinerService.insertorEditExaminer(e);

        return "redirect:/examiner";
    }

    @GetMapping("/edit/{id}")
    public String editExaminer(Model model, @PathVariable("id") Long id) {
        Examiner examiner = examinerService.getExaminerById(id);
        model.addAttribute("examiner", examiner);

        return "edit";
    }

    @PostMapping("/editExaminer/{id}")
    public String saveExaminer(@ModelAttribute("examiner") Examiner e, @PathVariable("id") Long id) {
        e.setExaminerID(id);
        examinerService.insertorEditExaminer(e);

        return "redirect:/examiner";
    }

    @GetMapping("/delete/{id}")
    public String deleteExaminer(@PathVariable("id") Long id) {
        examinerService.deleteExaminer(id);

        return "redirect:/examiner";
    }
}
