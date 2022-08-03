/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nam.dto;

/**
 *
 * @author LapTop
 */
public class PlantDes implements Comparable{
    private int id;
    private String name;
    private int price;
    private String path;
    private String des;
    private int status;
    private int cateID;
    private String cateName;
    private int processing;
    private int completed;
    private int canceled;

    public PlantDes() {
    }

    public PlantDes(int id, String name, int price, String path, String des, int status, int cateID, String cateName, int processing, int completed, int canceled) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.path = path;
        this.des = des;
        this.status = status;
        this.cateID = cateID;
        this.cateName = cateName;
        this.processing = processing;
        this.completed = completed;
        this.canceled = canceled;
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

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public int getProcessing() {
        return processing;
    }

    public void setProcessing(int processing) {
        this.processing = processing;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public int getCanceled() {
        return canceled;
    }

    public void setCanceled(int cancelted) {
        this.canceled = cancelted;
    }

    @Override
    public String toString() {
        return "PlantDes{" + "id=" + id + ", name=" + name + ", price=" + price + ", path=" + path + ", des=" + des + ", status=" + status + ", cateID=" + cateID + ", cateName=" + cateName + ", processing=" + processing + ", completed=" + completed + ", cancelted=" + canceled + '}';
    }

    @Override
    public int compareTo(Object t) {
        return (((PlantDes)t).canceled+((PlantDes)t).completed+((PlantDes)t).processing)-(this.canceled+this.processing+this.completed);
    }
    
    
    
}
