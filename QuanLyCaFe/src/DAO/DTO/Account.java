/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.DTO;

/**
 *
 * @author Lê H
 */
public class Account {
    private String userName;
    private String displayName ;
    private String passWord;
    private int type;

    public String getUserName() {
        return userName;
    }

    public Account(String userName, String displayName, String passWord, int type) {
        this.userName = userName;
        this.displayName = displayName;
        this.passWord = passWord;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Account{" + "userName=" + userName + ", displayName=" + displayName + ", passWord=" + passWord + ", type=" + type + '}';
    }
    
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
}
