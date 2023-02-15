package com.projet.tp.models.entitie;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehicule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String immatriculation;

    private String date_acquisition;
    private String marque;

    @Enumerated(EnumType.STRING)
    private Energie energie;
    private double kilometrage;
    @Enumerated(EnumType.STRING)
    private Etat etat;
    private String description;

    @ManyToOne
    @JoinColumn(name="categorieid")
    private Categorie categorie;

    @OneToMany(mappedBy="vehicule")
    private List<Affectation> Listaffectation;


    public enum Etat {
        Occuper, Libre
    }

    public enum Energie {
        Essence, Gazoil,Electrique, Petrole, Carburant
    }
}
