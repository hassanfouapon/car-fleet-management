package com.projet.tp.presentation.controller;


import com.projet.tp.models.entitie.Utilisateur;
import com.projet.tp.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @GetMapping("/seed")
    public void saveU(){
        Utilisateur user= new Utilisateur("admin@gmail.com",encoder.encode("admin"), Utilisateur.Role.Admin, Utilisateur.Sexe.MASCULIN);
        utilisateurRepository.save(user);
    }

    @GetMapping("/login")
    String login(){
        return "auth/login";
    }

    @GetMapping("/forgot_password")
    String forgotPassword(){

        return "auth/forgotPassword";
    }

    @GetMapping("/reset_password")
    String reset_password(){

        return "auth/reset_password";
    }




    @GetMapping("/logout")
    public String logout() {

        return "auth/login";
    }

    @GetMapping("/profile")
    public String profile() {

        return "setting_profile/setting_profile";
    }






}
