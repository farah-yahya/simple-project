package com.atb.demo.controllers;

import java.util.List;

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

import com.atb.demo.models.Equipment;
import com.atb.demo.repository.EquipementRepository;

@RestController
@RequestMapping("/api/equipments")
public class EquipmentController {

    @Autowired
    private EquipementRepository equipementRepository;

    @PostMapping("/")
    public ResponseEntity<Equipment> createEquipment(@RequestBody Equipment equipment) {
        Equipment createdEquipment = equipementRepository.save(equipment);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEquipment);
    }

    @GetMapping("/")
    public ResponseEntity<List<Equipment>> getAllEquipments() {
        List<Equipment> equipments = equipementRepository.findAll();
        return ResponseEntity.ok().body(equipments);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipment> getEquipmentById(@PathVariable int id) {
        Equipment equipment = equipementRepository.findById(id).orElse(null);
        if (equipment != null) {
            return ResponseEntity.ok().body(equipment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipment> updateEquipment(@PathVariable int id, @RequestBody Equipment updatedEquipment) {
        Equipment existingEquipment = equipementRepository.findById(id).orElse(null);
        if (existingEquipment != null) {
            existingEquipment.setName(updatedEquipment.getName());
            existingEquipment.setCategory(updatedEquipment.getCategory());
            existingEquipment.setEntree(updatedEquipment.getEntree());
            existingEquipment.setSortie(updatedEquipment.getSortie());
            Equipment updated = equipementRepository.save(existingEquipment);
            return ResponseEntity.ok().body(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEquipment(@PathVariable int id) {
        Equipment equipment = equipementRepository.findById(id).orElse(null);
        if (equipment != null) {
            equipementRepository.deleteById(id);
            return ResponseEntity.ok().body("Equipment deleted with ID: " + id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
