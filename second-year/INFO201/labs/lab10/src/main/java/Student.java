
import java.util.Collection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liamflynn
 */
public class Student {

    private Integer studentID;
    private String familyName;
    private String givenName;
    private String phone;
    private String schoolEmail;
    private String homeEmail;
    private String secondaryInstruments;
    
    private Collection<ClassEnrolment> classes;

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }

    public String getHomeEmail() {
        return homeEmail;
    }

    public void setHomeEmail(String homeEmail) {
        this.homeEmail = homeEmail;
    }

    public String getSecondaryInstruments() {
        return secondaryInstruments;
    }

    public void setSecondaryInstruments(String secondaryInstruments) {
        this.secondaryInstruments = secondaryInstruments;
    }

    public <any> getClasses() {
        return classes;
    }

    public void setClasses(<any> classes) {
        this.classes = classes;
    }

}
