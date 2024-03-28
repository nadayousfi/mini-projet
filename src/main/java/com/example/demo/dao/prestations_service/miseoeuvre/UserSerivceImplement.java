package com.example.demo.dao.prestations_service.miseoeuvre;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.dao.prestations_service.UserServiceInterface;
import com.example.demo.dao.refrentiels.ProfilRepository;
import com.example.demo.dao.refrentiels.UtilisateurRepository;
import com.example.demo.modele.entites.Profil;
import com.example.demo.modele.entites.Utilisateur;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserSerivceImplement implements UserServiceInterface {
	private final UtilisateurRepository userReposotiry;
	private final ProfilRepository profilRepository;
	@Override
	@Transactional()
	public Page<Utilisateur> getUtilisateurs(Pageable pageable) {
		return userReposotiry.findAll(pageable);
	}

	@Override
	public Optional<Utilisateur> getOneUtilisateur(long id) {
		// TODO Auto-generated method stub
		return userReposotiry.findById(id);
	}

	@Override
	public Utilisateur createOneUtilisateur(Utilisateur user) {
		// TODO Auto-generated method stub
		return userReposotiry.save(user);
	}

	@Override
	public void deleteOneUser(Long id) {
		userReposotiry.deleteById(id);
		
	}

	@Override
	public Utilisateur AssignProfiltoUtilisateur(long UserId, Profil profil) {
		// TODO Auto-generated method stub
		return userReposotiry.findById(UserId).map(user ->
		{
			profil.setUser(user);
			user.setProfile(profil);
			return userReposotiry.save(user);
		}
			).orElseThrow(()->new 	EntityNotFoundException("user not found Exception"));
	}

	@Override
	public Profil updateProfil(Profil profil, long userId) {
		// TODO Auto-generated method stub
		return profilRepository.findById(userId).map(userProfil->
		{
			userProfil=profil;
			userProfil.setId(userId);
			return profilRepository.save(userProfil);
		}).orElseThrow(()-> new EntityNotFoundException("profil not found with ce id"));
	}

}
