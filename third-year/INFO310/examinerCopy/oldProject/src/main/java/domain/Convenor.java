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
public class Convenor {

    private String convenorID;
    private String firstName;
    private String lastName;
    private Collection<Examiner> examinerCommittee;

    public Convenor(String convenorID, String firstName, String lastName, Collection<Examiner> examinerCommittee) {
        this.convenorID = convenorID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.examinerCommittee = examinerCommittee;
    }

    @Override
    public String toString() {
        return "Convenor{" + "convenorID=" + convenorID + ", firstName=" + firstName + ", lastName=" + lastName + ", examinerCommittee=" + examinerCommittee + '}';
    }

    public String getConvenorID() {
        return convenorID;
    }

    public void setConvenorID(String convenorID) {
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

    public Collection<Examiner> getExaminerCommittee() {
        return examinerCommittee;
    }

    public void setExaminerCommittee(Collection<Examiner> examinerCommittee) {
        this.examinerCommittee = examinerCommittee;
    }

}
