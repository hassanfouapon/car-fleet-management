package com.projet.tp.services.serviceImpl;


import com.projet.tp.models.dto.CategorieDto;
import com.projet.tp.models.entitie.Categorie;
import com.projet.tp.repositories.CategorieRepository;
import com.projet.tp.services.Iservices.ICategorie;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategorieService implements ICategorie {

    private ModelMapper mapper  = new ModelMapper();
    @Autowired
    private CategorieRepository categorieRepository;

    @Override
    public List<CategorieDto> getListCategorie() {

        return categorieRepository.findAll()
                .stream()
                .map(categorie -> mapper.map(categorie, CategorieDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategorieDto detailsCategorieById(Long id) {
       Categorie categorie =  categorieRepository.findById(id).get();
        return this.mapper.map(categorie,CategorieDto.class);
    }

    @Override
    public void saveCategorie(CategorieDto categorieDto) {

        Categorie categorie= mapper.map(categorieDto,Categorie.class);
        categorieRepository.save(categorie);
    }


    @Override
    public int supprimerCategorie(Long id) {
        categorieRepository.deleteById(id);
        return 1;
    }

    @Override
    public void updateCategorie(CategorieDto categorieDto) {
        Categorie categorie= mapper.map(categorieDto,Categorie.class);
        categorieRepository.save(categorie);
    }

}
