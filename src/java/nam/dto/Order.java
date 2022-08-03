
package nam.dto;

public class Order {
    private int orderID;
    private String shipDate;
    private String orderDate;
    private int status;
    private int accID;
    

    public Order() {
    }

    public Order(int orderID, String shipDate,String orderDate, int status, int accID) {
        this.orderID = orderID;
        this.shipDate = shipDate;
        this.status = status;
        this.accID = accID;
        this.orderDate = orderDate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    
    
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getAccID() {
        return accID;
    }

    public void setAccID(int accID) {
        this.accID = accID;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", shipDate=" + shipDate + ", orderDate=" + orderDate + ", status=" + status + ", accID=" + accID + '}';
    }
    
    
    
}
