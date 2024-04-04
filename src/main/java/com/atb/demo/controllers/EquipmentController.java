package com.atb.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atb.demo.models.Equipment;
import com.atb.demo.services.EquipementRepository;


@Controller
@CrossOrigin("*")
@RestController
@RequestMapping("/api/equipments")
public class EquipmentController {

    @Autowired
    private EquipementRepository EquipementRepository;

    // Create operation
    @PostMapping("/")
    public Equipment createEquipment(@RequestBody Equipment equipment) {
        return EquipementRepository.save(equipment);
    }

    // Read operation
    @GetMapping("/")
    public List<Equipment> getAllEquipments() {
        return EquipementRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Equipment> getEquipmentById(@PathVariable int id) {
        return EquipementRepository.findById(id);
    }

    // Update operation
    @PutMapping("/{id}")
    public Equipment updateEquipment(@PathVariable int id, @RequestBody Equipment updatedEquipment) {
        Equipment existingEquipment = EquipementRepository.findById(id).orElse(null);
        if (existingEquipment != null) {
            existingEquipment.setName(updatedEquipment.getName());
            existingEquipment.setCategory(updatedEquipment.getCategory());
            existingEquipment.setEntree(updatedEquipment.getEntree());
            existingEquipment.setSortie(updatedEquipment.getSortie());
            return EquipementRepository.save(existingEquipment);
        }
        return null;
    }

    // Delete operation
    @DeleteMapping("/{id}")
    public String deleteEquipment(@PathVariable int id) {
        EquipementRepository.deleteById(id);
        return "Equipment deleted with ID: " + id;
    }
}