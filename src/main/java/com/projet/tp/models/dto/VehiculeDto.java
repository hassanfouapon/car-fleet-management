package com.projet.tp.models.dto;


import com.projet.tp.models.entitie.Categorie;
import com.projet.tp.models.entitie.Vehicule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VehiculeDto {

    private Long id;
    private String immatriculation;

    private String date_acquisition;
    private String marque;
    private Vehicule.Energie energie;
    private double kilometrage;
    private Vehicule.Etat etat;
    private String description;
    private Categorie categorie;

    private Long categorieId;

}
