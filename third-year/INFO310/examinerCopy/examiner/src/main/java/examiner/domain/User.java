/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examiner.domain;

import java.io.Serializable;
import javax.persistence.*;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 * @author thirzasmith
 */
@Entity
@Table(name = "USERS")
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "user_ID")
    private Long userID;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne
    @JoinColumn(name = "student")
    @Value("${null}")
    private Student student;

    @JoinColumn(name = "convener")
    @OneToOne
    @Value("${null}")
    private Convenor convenor;

    public User(Long userID, String username, String password, Student student) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.student = student;
    }

    public User(Long userID, String username, String password, Convenor convenor) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.convenor = convenor;
    }

    public User(Long userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Convenor getConvenor() {
        return convenor;
    }

    public void setConvenor(Convenor convenor) {
        this.convenor = convenor;
    }

}
