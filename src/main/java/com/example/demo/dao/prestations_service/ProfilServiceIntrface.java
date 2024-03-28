package com.example.demo.dao.prestations_service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.modele.entites.Profil;

public interface ProfilServiceIntrface {
public Page<Profil> getProfils(Pageable pageable);
public Optional<Profil> getOneProfil(long id);
public void deleteOneProfil(long id);
}
