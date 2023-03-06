/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examiner.domain;

import java.io.Serializable;
import java.util.Collection;
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
@Table
public class Convenor implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "convener_ID")
    private Long convenorID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "examiner_committees")
    @OneToMany(mappedBy = "convenor")
    @Value("${null}")
    private Collection<Committee> examinerCommittees;

    @JoinColumn(name = "convener_user")
    @OneToOne(mappedBy = "convenor")
    private User user;

    public Convenor(Long convenorID, String firstName, String lastName, Collection<Committee> examinerCommittees, User user) {
        this.convenorID = convenorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.examinerCommittees = examinerCommittees;
        this.user = user;
    }

    public Convenor() {
    }

    @Override
    public String toString() {
        return "Convenor{" + "convenorID=" + convenorID + ", firstName=" + firstName + ", lastName=" + lastName + ", examinerCommittees=" + examinerCommittees + ", user=" + user + '}';
    }

    public Long getConvenorID() {
        return convenorID;
    }

    public void setConvenorID(Long convenorID) {
        this.convenorID = convenorID;
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

    public Collection<Committee> getExaminerCommittees() {
        return examinerCommittees;
    }

    public void setExaminerCommittees(Collection<Committee> examinerCommittees) {
        this.examinerCommittees = examinerCommittees;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
