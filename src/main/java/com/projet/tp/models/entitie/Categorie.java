package com.projet.tp.models.entitie;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String libele;
    private String description;

    @OneToMany(mappedBy="categorie")
    private List<Vehicule> Listmateriel;




}
