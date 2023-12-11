/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import javax.swing.JTable;

/**
 *
 * @author Lê H
 */
public class BillInFoDAO {
    public static BillInFoDAO instance;
    
    public static BillInFoDAO instance(){
        if(instance == null){
            instance = new BillInFoDAO();
        }
        return instance;
    }
    public  BillInFoDAO(){
        
    };
    
    public int GetUncheckBillInFoIDByBillID(int idBill){
        String query = "SELECT id FROM BillInfo WHERE idBill = "+ idBill ;
        
        JTable table = DataProvider.instance().ExecuteQuery(query);
        if(table.getRowCount() > 0){
            Object valueAt = table.getValueAt(0, 0);
            return (int)valueAt;
        }
        return -1;
    }
    
    
    
    public boolean insertBillInFo(int idTable, int idFood, int count){
        String query = "SP_INSERTBILLINFO ? , ? , ?";
        
        int value = (int )DataProvider.instance().ExecuteNonQuery(query, idTable, idFood, count);
        
        return value >0;
    }
}
