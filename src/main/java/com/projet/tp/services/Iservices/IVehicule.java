package com.projet.tp.services.Iservices;

import com.projet.tp.models.dto.VehiculeDto;

import java.util.List;

public interface IVehicule {
    List<VehiculeDto> getListVehicule();
    VehiculeDto detailsVehiculeById(Long id);
    void saveVehicule(VehiculeDto VehiculeDto);
    int supprimerVehicule(Long id);
    void updateVehicule(VehiculeDto VehiculeDto);

    List<VehiculeDto> rechercherVehicules(String motcle);

    //List<VehiculeDto> rechercherVehicules(String motcle);
}
