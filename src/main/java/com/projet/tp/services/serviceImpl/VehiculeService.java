package com.projet.tp.services.serviceImpl;


import com.projet.tp.models.dto.VehiculeDto;
import com.projet.tp.models.entitie.Vehicule;
import com.projet.tp.repositories.CategorieRepository;
import com.projet.tp.services.Iservices.IVehicule;
import com.projet.tp.repositories.VehiculeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehiculeService implements IVehicule {

    private ModelMapper mapper  = new ModelMapper();

    @Autowired
    private CategorieRepository categorieRepository;
    @Autowired
    private VehiculeRepository vehiculeRepository;

    @Override
    public List<VehiculeDto> getListVehicule() {

        return vehiculeRepository.findAll()
                .stream()
                .map(vehicule -> mapper.map(vehicule, VehiculeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public VehiculeDto detailsVehiculeById(Long id) {
        Vehicule vehicule = vehiculeRepository.findById(id).get();
        return this.mapper.map(vehicule, VehiculeDto.class);
    }

    @Override
    public void saveVehicule(VehiculeDto VehiculeDto) {

        Vehicule vehicule= mapper.map(VehiculeDto,Vehicule.class);
        //vehicule.setCategorie(categorieRepository.findById(VehiculeDto.getCategorieId()).get());
        vehicule.setEtat(Vehicule.Etat.Libre);
        vehiculeRepository.save(vehicule);
    }

    @Override
    public int supprimerVehicule(Long id) {
        vehiculeRepository.deleteById(id);
        return 1;
    }

    @Override
    public void updateVehicule(VehiculeDto VehiculeDto) {
        Vehicule vehicule= mapper.map(VehiculeDto,Vehicule.class);
        //vehicule.setCategorie(categorieRepository.findById(VehiculeDto.getCategorieId()).get());
        vehicule.setEtat(Vehicule.Etat.Libre);

        vehiculeRepository.save(vehicule);
    }

    @Override
    public List<VehiculeDto> rechercherVehicules(String motcle) {
        List<Vehicule> vehicules = vehiculeRepository.findVehiculeByImmatriculationOrId(motcle, motcle);

        return vehicules.stream().map(vehicule -> mapper.map(vehicule, VehiculeDto.class))
                .collect(Collectors.toList());
    }

    public Vehicule getById(Long id){
        return vehiculeRepository.findById(id).get();
    }



}
