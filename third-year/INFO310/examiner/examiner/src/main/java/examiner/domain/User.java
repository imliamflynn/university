/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examiner.domain;

import com.sun.istack.NotNull;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author thirzasmith
 */

@Entity
@Table (name = "USERS")
public class User implements Serializable{ //

    @Id
    @GeneratedValue
    @Column(name = "user_ID")
    private Long userID;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;
    
    @NotNull
    @Column(name = "email")
    private String email;

//    @OneToOne
//    @JoinColumn(name = "student")
//    private Student student;
//
//    @JoinColumn(name = "convener")
//    @OneToOne
//    private Convenor convenor;
//    public User(Long userID, String username, String password, Student student) {
//        this.userID = userID;
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.student = student;
//    }
//
//    public User(Long userID, String username, String password, Convenor convenor) {
//        this.userID = userID;
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.convenor = convenor;
//    }

    public User() {}

    public User(Long userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
