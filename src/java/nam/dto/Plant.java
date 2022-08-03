
package nam.dto;

public class Plant {
    private int id;
    private String name;
    private int price;
    private String path;
    private String des;
    private int status;
    private int cateID;
    private String cateName;

    public Plant() {
    }

    public Plant(int id, String name, int price, String path, String des, int status, int cateID, String cateName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.path = path;
        this.des = des;
        this.status = status;
        this.cateID = cateID;
        this.cateName = cateName;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCateID() {
        return cateID;
    }

    public void setCateID(int cateID) {
        this.cateID = cateID;
    }

    @Override
    public String toString() {
        return "Plant{" + "id=" + id + ", name=" + name + ", price=" + price + ", path=" + path + ", des=" + des + ", status=" + status + ", cateID=" + cateID + ", cateName=" + cateName + '}';
    }
    
    
    
    
}
