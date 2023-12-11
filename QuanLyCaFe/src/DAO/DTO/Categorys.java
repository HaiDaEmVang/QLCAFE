/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.DTO;

import java.net.IDN;
import javax.swing.JTable;

/**
 *
 * @author Lê H
 */
public class Categorys {
    private int ID;
    private String NameCategory;

    public Categorys(int ID, String NameCategory) {
        this.ID = ID;
        this.NameCategory = NameCategory;
    }

    @Override
    public String toString() {
        return "Categorys{" + "ID=" + ID + ", NameCategory=" + NameCategory + '}';
    }
    
    
    public Categorys() {
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNameCategory() {
        return NameCategory;
    }

    public void setNameCategory(String NameCategory) {
        this.NameCategory = NameCategory;
    }
    
    
    
}
