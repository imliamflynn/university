/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import domain.Examiner;
import java.util.Collection;

/**
 *
 * @author Enrico
 */
public interface ExaminerDAO {

    Collection<Examiner> filterByTopic(String category);

    Collection<String> getTopics();

    Collection<Examiner> getExaminers();

    Examiner searchExaminerByID(String examinerID);

}
