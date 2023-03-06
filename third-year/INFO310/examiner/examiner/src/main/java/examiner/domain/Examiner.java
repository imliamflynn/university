/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examiner.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author thirzasmith
 */
@Entity
@Table(name = "EXAMINERS")
public class Examiner implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "examiner_ID")
    private Long examinerID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "location")
    private String location;

    @Column(name = "university")
    private String university;

    @Column(name = "department")
    private String department;

    @Column(name = "examiner_topic")
    private String topic;

    @JoinColumn(name = "committee")
    @ManyToOne
    @Value("${null}")
    private Committee committee;

    public Examiner(Long examinerID, String firstName, String lastName, String email, String location, String university, String department, String topic, Committee committee) {
        this.examinerID = examinerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.location = location;
        this.university = university;
        this.department = department;
        this.topic = topic;
        this.committee = committee;
    }

    public Examiner() {
    }

    @Override
    public String toString() {
        return "Examiner{" + "examinerID=" + examinerID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", location=" + location + ", university=" + university + ", department=" + department + ", topic=" + topic + ", committee=" + committee + '}';
    }

    public Long getExaminerID() {
        return examinerID;
    }

    public void setExaminerID(Long examinerID) {
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Committee getCommittee() {
        return committee;
    }

    public void setCommittee(Committee committee) {
        this.committee = committee;
    }

}
