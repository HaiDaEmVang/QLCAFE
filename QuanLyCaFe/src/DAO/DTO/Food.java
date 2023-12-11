/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO.DTO;

/**
 *
 * @author Lê H
 */
public class Food {
    private int id;
    private String NameFood ;
    private int idCategory;
    private Float price;

    public Food(int id, String NameFood, int idCategory, Float price) {
        this.id = id;
        this.NameFood = NameFood;
        this.idCategory = idCategory;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" + "id=" + id + ", NameFood=" + NameFood + ", idCategory=" + idCategory + ", price=" + price + '}';
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameFood() {
        return NameFood;
    }

    public void setNameFood(String NameFood) {
        this.NameFood = NameFood;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    
    
}
