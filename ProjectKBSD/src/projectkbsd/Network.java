/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkbsd;

import java.util.ArrayList;

/**
 *
 * @author Marc
 */
public class Network {
    private ArrayList<Component> list;
    private ArrayList<Component> uniqueList;
    
    public Network(){
        this.list = new ArrayList<Component>();
        this.uniqueList = new ArrayList<Component>();
    }
    
    // toevoegen component aan hoofdscherm om te kunnen slepen.
    public void addComponent(Component cn) {
        this.list.add(cn);
    }
    
    // toevoegen component voor Opslaan van het netwerk.
    public void addUniqueComponent(Component cn) {
        this.uniqueList.add(cn);
    }
}
