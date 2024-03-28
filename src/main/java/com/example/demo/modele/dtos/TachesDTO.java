package com.example.demo.modele.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TachesDTO {
@NotBlank(message = "le titre ne dois pas etre vide")
private String titre;
private String description;
}
