package com.projet.tp.repositories;

import com.projet.tp.models.entitie.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

    Utilisateur findByEmail(String username);

    boolean existsById(Long id);

    List<Utilisateur> findUtilisateurByRole(Utilisateur.Role role);

}
