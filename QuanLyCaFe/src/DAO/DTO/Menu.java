/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.DTO;

/**
 *
 * @author Lê H
 */
public class Menu {
    private String NameFood ;
    private int soLuong;
    private float donGia;
    private float totalGia = 0;

    public Menu(String NameFood, int soLuong, float donGia) {
        this.NameFood = NameFood;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.totalGia = this.soLuong * this.donGia;
    }

    
    
    public String getNameFood() {
        return NameFood;
    }

    public void setNameFood(String NameFood) {
        this.NameFood = NameFood;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getTotalGia() {
        return totalGia;
    }

    public void setTotalGia(float totalGia) {
        this.totalGia = totalGia;
    }
    
    
}
