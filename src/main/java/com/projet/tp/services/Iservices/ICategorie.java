package com.projet.tp.services.Iservices;

import com.projet.tp.models.dto.CategorieDto;
import com.projet.tp.models.entitie.Categorie;

import java.util.List;

public interface ICategorie {

    List<CategorieDto> getListCategorie();
    CategorieDto detailsCategorieById(Long id);
    void saveCategorie(CategorieDto categorieDto);
    int supprimerCategorie(Long id);
    void updateCategorie(CategorieDto categorieDto);


}
