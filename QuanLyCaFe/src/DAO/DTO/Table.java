/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.DTO;

/**
 *
 * @author Lê H
 */
public class Table {
    private int iD;
    private String name;
    private String status;

    public Table(int id, String name, String status){
        this.iD = id;
        this.name = name;
        this.status = status;
    }
    public static int tableWidth = 100;
    public static int tableHeight = 100;
    
    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String toString (){
        return this.iD + this.name + this.status;
    }
    
}
