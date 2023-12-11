/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysinhvien.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lê H
 */
public class thiSinh {
    private String maThiSinh;
    private String tenThiSinh;
    private TinhThanh queQuan;
    private Date ngaySinh;
    private String GioiTinh;
    private float diem1, diem2, diem3;

    public thiSinh(String maThiSinh, String tenThiSinh, TinhThanh queQuan, Date ngaySinh, String GioiTinh, float diem1, float diem2, float diem3) {
        this.maThiSinh = maThiSinh;
        this.tenThiSinh = tenThiSinh;
        this.queQuan = queQuan;
        this.ngaySinh = ngaySinh;
        this.GioiTinh = GioiTinh;
        this.diem1 = diem1;
        this.diem2 = diem2;
        this.diem3 = diem3;
    }

    public thiSinh() {
    }
    
    
    public thiSinh(String maThiSinh, String tenThiSinh, String queQuan,String ngaysinh, String GioiTinh, String diem1, String diem2, String diem3) {
        this.setMaThiSinh(maThiSinh);
        this.setTenThiSinh(tenThiSinh);
        this.setQueQuan(queQuan);
        this.setNgaySinh(ngaysinh);
        this.setGioiTinh(GioiTinh);
        this.setDiem1(diem1);
        this.setDiem2(diem2);
        this.setDiem3(diem3);
    }

    @Override
    public String toString() {
        SimpleDateFormat p = new SimpleDateFormat("dd/MM/yyyy");
        return "thiSinh{" + "maThiSinh=" + maThiSinh + ", tenThiSinh=" + tenThiSinh + ", queQuan=" + queQuan.getTenTinh() +"ngaySinh=" +p.format(ngaySinh)+ "GioiTinh=" + ((this.GioiTinh.equals("F"))?"Nam":"NU") + ", diem1=" + diem1 + ", diem2=" + diem2 + ", diem3=" + diem3 + '}';
    }
    public String xuatFile(){
        SimpleDateFormat p = new SimpleDateFormat("dd/MM/yyyy");
        return this.maThiSinh+ ","+
                this.tenThiSinh+ ","+
                this.queQuan.getTenTinh()+ ","+
                p.format(this.ngaySinh)+ ","+
                this.GioiTinh+ ","+
                this.diem1+ ","+
                this.diem2+ ","+
                this.diem3;            
    }
    
    public void setNgaySinh(String ns){
        String[] format = {"yyyy-MM-dd", "dd/mm/yyyy"};
        for(int i = 0; i< 2; i++){
            SimpleDateFormat p = new SimpleDateFormat(format[i]);
            try {
                this.ngaySinh = p.parse(ns);
            } catch (ParseException ex) {
            }
        }
        
        
    }
    public void setNgaySinh(Date ns){
        this.ngaySinh = ns;
    }
    public Date getNgaySinh(){
        return this.ngaySinh;
    }
    public String getMaThiSinh() {
        return maThiSinh;
    }
//    public String getNgaySinh(){
//        SimpleDateFormat p = new SimpleDateFormat("dd/MM/yyyy");
//        return p.format(this.ngaySinh);
//    }
    
    public void setMaThiSinh(String maThiSinh) {
        this.maThiSinh = maThiSinh;
    }

    public String getTenThiSinh() {
        return tenThiSinh;
    }

    public void setTenThiSinh(String tenThiSinh) {
        this.tenThiSinh = tenThiSinh;
    }

    public TinhThanh getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        ArrayList<TinhThanh> arr_tinh = TinhThanh.getTinh();
        for(int i = 0; i< arr_tinh.size(); i++){
            if(arr_tinh.get(i).getTenTinh().equals(queQuan)){
                this.queQuan = arr_tinh.get(i);
                break;
            }
        }
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public float getDiem1() {
        return diem1;
    }

    public void setDiem1(String diem1) {
        this.diem1 = Float.parseFloat(diem1);
    }
    public void setDiem1(float diem1){
        this.diem1 = diem1;
    }
    public float getDiem2() {
        return diem2;
    }

    public void setDiem2(String diem2) {
        this.diem2 = Float.parseFloat(diem2);
    }
    public void setDiem2(float diem2){
        this.diem2 = diem2;
    }

    public float getDiem3() {
        return diem3;
    }

    public void setDiem3(String diem3) {
        this.diem3 = Float.parseFloat(diem3);
    }

    public void setDiem3(float diem3){
        this.diem3 = diem3;
    }
    public boolean compareTS(thiSinh ts){
        if(!this.maThiSinh.equals(ts.getMaThiSinh())
                ||!this.tenThiSinh.equals(ts.getTenThiSinh())
//                ||!this.ngaySinh.equals(ts.getNgaySinh())
                ||!this.queQuan.getTenTinh().equals(ts.getQueQuan().getTenTinh())
                ||this.getDiem1()!= ts.getDiem1()
                ||this.getDiem2()!= ts.getDiem2()
                ||this.getDiem3()!= ts.getDiem3())
            return true;
        return false;
    }

    

}
