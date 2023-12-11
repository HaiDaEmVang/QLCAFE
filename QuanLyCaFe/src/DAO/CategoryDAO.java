/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import DAO.DTO.Categorys;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JTable;

/**
 *
 * @author Lê H
 */
public class CategoryDAO {
    public static CategoryDAO instence ;
    public static CategoryDAO instence(){
        if(instence == null)
            instence = new CategoryDAO();
        return instence;
    }
    public CategoryDAO(){
        
    };
    public JTable getListFoodCategory(){
        String query = "EXEC SP_LISTFOODCATEGORY";
        return DataProvider.instance().ExecuteQuery(query);
    }
    
    public ArrayList<Categorys> getCategory(){
        ArrayList<Categorys> ListCategory = new ArrayList<>();
        String query = "SELECT * FROM FoodCategory";
        
        JTable table = DataProvider.instance().ExecuteQuery(query);
        
        int rowCount = table.getRowCount();
        for(int i = rowCount - 1; i>= 0; i--){
            Categorys category = new Categorys(i+1,(String)table.getValueAt(i, 1));
            ListCategory.add(category);
        }
        return ListCategory;
    } 
}
