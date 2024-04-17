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

import com.atb.demo.models.atb;
import com.atb.demo.repository.atbrepository;

@RestController
@RequestMapping("/api/atb")
public class atbcontroller {

    @Autowired
    private atbrepository atbrepository;

    @PostMapping("/")
    public ResponseEntity<atb> createatb(@RequestBody atb atb) {
        atb createdatb = atbrepository.save(atb);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdatb);
    }

    @GetMapping("/")
    public ResponseEntity<List<atb>> getAllatb() {
        List<atb> atb = atbrepository.findAll();
        return ResponseEntity.ok().body(atb);
    }

    @GetMapping("/{id}")
    public ResponseEntity<atb> getatbById(@PathVariable int id) {
        atb atb = atbrepository.findById(id).orElse(null);
        if (atb != null) {
            return ResponseEntity.ok().body(atb);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<atb> updateatb(@PathVariable int id, @RequestBody atb updatedatb) {
        atb existingatb = atbrepository.findById(id).orElse(null);
        if (existingatb != null) {
            existingatb.setName(updatedatb.getName());
            
            atb updated = atbrepository.save(existingatb);
            return ResponseEntity.ok().body(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteatb(@PathVariable int id) {
        atb atb = atbrepository.findById(id).orElse(null);
        if (atb != null) {
            atbrepository.deleteById(id);
            return ResponseEntity.ok().body("atb deleted with ID: " + id);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

