package com.projet.tp.presentation.controller;


import com.projet.tp.models.dto.CategorieDto;
import com.projet.tp.models.entitie.Categorie;
import com.projet.tp.services.serviceImpl.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class CategorieController {
    @Autowired
    CategorieService categorieService;

    @GetMapping("liste_categorie")
    public String listeCategorie(Model model){

        model.addAttribute("categories", categorieService.getListCategorie());
        return "categorie/lister_categorie";
    }

    @GetMapping("/ajouter_categorie")
    public String ajouterCategorie(Model model){

        CategorieDto categorieDto = new CategorieDto();
        model.addAttribute("categorie", categorieDto);

        return "categorie/ajouter_categorie";
    }


    @PostMapping("/categorie_save")
    public String saveCategorie(CategorieDto categorieDto, BindingResult result, Model model){

        if (result.hasErrors()) {
            return "categorie/ajouter_categorie";
        }
        categorieService.saveCategorie(categorieDto);

        return "redirect:/liste_categorie";
    }

    @PostMapping("/categorie_update")
    public String updateCategorie(CategorieDto categorieDto, BindingResult result, Model model){

        if (result.hasErrors()) {
            return "categorie/modifier_categorie";
        }
        categorieService.updateCategorie(categorieDto);

        return "redirect:/liste_categorie";
    }



    @GetMapping("/categorie_details")
    @ResponseBody
    public String detailCategorie(@ModelAttribute Long id,Model model){

        CategorieDto categorieDto= categorieService.detailsCategorieById(id);
        System.out.println("----------------------->"+categorieDto.getId());

        model.addAttribute("categorie", categorieService.detailsCategorieById(id));

        return "modifier_categorie.html";
    }

    @GetMapping("suprimer_categorie")
    public void deleteCategorie(@ModelAttribute long id){
        categorieService.supprimerCategorie(id);
    }




}
