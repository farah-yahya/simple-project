package com.atb.demo.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atb.demo.models.Equipment;

public interface EquipementRepository extends JpaRepository<Equipment,Integer> {

}
