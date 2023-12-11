/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.DTO.Food;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Lê H
 */
public class FoodDAO {
    public static FoodDAO instance;
    
    public static FoodDAO instance(){
        if(instance == null){
            instance  = new FoodDAO();
        }
        return instance;
    }
    public FoodDAO(){};
    
    public JTable getListFoodAndCategory(){
        String query = "EXEC SP_LISTFOODANDCATEGORY";
        return DataProvider.instance().ExecuteQuery(query);
    }
    
    public boolean insertFood(Food foodNew){
        String query = "EXEC SP_INS_FOOD ? , ? , ?";
        
        return DataProvider.instance().ExecuteNonQuery(query, foodNew.getNameFood(), foodNew.getIdCategory(), foodNew.getPrice()) > 0;
    }
    
    public boolean updateFood(Food foodNew){
        String query = "SP_UP_FOOD ? , ? , ? , ? ";
        return DataProvider.instance().ExecuteNonQuery(query, foodNew.getId(), foodNew.getNameFood(), foodNew.getIdCategory(), foodNew.getPrice()) > 0;
    }
    
    public boolean deleteFood(Food foodRemove){
        String query = "SP_DEL_FOOD ?";
        return DataProvider.instance().ExecuteNonQuery(query, foodRemove.getId())>0;
    }
    public ArrayList<Food> getListFood(){
        String query = "EXEC SP_LISTFOOD";
        JTable table =  DataProvider.instance().ExecuteQuery(query);
        
        int rowCount = table.getRowCount();
        ArrayList<Food> listFoodByCategory = new ArrayList<>();
        for(int i = 0; i < rowCount; i++){
            Food food = new Food((int)table.getValueAt(i, 0), 
                    (String)table.getValueAt(i, 1), 
                    (int)table.getValueAt(i, 2), 
                    (float) (double)table.getValueAt(i, 3));
            listFoodByCategory.add(food);
        }
        return listFoodByCategory;
    }
    public ArrayList<Food> getListFoodByCategoryID(int idCategory){
        String query = "SELECT Food.* FROM Food, FoodCategory WHERE Food.idCategory = FoodCategory.id AND Food.idCategory = " + idCategory;
        
        JTable table = DataProvider.instance().ExecuteQuery(query);
        
        int rowCount = table.getRowCount();
        ArrayList<Food> listFoodByCategory = new ArrayList<>();
        for(int i = 0; i < rowCount; i++){
            Food food = new Food((int)table.getValueAt(i, 0), 
                    (String)table.getValueAt(i, 1), 
                    (int)table.getValueAt(i, 2), 
                    (float) (double)table.getValueAt(i, 3));
            listFoodByCategory.add(food);
        }
        return listFoodByCategory;
    }
}
