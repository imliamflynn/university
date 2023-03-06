/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examiner.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author thirzasmith
 */
@Entity
@Table(name = "STUDENTS")
public class Student implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "student_ID")
    private Long studentID;

    @Column(name = "first_name")
    @Value("${null}")
    private String firstName;

    @Column(name = "last_name")
    @Value("${null}")
    private String lastName;

    @Column(name = "email")
    @Value("${null}")
    private String email;

    @Column(name = "student_topic")
    @Value("${null}")
    private String topic;

    @Column(name = "blacklist")
    @OneToMany
    @Value("${null}")
    private List<Examiner> blacklist;

    @JoinColumn(name = "student_user")
    @OneToOne(mappedBy = "student")
    @Value("${null}")
    private User user;

//    @JoinColumn(name = "committee")
//    @OneToOne
    @OneToOne
    private Committee committee;

    public Student(Long studentID, String firstName, String lastName, String email, String topic, List<Examiner> blacklist, User user, Committee committee) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.topic = topic;
        this.blacklist = blacklist;
        this.user = user;
        this.committee = committee;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" + "studentID=" + studentID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", topic=" + topic + ", blacklist=" + blacklist + ", user=" + user + ", committee=" + committee + '}';
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
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

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public List<Examiner> getBlacklist() {
        return blacklist;
    }

    public void setBlacklist(List<Examiner> blacklist) {
        this.blacklist = blacklist;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Committee getCommittee() {
        return committee;
    }

    public void setCommittee(Committee committee) {
        this.committee = committee;
    }

}
