/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import javax.swing.JTable;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Lê H
 */
public class DataProvider {
    private Connection conn = null;
    
    public static DataProvider instance;
    
    public static DataProvider instance(){
        if(instance == null){
            instance = new DataProvider();
        }return instance;
    }
    
    
    private  DataProvider(){
        try {
            String url = "jdbc:sqlserver://LeHai\\HDV:1433;"
                    + "user=sa;password=123456;databaseName=QuanLyCaFe_Demo;"
                    + "encrypt=false";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            conn =  DriverManager.getConnection(url);

            System.out.println("Ket noi thanh cong");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }  
        
    }
    
    public JTable  ExecuteQuery(String query, Object...paramenters){
         
        JTable table = new JTable();
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            for(int i = 0; i< paramenters.length; i++){
                ps.setObject(i+1, paramenters[i]);
            }
            ResultSet rs = ps.executeQuery();
            
            ResultSetMetaData rsm = rs.getMetaData();
            int columns = rsm.getColumnCount();
            for(int i = 1; i<= columns; i++){
                tableModel.addColumn(rsm.getColumnName(i));
            }
            
            while(rs.next()){
                Vector<Object> rowValues = new Vector<>();
                for(int i = 1; i<= columns; i++){
                    rowValues.add(rs.getObject(i));
                }
                tableModel.addRow(rowValues);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return table;
    }
    
    public int ExecuteNonQuery(String query, Object...paramenters){
        JTable table = new JTable();
        int value = 0;
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            for(int i = 0; i< paramenters.length; i++){
                ps.setObject(i+1, paramenters[i]);
            }
             value = ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return value;
    }
    public Object ExecuteScalar(String query, Object...paramenters){
        JTable table = new JTable();
        Object value = 0;
        DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            for(int i = 0; i< paramenters.length; i++){
                ps.setObject(i + 1, paramenters[i]);
            }
            
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                value = rs.getObject(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return value;
    }
    
}
