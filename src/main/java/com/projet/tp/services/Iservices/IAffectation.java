package com.projet.tp.services.Iservices;

import com.projet.tp.models.dto.AffectationDto;

import java.util.List;

public interface IAffectation {

    List<AffectationDto> getListAffectation();
    AffectationDto detailsAffectationById(Long id)throws Exception;
    int saveAffectation(AffectationDto affectationDto);
    int supprimerAffectation(Long id)throws Exception;
    int updateAffectation(AffectationDto affectationDto)throws Exception;

}
