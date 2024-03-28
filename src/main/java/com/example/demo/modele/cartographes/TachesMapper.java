package com.example.demo.modele.cartographes;

import org.modelmapper.ModelMapper;

import com.example.demo.modele.dtos.TachesDTO;
import com.example.demo.modele.entites.Taches;

public class TachesMapper {
private static final ModelMapper modelMapper=new ModelMapper();
public static TachesDTO convetToDTO(Taches taches ) {
	return modelMapper.map(taches, TachesDTO.class);
}
public static Taches convetToEntity(TachesDTO tachesDTO) {
	return modelMapper.map(tachesDTO, Taches.class);
}
}
