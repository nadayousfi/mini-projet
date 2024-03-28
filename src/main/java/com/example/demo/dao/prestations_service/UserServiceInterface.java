package com.example.demo.dao.prestations_service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.modele.entites.Profil;
import com.example.demo.modele.entites.Utilisateur;

public interface UserServiceInterface {
public Page<Utilisateur> getUtilisateurs(Pageable pageable);
public Optional<Utilisateur> getOneUtilisateur(long id);
public Utilisateur createOneUtilisateur(Utilisateur user);
public void deleteOneUser(Long id);
public Utilisateur AssignProfiltoUtilisateur(long UserId,Profil profil);
public Profil updateProfil(Profil profil, long userId );
}
