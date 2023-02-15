package com.projet.tp.repositories;


import com.projet.tp.models.entitie.Affectation;
import com.projet.tp.models.entitie.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffectationRepository extends JpaRepository<Affectation, Long> {


    boolean existsById(Long id);

    Affectation findAffectationByAgent(Utilisateur agent);

}
