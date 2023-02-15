package com.projet.tp;

import com.projet.tp.models.entitie.Utilisateur;
import com.projet.tp.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TpApplication {

    public static void main(String[] args) {
        SpringApplication.run(TpApplication.class, args);


    }

}
