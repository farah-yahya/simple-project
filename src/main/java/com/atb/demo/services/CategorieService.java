package com.atb.demo.services;

import com.atb.demo.models.Categorie;
import com.atb.demo.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public Categorie getCategorieById(Long id) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
        return optionalCategorie.orElse(null);
    }

    public Categorie updateCategorie(Long id, Categorie categorie) {
        if (categorieRepository.existsById(id)) {
            categorie.setId(id);
            return categorieRepository.save(categorie);
        }
        return null;
    }

    public void deleteCategorie(Long id) {
        categorieRepository.deleteById(id);
    }
}
