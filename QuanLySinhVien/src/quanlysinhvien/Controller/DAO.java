/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysinhvien.Controller;


import java.sql.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlysinhvien.model.thiSinh;

/**
 *
 * @author Lê H
 */
public class DAO {
    private Connection conn;
    
    public DAO(){
       
        try {
            String url = "jdbc:sqlserver://LeHai\\HDV:1433;"
                    + "user=sa;password=123456;databaseName=QLSV_JAVA_0512;"
                    + "encrypt=false";

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            conn =  DriverManager.getConnection(url);

            System.out.println("Ket noi thanh cong");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }  
    }
    
    public boolean addStudent(thiSinh ts){
        
        String sql = "INSERT INTO THISINH(MATHISINH, TENTHISINH, TINHTHANH, NGAYSINH, GIOITINH, MATH, PHYSICAL, CHEMISTRY)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ps.setString(1, ts.getMaThiSinh());
            ps.setString(2, ts.getTenThiSinh());
            ps.setString(3, ts.getQueQuan().getTenTinh());
            ps.setDate(4, new Date(ts.getNgaySinh().getTime()));
            ps.setString(5, ts.getGioiTinh());
            ps.setFloat(6, ts.getDiem1());
            ps.setFloat(7, ts.getDiem2());
            ps.setFloat(8, ts.getDiem3());
            
            return ps.executeUpdate()> 0;
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public Hashtable<String, thiSinh> getStudent(){
        Hashtable<String, thiSinh> ds = new Hashtable<>();
        
        String sql = "select * from THISINH";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            ResultSetMetaData md = rs.getMetaData();
            
            while(rs.next()){
                thiSinh ts = new thiSinh();
                
                ts.setMaThiSinh(rs.getString("MATHISINH"));
                ts.setTenThiSinh(rs.getString("TENTHISINH"));
                ts.setQueQuan(rs.getString("TINHTHANH"));
                ts.setNgaySinh(rs.getDate("NGAYSINH").toString());
                ts.setGioiTinh(rs.getString("GIOITINH"));
                ts.setDiem1(rs.getFloat("MATH"));
                ts.setDiem2(rs.getFloat("PHYSICAL"));
                ts.setDiem3(rs.getFloat("CHEMISTRY"));
                ds.put(ts.getMaThiSinh(), ts);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ds;
    
    }
    
    public boolean removeStudent(thiSinh ts){
        
        try {
            String sql = "DELETE THISINH "
                    + "WHERE THISINH.MATHISINH ='" + ts.getMaThiSinh()+"'";
            
            PreparedStatement ps = conn.prepareStatement(sql);
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }return false;
    }
    
}
