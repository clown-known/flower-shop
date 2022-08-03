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
public class CateDes {
    private int id;
    private String name;
    private int numP;

    public CateDes() {
    }

    public CateDes(int id, String name, int numP) {
        this.id = id;
        this.name = name;
        this.numP = numP;
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

    public int getNumP() {
        return numP;
    }

    public void setNumP(int numP) {
        this.numP = numP;
    }

    @Override
    public String toString() {
        return "CateDes{" + "id=" + id + ", name=" + name + ", numP=" + numP + '}';
    }
    
    
    
}
