/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

/**
 *
 * @author thirzasmith
 */
public class User {

    private String userID;
    private String username;
    private String password;

    public User(String userID, String username, String password) {
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "userID=" + userID + ", username=" + username + ", password=" + password + '}';
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
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

}
