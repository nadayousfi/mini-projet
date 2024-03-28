package com.example.demo.dao.prestations_service.miseoeuvre;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.prestations_service.TachesServiceIntrface;
import com.example.demo.dao.refrentiels.TachesRepository;
import com.example.demo.dao.refrentiels.UtilisateurRepository;
import com.example.demo.modele.cartographes.TachesMapper;
import com.example.demo.modele.dtos.TachesDTO;
import com.example.demo.modele.entites.Taches;
import com.example.demo.modele.entites.Utilisateur;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class TachesServiceImplement implements TachesServiceIntrface {
	private final TachesRepository tacheRepository;
	private final UtilisateurRepository userRepository;
	@Override
	public Page<Taches> getAllTaches(Pageable pageable) {
		return tacheRepository.findAll(pageable);
	}
	@Override
	public TachesDTO addOneTaches(TachesDTO taches, long idUser) {
		Optional<Utilisateur> user=userRepository.findById(idUser);
		if(!user.isEmpty()) {
			Taches t=TachesMapper.convetToEntity(taches);
			t.setUser(user.get());
			return TachesMapper.convetToDTO(tacheRepository.save(t));
		}else return null;
	}
	@Override
	public void deleteOneTache(long id) {
		 tacheRepository.deleteById(id);
	}
	@Override
	public TachesDTO updateOneTache(long id, TachesDTO taches) {
		Optional<Taches> t=tacheRepository.findById(id);
		Taches tc=TachesMapper.convetToEntity(taches);
		if(!t.isPresent()) {
			tc.setUser(t.get().getUser());
			tc.setId(id);
			return TachesMapper.convetToDTO(tacheRepository.save(tc));
		}else return null;
	}
	@Override
	public TachesDTO getOneTache(long id) {
		return TachesMapper.convetToDTO(tacheRepository.findById(id).orElse(null));
	}


}
