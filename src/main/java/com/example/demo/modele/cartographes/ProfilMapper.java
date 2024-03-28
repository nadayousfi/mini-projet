package com.example.demo.modele.cartographes;

import org.modelmapper.ModelMapper;

import com.example.demo.modele.dtos.ProfilDTO;
import com.example.demo.modele.entites.Profil;

public class ProfilMapper {
private static final ModelMapper modelMapper=new ModelMapper();
public static ProfilDTO convertToDTO(Profil profil) {
	return modelMapper.map(profil, ProfilDTO.class);
}
public static Profil convertToEntity(ProfilDTO profilDTO) {
	return modelMapper.map(profilDTO, Profil.class);
}
}
