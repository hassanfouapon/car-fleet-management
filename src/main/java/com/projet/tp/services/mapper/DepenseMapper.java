package com.projet.tp.services.mapper;


import com.projet.tp.models.dto.DepenseDto;
import com.projet.tp.models.entitie.Depense;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, nullValueCheckStrategy =  NullValueCheckStrategy.ALWAYS)
public interface DepenseMapper {

    Depense toEntity(DepenseDto depenseDto);

    DepenseDto toDto(Depense depense);

    void copy(DepenseDto depenseDto, @MappingTarget Depense depense);
}
