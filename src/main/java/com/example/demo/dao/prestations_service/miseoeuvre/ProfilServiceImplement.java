package com.example.demo.dao.prestations_service.miseoeuvre;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.refrentiels.ProfilRepository;
import com.example.demo.modele.entites.Profil;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class ProfilServiceImplement implements com.example.demo.dao.prestations_service.ProfilServiceIntrface {
	private final ProfilRepository profilRepository;
	@Override
	public Page<Profil> getProfils(Pageable pageable) {
		// TODO Auto-generated method stub
		return profilRepository.findAll(pageable);
	}

	@Override
	public Optional<Profil> getOneProfil(long id) {
		// TODO Auto-generated method stub
		return profilRepository.findById(id);
	}

	@Override
	public void deleteOneProfil(long id) {
		 profilRepository.deleteById(id);
	}

	

}
