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
public class AccountDAO {
    
    public static AccountDAO instance;
    
    public static AccountDAO instance(){
        if(instance == null)
            instance = new AccountDAO();
        return instance;
    }

    public AccountDAO() {
    }
    
    public JTable Login(String user, String password){
        String query = "EXEC SP_LOGIN ?, ?";
        
        JTable table = DataProvider.instance().ExecuteQuery(query, user, password);
        
        return table;
    }
    
    public JTable getListAccount(){
        String query = "EXEC SP_LISTACCOUNT";
        return DataProvider.instance().ExecuteQuery(query);
    }
    
}
