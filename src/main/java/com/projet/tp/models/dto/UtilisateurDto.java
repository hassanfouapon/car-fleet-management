package com.projet.tp.models.dto;

import com.projet.tp.models.entitie.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurDto {

    private Long id;
    private String nom;
    private String prenom;
    private int age;
    private Utilisateur.Sexe sexe;
    private String email;
    private Utilisateur.Role role;
    private String poste;
    private String telephone;
    private String address;
    private String password;

}
