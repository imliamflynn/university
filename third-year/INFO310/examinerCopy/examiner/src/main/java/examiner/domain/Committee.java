/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examiner.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author thirzasmith
 */
@Entity
@Table(name = "EXAMINERS_COMMITTEES")
public class Committee implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "committee_ID")
    private Long committeeID;

    @Column(name = "date_submitted")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Value("${null}")
    private LocalDate dateSubmit;

    @Column(name = "examiners")
    @OneToMany
    @Value("${null}")
    private List<Examiner> examiners;

    @ManyToOne
    @Value("${null}")
    private Convenor convenor;

//    @OneToOne(mappedBy = "committee")
    @OneToOne
    @Value("${null}")
    private Student student;

    public Committee(Long committeeID, LocalDate dateSubmit, List<Examiner> examiners, Convenor convenor, Student student) {
        this.committeeID = committeeID;
        this.dateSubmit = dateSubmit;
        this.examiners = examiners;
        this.convenor = convenor;
        this.student = student;
    }

    public Committee() {
    }

    @Override
    public String toString() {
        return "Committee{" + "committeeID=" + committeeID + ", dateSubmit=" + dateSubmit + ", examiners=" + examiners + ", convenor=" + convenor + ", student=" + student + '}';
    }

    public Long getCommitteeID() {
        return committeeID;
    }

    public void setCommitteeID(Long committeeID) {
        this.committeeID = committeeID;
    }

    public LocalDate getDateSubmit() {
        return dateSubmit;
    }

    public void setDateSubmit(LocalDate dateSubmit) {
        this.dateSubmit = dateSubmit;
    }

    public List<Examiner> getExaminers() {
        return examiners;
    }

    public void setExaminers(List<Examiner> examiners) {
        this.examiners = examiners;
    }

    public Convenor getConvenor() {
        return convenor;
    }

    public void setConvenor(Convenor convenor) {
        this.convenor = convenor;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
