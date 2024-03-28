package com.example.demo.modele.dtos;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurDTO {
@NotBlank(message = "le nom est obligatoire ")
private String nom;
@NotBlank(message = "le prenom est obligatoire")
private String prenom;
@NotBlank(message = "le mail est obilgatoire")
@Email(message = "email non valide")
private String email;
@NotBlank(message = "numero telephone obligatoire")
@Size(min=8,max=8)
private String telephone;
ProfilDTO profilDTO;
private List<TachesDTO> taches;

}
