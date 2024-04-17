package com.atb.demo.services;

import java.util.List;

import com.atb.demo.models.Historique;

public interface HistoriqueService {
    Historique getHistoriqueById(Long id);
    List<Historique> getHistoriquesByEquipementId(Long equipementId);
    Historique createHistorique(Historique historique);
    Historique updateHistorique(Long id, Historique historique);
    boolean deleteHistorique(Long id);
}
