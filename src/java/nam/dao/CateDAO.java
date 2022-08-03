/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import nam.dto.CateDes;
import nam.dto.Category;

import nam.utils.DBUtils;

public class CateDAO {
    
    public static ArrayList<Category> getAllCategories(){
        ArrayList<Category> list = new ArrayList<>();
        Connection cn  = null;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "select * from Categories";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs!=null&&rs.next()){
                    int ID = rs.getInt(1);
                    String name = rs.getString(2);
                    Category o = new Category(ID, name);
                    list.add(o);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                cn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }
    
    public static ArrayList<CateDes> getAllCateDes(){
        ArrayList<CateDes> list = new ArrayList<>();
        Connection cn  = null;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "SELECT C.CateID,CateName,COUNT(PID) AS NOP FROM Categories c LEFT JOIN Plants p \n" +
"ON c.CateID = p.CateID GROUP BY C.CateID,CateName";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs!=null&&rs.next()){
                    int ID = rs.getInt(1);
                    String name = rs.getString(2);
                    int NOP = rs.getInt(3);
                    CateDes o = new CateDes(ID, name,NOP);
                    list.add(o);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                cn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return list;
    }
    
    public static boolean createCategory(String name){
        Connection cn  = null;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "INSERT INTO Categories VALUES(?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, name);
                pst.executeUpdate();
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                cn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
    
    public static String getCategoryName(int id){
        Connection cn  = null;
        String result = "";
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "select * from Categories where CateID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                if(rs!=null&&rs.next()){
                    result = rs.getString(2);
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                cn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return result;
    }

    public static boolean updateCategory(int id,String name){
        Connection cn  = null;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "UPDATE Categories SET CateName = ? WHERE CateID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(2, id);
                pst.setString(1, name);
                pst.executeUpdate();
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                cn.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        for (Category c : CateDAO.getAllCategories()) {
            System.out.println(c);
        }

    }
}
