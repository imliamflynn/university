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
public class Examiner {

    private String examinerID;
    private String firstName;
    private String lastName;
    private String email;
    private String location;
    private String university;
    private String department;
    private Collection<String> topics;
    private String userID;
    private String examinersCommitteeID;

    public Examiner(String examinerID, String firstName, String lastName, String email, String location, String university, String department, Collection<String> topics, String userID, String examinersCommitteeID) {
        this.examinerID = examinerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.location = location;
        this.university = university;
        this.department = department;
        this.topics = topics;
        this.userID = userID;
        this.examinersCommitteeID = examinersCommitteeID;
    }

    @Override
    public String toString() {
        return "Examiner{" + "examinerID=" + examinerID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", location=" + location + ", university=" + university + ", department=" + department + ", interests=" + topics + ", userID=" + userID + ", examinersCommitteeID=" + examinersCommitteeID + '}';
    }

    public String getExaminerID() {
        return examinerID;
    }

    public void setExaminerID(String examinerID) {
        this.examinerID = examinerID;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Collection<String> getTopics() {
        return topics;
    }

    public void setTopics(Collection<String> topics) {
        this.topics = topics;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getExaminersCommitteeID() {
        return examinersCommitteeID;
    }

    public void setExaminersCommitteeID(String examinersCommitteeID) {
        this.examinersCommitteeID = examinersCommitteeID;
    }

}
