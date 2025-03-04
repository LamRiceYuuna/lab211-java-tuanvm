/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Le Viet
 */
public class Storekeeper {
    private int id;
    private String  Storekeeper;
    

    public Storekeeper() {
    }

    public Storekeeper(int id,String Storekeeper) {
        this.Storekeeper = Storekeeper;
        this.id=id;
    }

    public String getStorekeeper() {
        return Storekeeper;
    }

    public void setStorekeeper(String Storekeeper) {
        this.Storekeeper = Storekeeper;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
       
    
}
