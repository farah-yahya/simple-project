package com.atb.demo.services.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atb.demo.models.Historique;
import com.atb.demo.repository.HistoriqueRepository;
import com.atb.demo.services.HistoriqueService;

@Service
public class HistoriqueServiceImpl implements HistoriqueService {

    private final HistoriqueRepository historiqueRepository;

    @Autowired
    public HistoriqueServiceImpl(HistoriqueRepository historiqueRepository) {
        this.historiqueRepository = historiqueRepository;
    }

    @Override
    public Historique getHistoriqueById(Long id) {
        Optional<Historique> optionalHistorique = historiqueRepository.findById(id);
        return optionalHistorique.orElse(null);
    }

    @Override
    public List<Historique> getHistoriquesByEquipementId(Long equipementId) {
        return historiqueRepository.findByEquipementId(equipementId);
    }

    @Override
    public Historique createHistorique(Historique historique) {
        return historiqueRepository.save(historique);
    }

    @Override
    public Historique updateHistorique(Long id, Historique historique) {
        if (historiqueRepository.existsById(id)) {
            historique.setId(id);
            return historiqueRepository.save(historique);
        }
        return null;
    }

    @Override
    public boolean deleteHistorique(Long id) {
        if (historiqueRepository.existsById(id)) {
            historiqueRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
