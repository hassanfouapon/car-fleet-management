package com.projet.tp.services.Iservices;

import com.projet.tp.models.dto.DepenseDto;

import java.util.List;

public interface IDepense {


    List<DepenseDto> getListDepense();
    DepenseDto detailsDepenseById(Long id)throws Exception;
    int saveDepense(DepenseDto DepenseDto);
    int supprimerDepense(Long id)throws Exception;
    int updateDepense(DepenseDto DepenseDto)throws Exception;

}
