/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author thirzasmith
 */
public class ExaminerCommittee {

    public String date;
    public String examinerID;
    public String studentID;

    public ExaminerCommittee(String date, String examinerID, String studentID) {
        this.date = date;
        this.examinerID = examinerID;
        this.studentID = studentID;
    }

    @Override
    public String toString() {
        return "ExaminerCommittee{" + "date=" + date + ", examinerID=" + examinerID + ", studentID=" + studentID + '}';
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExaminerID() {
        return examinerID;
    }

    public void setExaminerID(String examinerID) {
        this.examinerID = examinerID;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

}
