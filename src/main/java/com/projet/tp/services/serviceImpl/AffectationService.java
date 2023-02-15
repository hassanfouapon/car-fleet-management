package com.projet.tp.services.serviceImpl;


import com.projet.tp.models.dto.AffectationDto;
import com.projet.tp.models.entitie.Affectation;
import com.projet.tp.models.entitie.Utilisateur;
import com.projet.tp.models.entitie.Vehicule;
import com.projet.tp.repositories.AffectationRepository;
import com.projet.tp.repositories.UtilisateurRepository;
import com.projet.tp.repositories.VehiculeRepository;
import com.projet.tp.services.Iservices.IAffectation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AffectationService implements IAffectation {

    @Autowired
    private AffectationRepository affectationRepository;

    @Autowired
    private VehiculeRepository vehiculeRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    private ModelMapper mapper  = new ModelMapper();

    @Override
    public List<AffectationDto> getListAffectation() {
        return affectationRepository.findAll()
                .stream()
                .map(affectation -> mapper.map(affectation, AffectationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AffectationDto detailsAffectationById(Long id) throws Exception {
        if(affectationRepository.existsById(id)){
            return this.mapper.map(affectationRepository.findById(id).get(),AffectationDto.class);
        }else {
            throw new Exception("Affectation non trouver");
        }
    }

    @Override
    public int saveAffectation(AffectationDto affectationDto) {
        System.out.println("+++++++++++++++++++++++-------------"+affectationDto.getVehicule().getId());

        Vehicule vehicule = vehiculeRepository.findById(affectationDto.getVehicule().getId()).get();
        Utilisateur utilisateur = utilisateurRepository.findById(affectationDto.getAgent().getId()).get();

        vehicule.setEtat(Vehicule.Etat.Occuper);
        utilisateur.setEtat(Utilisateur.Etat.Active);

        System.out.println(affectationDto.getVehicule().getId());
        vehiculeRepository.save(vehicule);
        utilisateurRepository.save(utilisateur);

        return  affectationRepository.save(this.mapper.map(affectationDto,Affectation.class)).getId().intValue();
    }



    @Override
    public int supprimerAffectation(Long id) throws Exception{
        if(affectationRepository.existsById(id)){
            affectationRepository.deleteById(id);
            return 1;
        }else {
            throw new Exception("Affectation non présente");
        }
    }


    @Override
    public int updateAffectation(AffectationDto affectationDto) throws Exception {

        if(affectationRepository.existsById(affectationDto.getId())){
            return this.mapper.map(affectationDto,Affectation.class).getId().intValue();
        }else {
            throw new Exception("Affectation non présente");
        }
    }

    public AffectationDto findByAgent(Utilisateur agent){
        Affectation affectation = affectationRepository.findAffectationByAgent(agent);
        return mapper.map(affectation,AffectationDto.class);
    }



}
