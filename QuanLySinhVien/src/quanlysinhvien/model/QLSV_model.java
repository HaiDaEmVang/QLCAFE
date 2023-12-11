/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlysinhvien.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import quanlysinhvien.Controller.DAO;

/**
 *
 * @author Lê H
 */
public class QLSV_model {
    private Hashtable<String, thiSinh> lists;

    public QLSV_model() {
        lists = new DAO().getStudent();
    }

    public QLSV_model(Hashtable<String, thiSinh> lists) {
        lists = new Hashtable<>();
        this.lists = lists;
    }
    public thiSinh findTS(String ts){
        if(this.lists.containsKey(ts))
            return this.lists.get(ts);
        else
            return null;
    }
    public void insertTS(thiSinh ts){
        lists.put(ts.getMaThiSinh(), ts);
    }
    
    public void deleteTS(thiSinh ts){
        lists.remove(ts.getMaThiSinh());
    }
    public void deleteTS(String mats){
        lists.remove(mats);
    }
    
    public void updateTS(thiSinh old, thiSinh newTs){
        lists.remove(old.getMaThiSinh());
        lists.put(newTs.getMaThiSinh(), newTs);
    }
    public Hashtable<String, thiSinh> findTT(String nameTinh){
        Hashtable<String, thiSinh> k = new Hashtable<>();
        lists.forEach((key, value)->{
            if(value.getQueQuan().getTenTinh().equals(nameTinh) )
                k.put(key, value);
        });
        return k;
    }
    

    public void readFileTs(String nameFile){
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new FileReader(nameFile));
            String tmp = null;
            while((tmp =bf.readLine()) != null){
                String[] items = tmp.split(",");
                this.lists.put(items[0], new thiSinh(items[0], items[1], items[2], items[3], items[4], items[5], items[6], items[7]));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Loi mo file QLSV_Model");
        } catch (IOException ex) {
            Logger.getLogger(QLSV_model.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                if(bf!= null)
                    bf.close();
            } catch (IOException ex) {
                System.out.println("Khong the xoa file");
            }
        }
        
    }
    public void writeFileTs(String nameFile){
        FileWriter p = null;
        try {
            p = new FileWriter(nameFile);
            for(String x: this.lists.keySet()){
                p.write((this.lists.get(x).xuatFile() + "\n"));
            }
        } catch (IOException ex) {
            System.out.println("Loi nhap file o QLSV_model");
        }finally{
            try {
                if(p!= null)
                    p.close();
            } catch (IOException ex) {
                System.out.println("Khong the xoa file");
            }
        }
    }
    
    public Hashtable<String, thiSinh> getLists() {
        return lists;
    }

    public void setLists(Hashtable<String, thiSinh> lists) {
        this.lists = lists;
    }
  
    public boolean addDAtabase(thiSinh ts){
        if(new DAO().addStudent(ts)){
            return true;
        }return false;
    }
    
    public boolean removeDatabase(thiSinh ts){
        if(new DAO().removeStudent(ts))
           return true;
        return false;
    }
}
