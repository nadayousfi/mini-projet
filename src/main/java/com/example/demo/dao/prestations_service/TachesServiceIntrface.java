package com.example.demo.dao.prestations_service;


import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import com.example.demo.modele.dtos.TachesDTO;
import com.example.demo.modele.entites.Taches;

public interface TachesServiceIntrface {
public Page<Taches> getAllTaches(Pageable pageable);
public TachesDTO addOneTaches(TachesDTO taches,long idUser);
public void deleteOneTache(long id);
public TachesDTO updateOneTache(long id,TachesDTO taches);
public TachesDTO getOneTache(long id);
}
