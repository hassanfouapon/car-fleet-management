package com.projet.tp.presentation.controller;

import com.projet.tp.services.serviceImpl.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private UtilisateurService utilisateurService;


    @GetMapping("/acceuil_agent")
    public String HomeAgent(Model model){

        model.addAttribute("users",utilisateurService.getAgent());

        return "agent/darshboard";
    }




}
