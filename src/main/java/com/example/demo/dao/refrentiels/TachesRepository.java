package com.example.demo.dao.refrentiels;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modele.entites.Taches;

public interface TachesRepository extends JpaRepository<Taches, Long> {

}
