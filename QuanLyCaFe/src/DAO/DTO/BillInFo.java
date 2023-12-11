/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.DTO;

/**
 *
 * @author Lê H
 */
public class BillInFo {
    private int id, idBill, idFood, count;

    public BillInFo(int id, int idBill, int idFood, int count) {
        this.id = id;
        this.idBill = idBill;
        this.idFood = idFood;
        this.count = count;
    }

    @Override
    public String toString() {
        return "BillInFo{" + "id=" + id + ", idBill=" + idBill + ", idFood=" + idFood + ", count=" + count + '}';
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public int getIdFood() {
        return idFood;
    }

    public void setIdFood(int idFood) {
        this.idFood = idFood;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    
    
}
