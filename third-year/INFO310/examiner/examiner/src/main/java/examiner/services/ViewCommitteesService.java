/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examiner.services;

import examiner.domain.Committee;
import examiner.repositories.ViewCommitteesRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Enrico
 */
@Service
public class ViewCommitteesService {

    private final ViewCommitteesRepository vCR;

    @Autowired
    public ViewCommitteesService(ViewCommitteesRepository vCR) {
        this.vCR = vCR;
    }

    public List<Committee> getCommittees() {
        return vCR.findAll();
    }

    public void editCommmittee(Committee c) {
        vCR.save(c);
    }

    public Committee getCommitteeById(Long id) {
        Optional<Committee> result = vCR.findById(id);

        return result.get();
    }

}
