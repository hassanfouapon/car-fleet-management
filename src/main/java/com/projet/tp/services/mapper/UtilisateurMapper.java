package com.projet.tp.services.mapper;


import com.projet.tp.models.dto.UtilisateurDto;
import com.projet.tp.models.entitie.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface UtilisateurMapper {

    Utilisateur toEntity(UtilisateurDto utilisateurDto);

    UtilisateurDto toDto(Utilisateur utilisateur);

    void copy(UtilisateurDto utilisateurDto, @MappingTarget Utilisateur utilisateur);
}
