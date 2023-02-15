package com.projet.tp.repositories;


import com.projet.tp.models.entitie.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long> {

    Optional<Vehicule> findVehiculeByImmatriculation(String immatriculation);

    List<Vehicule> findVehiculeByImmatriculationOrId(String motcle0, String motcle1);

}
