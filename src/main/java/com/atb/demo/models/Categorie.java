
package com.atb.demo.models;


import javax.persistence.*;

@Entity
@Table(name = "categorie")
public class Categorie {
    @Id
    private Long id;

    @Column(name = "nom_categorie", nullable = false)
    private String nomCategorie;

    @ManyToOne
    @JoinColumn(name = "num_id_equipement", nullable = false)
    private Equipment equipement;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public Equipment getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipment equipement) {
        this.equipement = equipement;
    }
}




