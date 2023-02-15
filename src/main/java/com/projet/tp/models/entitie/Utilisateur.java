package com.projet.tp.models.entitie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Utilisateur {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private int age;

    @Enumerated(EnumType.STRING)
    private Sexe sexe;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String poste;
    private String telephone;
    private String address;
    @Enumerated(EnumType.STRING)
    private Etat etat;



    @OneToMany(mappedBy="agent")
    private List<Affectation> Listaffectation;


    public Utilisateur(String email, String password, Role role,Sexe sexe) {
        this.sexe = sexe;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public enum Sexe {
        MASCULIN, FEMININ
    }
    public enum Role {
        Agent, Admin
    }
    public enum Etat {
        Active, Inactive
    }


}


