/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package examiner.repositories;

import examiner.domain.Committee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Enrico
 */
@Repository
public interface ViewCommitteesRepository extends JpaRepository<Committee, Long> {

}
