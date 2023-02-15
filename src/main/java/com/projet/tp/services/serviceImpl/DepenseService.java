package com.projet.tp.services.serviceImpl;


import com.projet.tp.models.dto.DepenseDto;
import com.projet.tp.models.entitie.Affectation;
import com.projet.tp.models.entitie.Depense;
import com.projet.tp.models.entitie.Utilisateur;
import com.projet.tp.models.entitie.Vehicule;
import com.projet.tp.repositories.AffectationRepository;
import com.projet.tp.repositories.DepenseRepository;
import com.projet.tp.repositories.UtilisateurRepository;
import com.projet.tp.repositories.VehiculeRepository;
import com.projet.tp.services.Iservices.IDepense;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepenseService implements IDepense {

    private ModelMapper mapper  = new ModelMapper();
    @Autowired
    private DepenseRepository depenseRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;
    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Autowired
    private AffectationRepository affectationRepository;
    @Override
    public List<DepenseDto> getListDepense() {

        return depenseRepository.findAll()
                .stream()
                .map(depense -> mapper.map(depense, DepenseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public DepenseDto detailsDepenseById(Long id) throws Exception {
        if(depenseRepository.existsById(id)){
            return mapper.map(depenseRepository.findById(id).get(),DepenseDto.class);

        }else {
            throw new Exception("depense non trouver");
        }

    }

    @Override
    public int saveDepense(DepenseDto depenseDto) {
        return depenseRepository.save(mapper.map(depenseDto,Depense.class)).getId().intValue();
    }

    @Override
    public int supprimerDepense(Long id) throws Exception{
        if(depenseRepository.existsById(id)){
            depenseRepository.deleteById(id);
            return 1;
        }else {
            throw new Exception("Depense non présente");
        }
    }

    @Override
    public int updateDepense(DepenseDto depenseDto) throws Exception{

        if(depenseRepository.existsById(depenseDto.getId())){
             depenseRepository.save(mapper.map(depenseDto,Depense.class)).getId().intValue();
            return 1;
        }else {
            throw new Exception("Depense non présente");
        }
    }

    public List<Depense> getListDepenseByAgent(Long agentId) {
        Utilisateur agent = utilisateurRepository.findById(agentId).get();
        System.out.println("--------------------------------"+agent);

        Affectation affectation = affectationRepository.findAffectationByAgent(agent);

      List<Depense> liste =  depenseRepository.findDepensesByVehiculeAndUtilisateur(affectation.getVehicule(),agent);
        return liste;
    }

}
