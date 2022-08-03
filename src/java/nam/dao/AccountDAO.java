
package nam.dao;

import java.sql.Connection;
import nam.dto.Account;
import nam.utils.DBUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class AccountDAO {
    
    public static ArrayList<Account> getAccounts() {
        ArrayList<Account> list = new ArrayList<>();
        Connection cn  = null;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "select * from Accounts where role = 0";
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    int accID = rs.getInt(1);
                    String email = rs.getString(2);
                    String password = rs.getString(3);
                    String fullName = rs.getString(4);
                    String phone = rs.getString(5);
                    int status = rs.getInt(6);
                    int role = rs.getInt(7);
                    list.add(new Account(accID, email, password, fullName, phone, status, role));
                }
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return list;
    }
    
    public static Account getAccounts(String email,String password){
        Account ac = null;
        Connection cn  = null;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "select * from Accounts where email = ? and password = ? COLLATE SQL_Latin1_General_CP1_CS_AS";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, password);
                ResultSet rs = pst.executeQuery();
                if (rs!=null&&rs.next()) {
                    int accID = rs.getInt(1);
                    String fullName = rs.getString(4);
                    int status = rs.getInt(6);
                    String phone = rs.getString(5);
                    int role = rs.getInt(7);
                    ac = new Account(accID, email, password, fullName, phone, status, role);
                }
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }finally{
            try {
                cn.close();
            } catch (SQLException ex) {
            }
        }
        return ac;
    }
    
    public static Account getAccounts(String email){
        Account ac = null;
        Connection cn  = null;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "select * from Accounts where email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs!=null&&rs.next()) {
                    int accID = rs.getInt(1);
                    String pass = rs.getString(3);
                    String fullName = rs.getString(4);
                    int status = rs.getInt(6);
                    String phone = rs.getString(5);
                    int role = rs.getInt(7);
                    ac = new Account(accID, email,pass ,fullName, phone, status, role);
                }
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }finally{
            try {
                cn.close();
            } catch (SQLException ex) {
            }
        }
        return ac;
    }

    public static Account getAccounts(int id){
        Account ac = null;
        Connection cn  = null;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "select * from Accounts where accID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                if (rs!=null&&rs.next()) {
                    int accID = rs.getInt(1);
                    String email = rs.getString(2);
                    String fullName = rs.getString(4);
                    int status = rs.getInt(6);
                    String phone = rs.getString(5);
                    int role = rs.getInt(7);
                    ac = new Account(accID, email,null ,fullName, phone, status, role);
                }
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }finally{
            try {
                cn.close();
            } catch (SQLException ex) {
            }
        }
        return ac;
    }
    
    public static boolean updateAccountStatus(String email){
        Connection cn  = null;
        boolean result = false;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "select * from Accounts where email = ? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs!=null&&rs.next()) {
                    int status = rs.getInt(6);
                    if(status == 1) pst = cn.prepareStatement("UPDATE Accounts SET [status] = 0 WHERE email = ?");
                    else pst = cn.prepareStatement("UPDATE Accounts SET [status] = 1 WHERE email = ?");
                    pst.setString(1, email);
                    result = pst.execute();        
                }
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        }finally{
            try {
                cn.close();
            } catch (SQLException ex) {
            }
        }
        return result;
    }
    
    public static boolean insertAccount(String email,String password,String fullName,String phone,int status,int role){
        Connection cn = null;
        try{
            cn = DBUtils.makeConnection();
            if(cn!= null){
                String sql = "INSERT INTO Accounts(email,password,fullname,phone,status,role) VALUES (?,?,?,?,?,?)";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setString(2, password);
                pst.setString(3, fullName);
                pst.setString(4, phone);
                pst.setInt(5, status);
                pst.setInt(6, role);
                pst.executeUpdate();
                return true;            
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }finally{
            try {
                cn.close();
            } catch (SQLException ex) {
            }
        }
        return false;
    }
    
    public static boolean changeAccount(String email,String fullName,String phone){
        Connection cn = null;
        boolean result = false;
        try{
            cn = DBUtils.makeConnection();
            if(cn!= null){
                Account data = getAccounts(email);
                if(data==null)return false;
                String sql = "update Accounts set fullname = ?,phone = ? where email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(3, email);
                pst.setString(1, fullName);
                pst.setString(2, phone);
                pst.executeUpdate();
                result = true;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }finally{
            try {
                cn.close();
            } catch (SQLException ex) {
            }
        }
        return result;
    }
    
    public static boolean changePass(String email,String pass){
        Connection cn = null;
        boolean result = false;
        try{
            cn = DBUtils.makeConnection();
            if(cn!= null){
                Account data = getAccounts(email);
                if(data==null)return false;
                String sql = "update Accounts set password = ? where email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(2, email);
                pst.setString(1, pass);
                pst.executeUpdate();
                return true;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }finally{
            try {
                cn.close();
            } catch (SQLException ex) {
            }
        }
        return result;
    }

    public static boolean deleteAccount(String email){
        boolean result=false;
        try {
             Connection cn=DBUtils.makeConnection();
             if(cn!=null){
                 String sql="delete from Accounts where email=?";
                 PreparedStatement pst=cn.prepareStatement(sql);
                 pst.setString(1, email);
                 pst.executeUpdate();  
                 result = true;
                 cn.close();
             }
        } catch (Exception e) {
            System.out.println("error connection");
        } 
        return result;
    }
    
    public static boolean updateAccount(String email, String fullname,int role){
        boolean result= false;
        try {
            Connection cn=DBUtils.makeConnection();
            if(cn!=null){
                String sql="update Accounts set FullName=?,role = ?  where email=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setString(1, fullname);
                pst.setInt(2, role);
                pst.setString(3, email);
                pst.executeUpdate();   
                result = true;
                cn.close();
             }
        } catch (Exception e) {
            System.out.println("error connection");
        }
        return result;
    }
    
    public static boolean updateToken(String token, String email){
        boolean result= false;
        try {
            Connection cn=DBUtils.makeConnection();
            if(cn!=null){
                String sql="update Accounts set token=?  where email=?";
                PreparedStatement pst=cn.prepareStatement(sql);
                pst.setString(1, token);
                pst.setString(2, email);
                pst.executeUpdate();   
                result = true;
                cn.close();
             }
        } catch (Exception e) {
            System.out.println("error connection");
        }
        return result;
    }
    
    public static Account getAccountByToken(String token){
        Account ac = null;
        Connection cn  = null;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "select * from Accounts where token = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, token);
                ResultSet rs = pst.executeQuery();
                if (rs!=null&&rs.next()) {
                    int accID = rs.getInt(1);
                    String email = rs.getString(2);
                    String pass = rs.getString(3);
                    String fullName = rs.getString(4);
                    int status = rs.getInt(6);
                    String phone = rs.getString(5);
                    int role = rs.getInt(7);
                    ac = new Account(accID, email,pass ,fullName, phone, status, role);
                }
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }finally{
            try {
                cn.close();
            } catch (SQLException ex) {
            }
        }
        return ac;
    }
    
    public static boolean updateAccountByAdmin(String email,String fullname,String phone, int accid){
        boolean result = false;
        Connection cn = null;
        try{
            cn = DBUtils.makeConnection();
            if(cn!=null){
                String sql = "update Accounts set FullName=?,email=?,phone=?  where accID=?";
                PreparedStatement ps = cn.prepareStatement(sql);
                ps.setString(1, fullname);
                ps.setString(2, email);
                ps.setString(3, phone);
                ps.setInt(4, accid);
                ps.executeUpdate();
                result = true;
            }
            cn.close();
        }catch(Exception e){
            
        }
        
        return result;
    }

    public static ArrayList<Account> getAccounts( int accid,String email,String fullname,String phone, int status) {
        ArrayList<Account> list = new ArrayList<>();
        Connection cn  = null;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "select * from Accounts where ";
                boolean hasquery = false;
                if(accid!=-1) { sql = sql + " accID = "+accid;hasquery=true;}
                if(!email.equals("")){ 
                    if(hasquery) sql+=" and "; else hasquery = true;
                    sql =sql+ " email like '%"+email+"%'";
                }
                if(!fullname.equals("")){ 
                    if(hasquery) sql+=" and "; else hasquery = true;
                    sql =sql+ " fullname like '%"+fullname+"%'";
                }
                if(!phone.equals("")){ 
                    if(hasquery) sql+=" and "; else hasquery = true;
                    sql =sql+ " phone like '%"+phone+"%'";
                }
                if(status!=-1) {
                    if(hasquery) sql+=" and "; else hasquery = true;
                    sql += "status = "+status;
                }
                sql+=" order by role, status";
                
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    int accID = rs.getInt(1);
                    String mail = rs.getString(2);
                    String password = rs.getString(3);
                    String fullName = rs.getString(4);
                    String p = rs.getString(5);
                    int s = rs.getInt(6);
                    int role = rs.getInt(7);
                    list.add(new Account(accID, mail, password, fullName, p, s, role));
                }
            }
            cn.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        AccountDAO a=new AccountDAO();
        AccountDAO.changePass("t","0");

    }
    
}
