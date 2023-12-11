/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysinhvien.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;


public class TinhThanh {
    protected int maTinh;
    protected String TenTinh;
    protected Scanner sc = new Scanner(System.in);
    
    public TinhThanh(int maTinh, String TenTinh) {
        this.maTinh = maTinh;
        this.TenTinh = TenTinh;
    }
    
    public TinhThanh() {
    }
    
    public void nhap(){
        System.out.println("Nhap vao ma tinh: ");
        this.setMaTinh(sc.nextInt());
        this.setTenTinh(sc.nextLine());
    }
    public String xuat(){
        return this.maTinh + "," + this.TenTinh;
    }
        
    public int getMaTinh() {
        return maTinh;
    }

    public void setMaTinh(int maTinh) {
        this.maTinh = maTinh;
    }

    public String getTenTinh() {
        return TenTinh;
    }

    public void setTenTinh(String TenTinh) {
        this.TenTinh = TenTinh;
    }
    public static ArrayList<TinhThanh> getTinh(){
        ArrayList<TinhThanh> al_tinh = new ArrayList<>();
        String[] arr_tinh = {"An Giang",
                            "Bà Rịa-Vũng Tàu",
                            "Bắc Giang",
                            "Bắc Kạn",
                            "Bạc Liêu",
                            "Bắc Ninh",
                            "Bến Tre",
                            "Bình Định",
                            "Bình Dương",
                            "Bình Phước",
                            "Bình Thuận",
                            "Cà Mau",
                            "Cần Thơ",
                            "Cao Bằng",
                            "Đà Nẵng",
                            "Đắk Lắk",
                            "Đắk Nông",
                            "Điện Biên",
                            "Đồng Nai",
                            "Đồng Tháp",
                            "Gia Lai",
                            "Hà Giang",
                            "Hà Nam",
                            "Hà Nội",
                            "Hà Tĩnh",
                            "Hải Dương",
                            "Hải Phòng",
                            "Hậu Giang",
                            "TP. Hồ Chí Minh",
                            "Hòa Bình",
                            "Hưng Yên",
                            "Khánh Hòa",
                            "Kiên Giang",
                            "Kon Tum",
                            "Lai Châu",
                            "Lâm Đồng",
                            "Lạng Sơn",
                            "Lào Cai",
                            "Long An",
                            "Nam Định",
                            "Nghệ An",
                            "Ninh Bình",
                            "Ninh Thuận",
                            "Phú Thọ",
                            "Phú Yên",
                            "Quảng Bình",
                            "Quảng Nam",
                            "Quảng Ngãi",
                            "Quảng Ninh",
                            "Quảng Trị",
                            "Sóc Trăng",
                            "Sơn La",
                            "Tây Ninh",
                            "Thái Bình",
                            "Thái Nguyên",
                            "Thanh Hóa",
                            "Thừa Thiên - Huế",
                            "Tiền Giang",
                            "Trà Vinh",
                            "Tuyên Quang",
                            "Vĩnh Long",
                            "Vĩnh Phúc",
                            "Yên Bái"
                            };
        for(int i = 0; i< arr_tinh.length; i++){
            TinhThanh k = new TinhThanh(i, arr_tinh[i]);
            al_tinh.add(k);
        }
        return al_tinh;
    }
}
