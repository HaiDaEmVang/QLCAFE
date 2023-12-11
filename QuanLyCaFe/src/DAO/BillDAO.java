/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.DTO.Bill;
import javax.swing.JTable;

/**
 *
 * @author Lê H
 */
public class BillDAO {
    public static BillDAO instance;
    
    public static BillDAO instance(){
        if(instance == null)
            instance = new BillDAO();
        return instance;
    }
    public BillDAO(){};
    
    public int GetUncheckBillIDByTableID(int id){
        String query = "SELECT id FROM Bill WHERE IdTable = "+ id + "  AND status = 0";
        
        JTable table = DataProvider.instance().ExecuteQuery(query);
        if(table.getRowCount() > 0){
            Object valueAt = table.getValueAt(0, 0);
            return (int)valueAt;
        }
        return -1;
    }
    public boolean insertNewBillByIDTable(int idTable){
        String query = "SP_INSERTBILL ? ";
        
        int value = DataProvider.instance().ExecuteNonQuery(query, idTable);
        
        return value > 0;
    }
    public int getIDMaxBill(){
        String query = "SELECT MAX(ID) FROM Bill";
        
        return (int) DataProvider.instance().ExecuteScalar(query);
    }
    
}
