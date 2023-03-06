/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import domain.Examiner;
import java.util.*;

/**
 *
 * @author Enrico
 */
public final class ExaminerCollectionDAO implements ExaminerDAO {

//    Collection of examiners of type Examiner
    private static Collection<Examiner> examiners = new HashSet<>();

//    Multimap of topics examiners can exam people on as the String
//    and the examiners of type Examiner with that topic as one of theirs
    private static Multimap<String, Examiner> topicMap = HashMultimap.create();

    /**
     * Gets all examiners with the topic we're looking for.
     *
     *
     * @param topic we want to find an examiner for.
     * @return Collection of examiners that can exam said topic.
     */
    @Override
    public Collection<Examiner> filterByTopic(String topic) {
        boolean doesExist = topicMap.containsKey(topic);
        if (doesExist) {
            return topicMap.get(topic);
        } else {
            return null;
        }
    }

    /**
     * Gets all topics to filter by and look for examiners through. Its for the
     * simple list model.
     *
     * @return Collection of topics to look for an examiner through.
     */
    @Override
    public Collection<String> getTopics() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Gets all examiners.
     *
     * @return Collection of all examiners.
     */
    @Override
    public Collection<Examiner> getExaminers() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * Gets a single examiner with the ID we want.
     *
     * @param examinerID of the examiner we want to find.
     * @return Examiner we are looking for.
     */
    @Override
    public Examiner searchExaminerByID(String examinerID) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
