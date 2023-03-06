/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author liamflynn
 */
public class DegreeEnrolment {
    
    private String degreeName;
    private Integer year;
    private String enrolmentStatus;
    private boolean feesPaid;
    
    private Student student;

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getEnrolmentStatus() {
        return enrolmentStatus;
    }

    public void setEnrolmentStatus(String enrolmentStatus) {
        this.enrolmentStatus = enrolmentStatus;
    }

    public boolean isFeesPaid() {
        return feesPaid;
    }

    public void setFeesPaid(boolean feesPaid) {
        this.feesPaid = feesPaid;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
}
