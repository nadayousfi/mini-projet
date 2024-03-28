package com.example.demo.controleurs;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.prestations_service.UserServiceInterface;
import com.example.demo.modele.cartographes.UtilisateurMapper;
import com.example.demo.modele.dtos.UtilisateurDTO;
import com.example.demo.modele.entites.Profil;
import com.example.demo.modele.entites.Utilisateur;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
private final UserServiceInterface userService;

@GetMapping
public ResponseEntity <List<UtilisateurDTO>>getUsers(Pageable pageable){
	Page<Utilisateur> userPage=userService.getUtilisateurs(pageable);
	List<UtilisateurDTO> userDTOs=userPage.getContent().stream()
			.map(UtilisateurMapper::convertToDTO)
			.collect(Collectors.toList());
	return ResponseEntity.ok(userDTOs);
}
@PostMapping
public ResponseEntity<UtilisateurDTO> addOne(@Valid @RequestBody UtilisateurDTO user){
Utilisateur us=UtilisateurMapper.convertToEntity(user);
Utilisateur u=userService.createOneUtilisateur(us);
UtilisateurDTO usdto=UtilisateurMapper.convertToDTO(us);
return ResponseEntity.ok(usdto);
}
@PatchMapping("/{userId}")
public ResponseEntity<Utilisateur> assignProfile(@Valid @RequestBody Profil profil,@PathVariable long userId){
	return ResponseEntity.ok(userService.AssignProfiltoUtilisateur(userId, profil));
}
@DeleteMapping("/{id}")
public void deleeteOneUser( @PathVariable long id) {
	userService.deleteOneUser(id);
}
}
