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
public class MenuDAO {
    public static MenuDAO instance ;
    public static MenuDAO instance(){
        if(instance == null){
            instance = new MenuDAO();
        }
        return instance;
    }
    
    public MenuDAO(){
        
    };
    
    public JTable getListBillInFoBillID(int idBill){
        String query = "SELECT Food.name 'Tên Món', Food.price 'Giá', BillInfo.count 'Số lượng', Food.price * BillInfo.count 'Tổng tiền'  " +
                        "FROM  BillInfo, Food , Bill " +
                        "WHERE Food.id = BillInfo.idFood AND Bill.id = BillInfo.idBill  AND Bill.status = 0 AND BillInFo.idBill = " + idBill;
        
        JTable table = DataProvider.instance().ExecuteQuery(query);
        return table;
    }
}
