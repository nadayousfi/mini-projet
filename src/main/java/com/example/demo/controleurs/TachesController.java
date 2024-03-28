package com.example.demo.controleurs;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.prestations_service.TachesServiceIntrface;
import com.example.demo.modele.dtos.TachesDTO;
import com.example.demo.modele.entites.Taches;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/taches")
@RequiredArgsConstructor
public class TachesController {
private final TachesServiceIntrface tacheService;
@GetMapping
public ResponseEntity<Page<Taches>> getAllTaches(Pageable pageable){
	return ResponseEntity.ok(tacheService.getAllTaches(pageable));
}
@PostMapping("/{id}")
public ResponseEntity<TachesDTO> addOneTache(@RequestBody TachesDTO taches,@PathVariable long id){
	return ResponseEntity.ok(tacheService.addOneTaches(taches, id));
}
@GetMapping("/{id}")
public ResponseEntity<TachesDTO>getOneTache(@PathVariable long id ){
	return ResponseEntity.ok(tacheService.getOneTache(id));
}
}
