package com.atb.demo.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atb.demo.models.Historique;
import com.atb.demo.services.HistoriqueService;

@RestController
@RequestMapping("/api/historiques")
public class HistoriqueController {

    private final HistoriqueService historiqueService;

    @Autowired
    public HistoriqueController(HistoriqueService historiqueService) {
        this.historiqueService = historiqueService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Historique> getHistoriqueById(@PathVariable Long id) {
        Historique historique = historiqueService.getHistoriqueById(id);
        if (historique != null) {
            return ResponseEntity.ok().body(historique);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/equipement/{equipementId}")
    public ResponseEntity<List<Historique>> getHistoriquesByEquipementId(@PathVariable Long equipementId) {
        List<Historique> historiques = historiqueService.getHistoriquesByEquipementId(equipementId);
        return ResponseEntity.ok().body(historiques);
    }

    @PostMapping("/create")
    public ResponseEntity<Historique> createHistorique(@Valid @RequestBody Historique historique) {
        Historique createdHistorique = historiqueService.createHistorique(historique);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHistorique);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Historique> updateHistorique(@PathVariable Long id, @RequestBody Historique historique) {
        Historique updatedHistorique = historiqueService.updateHistorique(id, historique);
        if (updatedHistorique != null) {
            return ResponseEntity.ok().body(updatedHistorique);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistorique(@PathVariable Long id) {
        boolean deleted = historiqueService.deleteHistorique(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
