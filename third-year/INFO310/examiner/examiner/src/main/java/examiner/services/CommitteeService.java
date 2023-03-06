/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examiner.services;

import examiner.domain.Committee;
import examiner.domain.Examiner;
import examiner.repositories.CommitteeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 *
 * @author Enrico
 */
@Service
public class CommitteeService {

    private final CommitteeRepository cR;

    public CommitteeService(CommitteeRepository cR) {
        this.cR = cR;
    }

    public void saveCommittee(Committee c) {
        cR.save(c);
    }

    public Committee getCommittee(Long id) {
        Optional<Committee> result = cR.findById(id);

        return result.get();
    }

    public List<Examiner> getCommitteeExaminers(Long committeeID) {
        Optional<Committee> c = cR.findById(committeeID);
        List<Examiner> committeeExaminers = c.get().getExaminers();

        return committeeExaminers;
    }

    public void deleteCommitteeExaminer(Long id) {
        cR.deleteById(id);
    }
}
