
package nam.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import nam.dto.Order;
import nam.dto.OrderDetail;
import nam.utils.DBUtils;

public class OrderDAO {
    
    public static ArrayList<Order> getOrders(String email){
        ArrayList<Order> list = new ArrayList<>();
        Connection cn  = null;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "select o.OrderID,OrdDate,shipdate,o.status,o.AccID from Orders o left join Accounts a \n" +
                                "on o.AccID = a.accID where email = ? order by o.status";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                while(rs!=null&&rs.next()){
                    int orderID = rs.getInt(1);
                    String orderDate = rs.getString(2);
                    String shipDate = rs.getString(3);
                    int status = rs.getInt(4);
                    int accID = rs.getInt(5);
                    Order o = new Order(orderID, shipDate, orderDate, status, accID);
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
    
    public static ArrayList<Order> getOrders(String email,int filterStatus){
        ArrayList<Order> list = new ArrayList<>();
        Connection cn  = null;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "select o.OrderID,OrdDate,shipdate,o.status,o.AccID from Orders o left join Accounts a \n" +
                                "on o.AccID = a.accID where email = ? and o.status = ? ";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                pst.setInt(2, filterStatus);
                ResultSet rs = pst.executeQuery();
                while(rs!=null&&rs.next()){
                    int orderID = rs.getInt(1);
                    String orderDate = rs.getString(2);
                    String shipDate = rs.getString(3);
                    int status = rs.getInt(4);
                    int accID = rs.getInt(5);
                    Order o = new Order(orderID, shipDate, orderDate, status, accID);
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
    
    public static ArrayList<OrderDetail> getOrderDetail(int orderID){
        ArrayList<OrderDetail> list = new ArrayList<>();
        Connection cn  = null;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "select o.DetailId,o.OrderID,p.PID,p.PName,p.price,p.imgPath,o.quantity from OrderDetails o \n" +
"left join Plants p on p.PID = o.FID where o.OrderID = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, orderID);
                ResultSet rs = pst.executeQuery();
                while(rs!=null&&rs.next()){
                    int orderDetailID = rs.getInt(1);
                    int plantID = rs.getInt(3);
                    String plantName = rs.getString(4);
                    int price =rs.getInt(5);
                    String ImgPath = rs.getString(6);
                    int quantity = rs.getInt(7);
                    
                    OrderDetail o = new OrderDetail(orderDetailID, orderID, plantID, plantName, price, ImgPath, quantity);
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
    
    public static boolean cancelOrder(int orderid,String email){
        Connection cn  = null;
        boolean result = false;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "select * from Orders o left join Accounts a on a.accID = o.AccID  where OrderID = ? and a.email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, orderid);
                pst.setString(2, email);
                ResultSet rs = pst.executeQuery();
                if (rs!=null&&rs.next()) {
                    int status = rs.getInt(4);
                    if(status != 1) return false;
                    pst = cn.prepareStatement("UPDATE Orders SET [status] = ? WHERE OrderID = ?");
                    pst.setInt(1, 3);
                    pst.setInt(2, orderid);
                    pst.executeUpdate();     
                    result = true;
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
    
    public static boolean reorder(int orderid,String email){
        Connection cn  = null;
        boolean result = false;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "select * from Orders o left join Accounts a on a.accID = o.AccID  where OrderID = ? and a.email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setInt(1, orderid);
                pst.setString(2, email);
                ResultSet rs = pst.executeQuery();
                if (rs!=null&&rs.next()) {
                    pst = cn.prepareStatement("SELECT * FROM OrderDetails WHERE OrderID = ?");
                    pst.setInt(1, orderid);
                    ResultSet rs2 = pst.executeQuery();
                    HashMap<String,Integer> cart = new HashMap<>();
                    while(rs2!=null&&rs2.next()){
                        System.out.println("1");
                        String id = rs2.getString("FID");
                        int quantity = rs2.getInt("quantity");
                        cart.put(id, quantity);
                    }
                    insertOrder(email, cart);
                    result = true;
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
    
    public static boolean insertOrder(String email,HashMap<String,Integer> cart){
        Connection cn = null;
        boolean result = false;
        try{
            cn = DBUtils.makeConnection();
            if(cn != null){
                cn.setAutoCommit(false);
                String sql = "select * from Accounts where email = ?";
                PreparedStatement pst = cn.prepareStatement(sql);
                pst.setString(1, email);
                ResultSet rs = pst.executeQuery();
                if (rs!=null&&rs.next()) {
                    int accId = rs.getInt(1);
                    pst = cn.prepareStatement("INSERT Orders(OrdDate,status,AccID) VALUES (?,?,?)");
                    pst.setDate(1,new Date(System.currentTimeMillis()));
                    pst.setInt(2, 1);
                    pst.setInt(3, accId);
                    pst.executeUpdate();

                    sql = "SELECT TOP 1 OrderID from Orders ORDER BY OrderID desc";
                    pst = cn.prepareStatement(sql);
                    rs = pst.executeQuery();
                    if (rs != null && rs.next()) {
                        int orderID = rs.getInt("OrderID");
                        Set<String> pids = cart.keySet();
                        for (String pid : pids) {
                            pst = cn.prepareStatement("INSERT OrderDetails(OrderID,FID,quantity) VALUES (?,?,?)");
                            pst.setInt(1,orderID );
                            pst.setInt(2, Integer.parseInt(pid));
                            pst.setInt(3, cart.get(pid));
                            pst.executeUpdate();
                            cn.commit();
                            cn.setAutoCommit(true);
                        } 
                        result = true;
                    }

                }
            }
        }catch(Exception e){
            if(cn!=null) try {
                cn.rollback();
            } catch (SQLException ex) {
            }
            result=false;
        }finally{
            try{
                cn.close();
            }catch(Exception b){}
        }
        return result;
    }

    public static ArrayList<Order> getAllOrders(){
        ArrayList<Order> list = new ArrayList<>();
        Connection cn  = null;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "select o.OrderID,OrdDate,shipdate,o.status,o.AccID from Orders o left join Accounts a \n" +
                                "on o.AccID = a.accID order by o.status";
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs!=null&&rs.next()){
                    int orderID = rs.getInt(1);
                    String orderDate = rs.getString(2);
                    String shipDate = rs.getString(3);
                    int status = rs.getInt(4);
                    int accID = rs.getInt(5);
                    Order o = new Order(orderID, shipDate, orderDate, status, accID);
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
    
    public static ArrayList<Order> getOrders(int acc,int orID,String date1,String date2,int s){
        ArrayList<Order> list = new ArrayList<>();
        Connection cn  = null;
        try {
            cn = DBUtils.makeConnection();
            if(cn != null){
                String sql = "select * from Orders where ";
                boolean hasquery = false;
                if(orID!=-1) { sql = sql + " OrderID = "+orID;hasquery=true;}
                if(acc!=-1) {
                    if(hasquery) sql+=" and "; else hasquery = true;
                    sql += "AccID = "+acc;
                }
                if(date1!=null&&!date1.equals("")){ 
                    if(hasquery) sql+=" and "; else hasquery = true;
                    sql =sql+ " OrdDate >= '"+date1+"'";
                }
                if(date2!=null&&!date2.equals("")) {
                    if(hasquery) sql+=" and "; else hasquery = true;
                    sql += " shipdate <= '"+date2+"'";
                }
                if(s!=-1) {
                    if(hasquery) sql+=" and "; else hasquery = true;
                    sql += "status = "+s;
                }
                sql+=" order by OrdDate, status";
                System.out.println(sql);
                PreparedStatement pst = cn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery();
                while(rs!=null&&rs.next()){
                    int orderID = rs.getInt(1);
                    String orderDate = rs.getString(2);
                    String shipDate = rs.getString(3);
                    int status = rs.getInt(4);
                    int accID = rs.getInt(5);
                    Order o = new Order(orderID, shipDate, orderDate, status, accID);
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
    
    public static void main(String[] args) {
        OrderDAO d = new OrderDAO();
        reorder(23,"test1@gmail.com");
//        ArrayList<Order> a = OrderDAO.getOrders(1, -1,"","", -1);
//        for (Order o : a) {
//            System.out.println(o);
//        }
    }
}
