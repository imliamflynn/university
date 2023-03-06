/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import java.util.Collection;

/**
 *
 * @author thirzasmith
 */
public class Student {

    private String studentID;
    private String firstName;
    private String lastName;
    private String email;
    private Collection<String> topics;
    private Collection<Examiner> blacklist;
    private String userID;

    public Student(String studentID, String firstName, String lastName, String email, Collection<String> topics, Collection<Examiner> blacklist, String userID) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.topics = topics;
        this.blacklist = blacklist;
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", thesisTopics=" + topics + ", blacklist=" + blacklist + ", userID=" + userID + '}';
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<String> getTopics() {
        return topics;
    }

    public void setTopics(Collection<String> topics) {
        this.topics = topics;
    }

    public Collection<Examiner> getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(Collection<Examiner> blacklist) {
        this.blacklist = blacklist;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

}
