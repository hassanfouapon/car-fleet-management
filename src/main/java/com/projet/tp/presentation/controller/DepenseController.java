package com.projet.tp.presentation.controller;


import com.projet.tp.models.dto.DepenseDto;
import com.projet.tp.models.entitie.Utilisateur;
import com.projet.tp.services.serviceImpl.DepenseService;
import com.projet.tp.services.serviceImpl.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class DepenseController {

    @Autowired
    private DepenseService depenseService;

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/lister_depense")
    String listeDepense(){

        return "depense/lister_depense";
    }

    @GetMapping("/enregistrer_depense")
    String ajouter_depense(){

        return "depense/ajouter_depense";
    }


    @GetMapping("/depense_agent")
    String listeDepense_Agent(Principal principal, Model model){

       Utilisateur agent = utilisateurService.findUserByMail(principal.getName());

        System.out.println(agent);

        model.addAttribute("depenseDtos", depenseService.getListDepenseByAgent(agent.getId()));

        return "agent/liste_depense";
    }

    @GetMapping("/save_depense")
    String agentSaveDepense(Model model){

        DepenseDto depenseDto = new DepenseDto();
        model.addAttribute("depenseDto", depenseDto);

        return "agent/save_depense";
    }

    String store_depense(@ModelAttribute DepenseDto depenseDto){


        return "redirect:/agent_lister_depense";
    }

}
