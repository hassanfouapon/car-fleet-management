package com.projet.tp.models.dto;

import com.projet.tp.models.entitie.Utilisateur;
import com.projet.tp.models.entitie.Vehicule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AffectationDto {

    private Long id;
    private Utilisateur agent;
    private Vehicule vehicule;
    private String date;

    private Long vehiculeid;
}
