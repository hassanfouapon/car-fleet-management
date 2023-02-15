package com.projet.tp.repositories;


import com.projet.tp.models.entitie.Depense;
import com.projet.tp.models.entitie.Utilisateur;
import com.projet.tp.models.entitie.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepenseRepository extends JpaRepository<Depense, Long> {

    boolean existsById(Long id);

    List<Depense> findDepensesByVehiculeAndUtilisateur(Vehicule vehicule, Utilisateur agent);

}
