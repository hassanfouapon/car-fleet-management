package com.projet.tp.models.dto;

import com.projet.tp.models.entitie.Depense;
import com.projet.tp.models.entitie.Utilisateur;
import com.projet.tp.models.entitie.Vehicule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepenseDto {

    private Long id;
    private Double montant;
    private String date_depense;
    private Depense.TypeDepense typeDepense;
    private double kilometrage;
    private String description;
    private Utilisateur utilisateur;
    private Vehicule vehicule;


    private Long utilisateurId;
    private Long vehiculeId;

}
