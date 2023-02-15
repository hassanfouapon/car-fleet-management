package com.projet.tp.presentation.controller;



import com.projet.tp.models.dto.VehiculeDto;
import com.projet.tp.models.entitie.Vehicule;
import com.projet.tp.services.Iservices.IVehicule;
import com.projet.tp.services.serviceImpl.CategorieService;
import com.projet.tp.services.serviceImpl.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class VehiculeController {

    @Autowired
    VehiculeService vehiculeService;

    @Autowired
    CategorieService categorieService;

    /**routes des vehicules**/



    @GetMapping("/ajouter_vehicule")
    public String ajouter_vehicule(Model model){

        VehiculeDto vehiculeDto = new VehiculeDto();
        model.addAttribute("vehiculeDto", vehiculeDto);
        model.addAttribute("categories", categorieService.getListCategorie());

        return "gestion_vehicules/ajouter_vehicule";
    }



    @GetMapping("/lister_vehicule")
    public String ListeVehicule(Model model){
        List<VehiculeDto> vehiculeDTOS = vehiculeService.getListVehicule();
        model.addAttribute("vehiculeDTOS", vehiculeDTOS);

        return "gestion_vehicules/lister_vehicule";
    }


    @GetMapping("/rechercher_vehicule")
    public String rechercherVehicule(@RequestParam(value = "motcle", defaultValue = "") String articles, Model model) {

        List<VehiculeDto> vehiculeDTOS = vehiculeService.rechercherVehicules(articles);
        model.addAttribute("vehiculeDTOS", vehiculeDTOS);

        return "rechercher_vehicule";
    }


    @GetMapping("/modifier_vehicule")
    public String modif_vehiculeForm(@RequestParam Long id, Model model){

        VehiculeDto vehiculeDto = vehiculeService.detailsVehiculeById(id);
        model.addAttribute("vehiculeDto", vehiculeDto);
        model.addAttribute("categories", categorieService.getListCategorie());

        return "gestion_vehicules/modifier_vehicule";
    }

    @PostMapping("/enregistrer_vehicule")
    public String savevehicule(@ModelAttribute VehiculeDto vehiculeDto, Model model) {
        //appel de la couche service ou metier pour injecter un vehicule
        vehiculeService.saveVehicule(vehiculeDto);
        return "redirect:/lister_vehicule";
    }

    @PostMapping("/update_vehicule")
    public String updateehicule(@ModelAttribute VehiculeDto vehiculeDto, Model model) {
        //appel de la couche service ou metier pour injecter un vehicule
        vehiculeService.saveVehicule(vehiculeDto);
        return "redirect:/lister_vehicule";
    }

    @GetMapping("/delete_vehicule")
    public String deleteVehicule(@RequestParam Long id){
        try {
            vehiculeService.supprimerVehicule(id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return "redirect : /lister_vehicule";
    }


}
