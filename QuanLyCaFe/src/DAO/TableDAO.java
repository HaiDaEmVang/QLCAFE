/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DAO.DTO.Table;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author Lê H
 */
public class TableDAO {
    public static TableDAO instance;
    
    public static TableDAO instance(){
        if(instance == null)
            instance = new TableDAO();
        return instance;
    }
    public TableDAO(){
    }
    public JTable getListTable(){
        
        String query = "EXEC SP_DSTABLE";
        
        return DataProvider.instance().ExecuteQuery(query);
    }
    
    public ArrayList<Table> getAllListTable(){
        ArrayList<Table> table = new ArrayList<>();
        
        String query = "EXEC SP_DSTABLE";
        
        JTable tabletmp = new JTable();
        tabletmp = DataProvider.instance().ExecuteQuery(query);
        
        int rowCount = tabletmp.getRowCount();
        
        for(int i = 0; i< rowCount; i++){
            Table tb = new Table((int)tabletmp.getValueAt(i, 0),(String) tabletmp.getValueAt(i, 1),(String) tabletmp.getValueAt(i, 2));
            table.add(tb);
        }
        return table;
    }
    public ArrayList<Table> getListTableStatus(){
        ArrayList<Table> table = new ArrayList<>();
        
        String query = "EXEC SP_DSTABLETRONG";
        
        JTable tabletmp = new JTable();
        tabletmp = DataProvider.instance().ExecuteQuery(query);
        
        int rowCount = tabletmp.getRowCount();
        
        for(int i = 0; i< rowCount; i++){
            Table tb = new Table((int)tabletmp.getValueAt(i, 0),(String) tabletmp.getValueAt(i, 1),(String) tabletmp.getValueAt(i, 2));
            table.add(tb);
        }
        return table;
    }
    public void updateStatusTableByIDTable(int idTable){
        String query = "EXEC SP_TOGLESTATUFOODTABLE  " + idTable;
        
        int value = DataProvider.instance().ExecuteNonQuery(query);
    }
}