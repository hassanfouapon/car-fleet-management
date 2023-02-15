package com.projet.tp.presentation.controller;

import com.projet.tp.models.dto.AffectationDto;
import com.projet.tp.models.dto.VehiculeDto;
import com.projet.tp.services.serviceImpl.AffectationService;
import com.projet.tp.services.serviceImpl.UtilisateurService;
import com.projet.tp.services.serviceImpl.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AffectationController {

    @Autowired
    private VehiculeService vehiculeService;

    @Autowired
    private UtilisateurService agentService;

    @Autowired
    private AffectationService affectationService;
    @GetMapping("/consulter_affectation")
    public String consulterAffectation( Model model) {

        //appel de la couche service pour avoir la liste des affectations

        model.addAttribute("affectationDtos",affectationService.getListAffectation());
        return "affectation/lister_affectation";
    }

    @GetMapping("/enregistrer_affectation")
    public String enregistrer() {


        return "affectation/enregistrerAffectation";
    }

    @GetMapping("/form_affectation")
    public String form_affectation(@RequestParam(name="id") Long id, Model model) throws Exception{

        AffectationDto affectationDto = new AffectationDto();

        affectationDto.setVehicule(vehiculeService.getById(id));

        //System.out.println("first=-------------------"+vehiculeService.getById(id));
        model.addAttribute("affectation", affectationDto);
        model.addAttribute("agents", agentService.getAgent());

        return "affectation/affecter_vehicule";
    }

    @PostMapping("/save_affectation")
    public String save_affectation(@ModelAttribute AffectationDto affectationDto) {

        System.out.println("-------=======----"+affectationDto.getVehicule().getId());

        System.out.println("==============-----------"+affectationDto.getAgent().getId());
        affectationService.saveAffectation(affectationDto);

        return "redirect:/consulter_affectation";
    }



}
