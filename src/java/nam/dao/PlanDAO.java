
package nam.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import nam.dto.Plant;
import nam.dto.PlantDes;
import nam.utils.DBUtils;

public class PlanDAO {
    
    public static ArrayList<Plant> getAllPlants(){
        ArrayList<Plant> pList = new ArrayList<>();
        Connection cn = null;
        try{
            cn = DBUtils.makeConnection();
            if(cn!= null){
                String sql = "select PID,PName,price,imgPath,description,status,p.CateID,c.CateName from Plants p \n" +
"left join Categories c on p.CateID = c.CateID where p.isDeleted = 0";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    int id = rs.getInt(1);
                    String PName = rs.getString(2);
                    int price = rs.getInt(3);
                    String imgPath = rs.getString(4);
                    String description = rs.getString(5);
                    int status = rs.getInt(6);
                    int CateID = rs.getInt(7); 
                    String cateName = rs.getString(8);
                    Plant p = new Plant(id, PName, price, imgPath, description, status, CateID,cateName);
                    pList.add(p);
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
        return pList;
    }
    
    public static ArrayList<Plant> getPlants(String keyWord){
        ArrayList<Plant> pList = new ArrayList<>();
        Connection cn = null;
        try{
            cn = DBUtils.makeConnection();
            if(cn!= null){
                String sql = "select PID,PName,price,imgPath,description,status,p.CateID,c.CateName from Plants p \n" +
"left join Categories c on p.CateID = c.CateID where PName like ? OR p.PName like ?"; 
                
                sql+=" and p.isDeleted = 0";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, keyWord+"%");
                pst.setString(2,"% "+ keyWord+"%");
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    int id = rs.getInt(1);
                    String PName = rs.getString(2);
                    int price = rs.getInt(3);
                    String imgPath = rs.getString(4);
                    String description = rs.getString(5);
                    int status = rs.getInt(6);
                    int CateID = rs.getInt(7);  
                    String cateName = rs.getString(8);
                    Plant p = new Plant(id, PName, price, imgPath, description, status, CateID,cateName);
                    pList.add(p);
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
        return pList;
    }
    
    public static ArrayList<Plant> getPlantByCate(String cid){
        ArrayList<Plant> pList = new ArrayList<>();
        Connection cn = null;
        try{
            cn = DBUtils.makeConnection();
            if(cn!= null){
                String sql = "select PID,PName,price,imgPath,description,status,p.CateID,c.CateName from Plants p \n" +
"left join Categories c on p.CateID = c.CateID where p.CateID = ?"; 
                sql+=" and p.isDeleted = 0";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, Integer.parseInt(cid));
                ResultSet rs = pst.executeQuery();
                while(rs.next()){
                    int id = rs.getInt(1);
                    String PName = rs.getString(2);
                    int price = rs.getInt(3);
                    String imgPath = rs.getString(4);
                    String description = rs.getString(5);
                    int status = rs.getInt(6);
                    int CateID = rs.getInt(7);  
                    String cateName = rs.getString(8);
                    Plant p = new Plant(id, PName, price, imgPath, description, status, CateID,cateName);
                    pList.add(p);
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
        return pList;
    }
    
    public static Plant getPlant(int pid){
        Plant p = null;
        Connection cn = null;
        try{
            cn = DBUtils.makeConnection();
            if(cn!= null){
                String sql = "select PID,PName,price,imgPath,description,status,p.CateID,c.CateName from Plants p \n" +
"left join Categories c on p.CateID = c.CateID where p.isDeleted = 0 and  p.PID = ?";
                sql+=" and p.isDeleted = 0";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, pid);
                ResultSet rs = pst.executeQuery();
                if(rs!=null&&rs.next()){
                    int id = rs.getInt(1);
                    String PName = rs.getString(2);
                    int price = rs.getInt(3);
                    String imgPath = rs.getString(4);
                    String description = rs.getString(5);
                    int status = rs.getInt(6);
                    int CateID = rs.getInt(7);  
                    String cateName = rs.getString(8);
                    p = new Plant(id, PName, price, imgPath, description, status, CateID,cateName);
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
        return p;
    }

    public static int getAmountSold(int pid,int... status){
        int result = 0;
        Plant p = null;
        Connection cn = null;
        try{
            cn = DBUtils.makeConnection();
            if(cn!= null){
                String sql = "select sum(quantity) from ( select * from Orders where status = ";
                for (int i = 0; i < status.length; i++) {
                    if(i>0) sql+=" or status = ";
                    sql+=" " +status[i]+ " ";
                }
                sql += " ) o  join OrderDetails d on o.OrderID = d.OrderID group by d.FID having d.FID = ?";

                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, pid);
                ResultSet rs = pst.executeQuery();
                if(rs!=null&&rs.next()){
                    result = rs.getInt(1);
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
    
    public static ArrayList<PlantDes> getAllPlantsDes(){
        ArrayList<PlantDes> pList = new ArrayList<>();
        Connection cn = null;
        try{
            cn = DBUtils.makeConnection();
            if(cn!= null){
                String sql = "select PID,PName,price,imgPath,description,status,p.CateID,c.CateName from Plants p \n" +
"left join Categories c on p.CateID = c.CateID where p.isDeleted = 0";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    int id = rs.getInt(1);
                    String PName = rs.getString(2);
                    int price = rs.getInt(3);
                    String imgPath = rs.getString(4);
                    String description = rs.getString(5);
                    int status = rs.getInt(6);
                    int CateID = rs.getInt(7); 
                    String cateName = rs.getString(8);
                    int processing = getAmountSold(id,1);
                    int completed = getAmountSold(id,2);
                    int canceled = getAmountSold(id,3);
                    PlantDes p = new PlantDes(id, PName, price, imgPath, description, status, CateID,cateName,processing,completed,canceled);
                    pList.add(p);
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
        return pList;
    }
    
    public static ArrayList<PlantDes> getPlants(int id,String keyWord,int s,int c){
        ArrayList<PlantDes> pList = new ArrayList<>();
        Connection cn = null;
        try{
            cn = DBUtils.makeConnection();
            if(cn!=null){
            String sql = "select * from Plants p left join Categories c on p.CateID = c.CateID where p.isDeleted = 0 and";
                boolean hasquery = false;
                if(id!=-1) { sql = sql + " p.PID = "+id;hasquery=true;}
                if(keyWord!=null&&!keyWord.equals("")){ 
                    if(hasquery) sql+=" and "; else hasquery = true;
                    sql =sql+ " p.PName like '%"+keyWord+"%'";
                }
                if(s!=-1) {
                    if(hasquery) sql+=" and "; else hasquery = true;
                    sql += " p.status = "+s;
                }
                if(c!=-1) {
                    
                    if(hasquery) sql+=" and "; else hasquery = true;
                    sql += " p.CateID = "+ c;
                }
//                sql+=" order by OrdDate, status";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs!=null&&rs.next()){
                    int pID = rs.getInt(1);
                    String PName = rs.getString(2);
                    int price = rs.getInt(3);
                    String imgPath = rs.getString(4);
                    String description = rs.getString(5);
                    int status = rs.getInt(6);
                    int CateID = rs.getInt(7); 
                    String cateName = rs.getString(10);
                    int processing = getAmountSold(pID,1);
                    int completed = getAmountSold(pID,2);
                    int canceled = getAmountSold(pID,3);
                    PlantDes o = new PlantDes(pID, PName, price, imgPath, description, status, CateID, cateName, processing, completed, canceled);
                    pList.add(o);
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
        return pList;
    }
    
    public static boolean insertPlant(String name, int price, String path, String des, int status, int cateID){
        boolean result = false;
        Connection cn = null;
        try{
            cn = DBUtils.makeConnection();
            if(cn!= null){
                String sql = "insert into Plants values(?,?,?,?,?,?,0)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, name);
                pst.setInt(2, price);
                pst.setString(3, path);
                pst.setString(4, des);
                pst.setInt(5,status);
                pst.setInt(6, cateID);
                pst.executeUpdate();
                result = true;
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

    public static boolean updatePlant(int id,String name, int price, String path, String des, int status, int cateID){
        boolean result = false;
        Connection cn = null;
        try{
            cn = DBUtils.makeConnection();
            if(cn!= null){
                String sql = "update Plants set PName=?, price=?, imgPath=?, description=?, status=?, CateID=? where PID=? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, name);
                pst.setInt(2, price);
                pst.setString(3, path);
                pst.setString(4, des);
                pst.setInt(5,status);
                pst.setInt(6, cateID);
                pst.setInt(7, id);
                pst.executeUpdate();
                result = true;
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
    
    public static boolean removePlant(int pid){
        Connection cn = null;
        try{
            cn = DBUtils.makeConnection();
            if(cn!= null){
                String sql = "update Plants set isDeleted = 1 where PID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, pid);
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
        PlanDAO p = new PlanDAO();
        ArrayList<Plant> pl = PlanDAO.getPlantByCate("2");
        for (Plant p1 : pl) {
            System.out.println(p1);
        }
//        PlanDAO.updatePlant(16, "name", 0,".../img3.jpg","", 1, 1);
//        PlanDAO.insertPlant("name", 10,"path","des", 1, 1);
    }
    
}
