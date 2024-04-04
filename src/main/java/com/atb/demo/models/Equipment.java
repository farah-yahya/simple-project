package com.atb.demo.models;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="equipement")

public class Equipment {

    @Id 
    private int id ;
     private String name; 
     private String category;
      private Date entree ;
      private Date sortie ;

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
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public Date getEntree() {
        return entree;
    }
    public void setEntree(Date entree) {
        this.entree = entree;
    }
    public Date getSortie() {
        return sortie;
    }
    public void setSortie(Date sortie) {
        this.sortie = sortie;
    }
    
    
      




}
