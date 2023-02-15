package com.projet.tp.services.mapper;


import com.projet.tp.models.dto.VehiculeDto;
import com.projet.tp.models.entitie.Vehicule;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface VehiculeMapper {

    Vehicule toEntity(VehiculeDto vehiculeDto);

    VehiculeDto toDto(Vehicule vehicule);

    void copy(VehiculeDto vehiculeDto, @MappingTarget Vehicule vehicule);
}
