package com.projet.tp.services.mapper;


import com.projet.tp.models.dto.CategorieDto;
import com.projet.tp.models.entitie.Categorie;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface CategorieMapper {

    Categorie toEntity(CategorieDto CategorieDto);

    CategorieDto toDto(Categorie Categorie);

    void copy(CategorieDto CategorieDto, @MappingTarget Categorie Categorie);
}
