package com.projet.tp.presentation.controller;

import com.projet.tp.models.dto.UtilisateurDto;
import com.projet.tp.models.dto.VehiculeDto;
import com.projet.tp.models.entitie.Utilisateur;
import com.projet.tp.services.serviceImpl.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/AjoutUser")
    public String ajouterUser(Model model){

        UtilisateurDto utilisateurDto = new UtilisateurDto();
        //utilisateurDto.set;
        model.addAttribute("user",utilisateurDto);

        return "utilisateur/enregistrerUser";
    }


    @GetMapping("/listeUser")
    public String listerUser(Model model){

        model.addAttribute("users",utilisateurService.getAgent());

        return "utilisateur/listeUser";
    }

    @PostMapping("/enregistrer_user")
    public String SaveAgent(UtilisateurDto user){

        user.setRole(Utilisateur.Role.Agent);
        utilisateurService.saveUser(user);

        return "redirect:/listeUser";
    }

    @PostMapping("/update_user")
    public String updateAgent(UtilisateurDto user){

        user.setRole(Utilisateur.Role.Agent);
        utilisateurService.updateUser(user);

        return "redirect:/listeUser";
    }

    @GetMapping("/modifier_user")
    public String modif_userForm(@RequestParam Long id, Model model){
        try {
            UtilisateurDto utilisateur = utilisateurService.DetailsUser(id);
            model.addAttribute("user", utilisateur);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "utilisateur/updateUser";
    }

    @GetMapping("suprimer_utilisateur")
    public String deleteCategorie(@RequestParam long id){
        try {
            utilisateurService.deleteAgent(id);

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "redirect:/listeUser";

    }




}

