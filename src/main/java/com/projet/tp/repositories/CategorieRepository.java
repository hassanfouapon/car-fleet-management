package com.projet.tp.repositories;


import com.projet.tp.models.entitie.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

    boolean existsById(Long id);
}
