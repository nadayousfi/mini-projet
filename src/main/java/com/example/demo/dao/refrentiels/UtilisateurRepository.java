package com.example.demo.dao.refrentiels;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.modele.entites.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

}
