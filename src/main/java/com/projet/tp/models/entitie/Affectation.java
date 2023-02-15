package com.projet.tp.models.entitie;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Affectation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name="agent")
    private Utilisateur agent;
    @ManyToOne
    @JoinColumn(name="vehicule")
    private Vehicule vehicule;
    private String date;

}
