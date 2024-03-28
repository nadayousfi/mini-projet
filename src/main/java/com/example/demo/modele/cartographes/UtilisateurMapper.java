package com.example.demo.modele.cartographes;

import org.modelmapper.ModelMapper;

import com.example.demo.modele.dtos.UtilisateurDTO;
import com.example.demo.modele.entites.Utilisateur;

public class UtilisateurMapper {
private static final ModelMapper modelMapper=new ModelMapper();
public static UtilisateurDTO convertToDTO(Utilisateur user ) {
	return modelMapper.map(user, UtilisateurDTO.class);
}
public static Utilisateur convertToEntity(UtilisateurDTO userDTO) {
	return modelMapper.map(userDTO, Utilisateur.class);
}
}

