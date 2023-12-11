/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.DTO;

import java.util.Date;
import javax.swing.JTable;

/**
 *
 * @author Lê H
 */
public class Bill {
    private int ID;
    private Date ngayCheckIn;
    private Date ngayCheckOut;
    private int IDTable;
    private int Status;

    public Bill(int ID, Date ngayCheckIn, Date ngayCheckOut, int IDTable, int Status) {
        this.ID = ID;
        this.ngayCheckIn = ngayCheckIn;
        this.ngayCheckOut = ngayCheckOut;
        this.IDTable = IDTable;
        this.Status = Status;
    }

    @Override
    public String toString() {
        return "Bill{" + "ID=" + ID + ", ngayCheckIn=" + ngayCheckIn + ", ngayCheckOut=" + ngayCheckOut + ", IDTable=" + IDTable + ", Status=" + Status + '}';
    }
    
    
    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Date getNgayCheckIn() {
        return ngayCheckIn;
    }

    public void setNgayCheckIn(Date ngayCheckIn) {
        this.ngayCheckIn = ngayCheckIn;
    }

    public Date getNgayCheckOut() {
        return ngayCheckOut;
    }

    public void setNgayCheckOut(Date ngayCheckOut) {
        this.ngayCheckOut = ngayCheckOut;
    }

    public int getIDTable() {
        return IDTable;
    }

    public void setIDTable(int IDTable) {
        this.IDTable = IDTable;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }
    
    
    
}
