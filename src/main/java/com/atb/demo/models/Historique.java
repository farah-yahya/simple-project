package com.atb.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;




@Entity
@Table(name = "historique")
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class Historique {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "num_id_equipement", nullable = false)
    private Equipment equipement;

    @Column(name = "nombre_modifications")
    private int nombreModifications;

    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "date_prise")
    private Date datePrise;

    @Column(name = "date_retour")
    private Date dateRetour;

    private String etat;

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipment getEquipement() {
        return equipement;
    }

    public void setEquipement(Equipment equipement) {
        this.equipement = equipement;
    }

    public int getNombreModifications() {
        return nombreModifications;
    }

    public void setNombreModifications(int nombreModifications) {
        this.nombreModifications = nombreModifications;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Date getDatePrise() {
        return datePrise;
    }

    public void setDatePrise(Date datePrise) {
        this.datePrise = datePrise;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}

