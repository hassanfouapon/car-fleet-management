package com.projet.tp.services.mapper;


import com.projet.tp.models.dto.AffectationDto;
import com.projet.tp.models.entitie.Affectation;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface AffectationMapper {

    Affectation toEntity(AffectationDto affectationDto);

    AffectationDto toDto(Affectation affectation);

    void copy(AffectationDto affectationDto, @MappingTarget Affectation affectation);
}
