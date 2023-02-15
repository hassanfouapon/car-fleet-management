package com.projet.tp.models.entitie;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;



@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Depense {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double montant;

    private String date_depense;

    @Enumerated(EnumType.STRING)
    private TypeDepense typeDepense;

    private double kilometrage;
    @ManyToOne
    @JoinColumn(name="agentId")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name="vehiculeId")
    private Vehicule vehicule;

    private String description;



    public enum TypeDepense {
        Consommation, Maintenance
    }

}
