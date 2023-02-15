package com.projet.tp.services.Iservices;

import com.projet.tp.models.dto.UtilisateurDto;
import com.projet.tp.models.entitie.Utilisateur;

import java.util.List;

public interface IUtilisateur {

    public UtilisateurDto saveUser(UtilisateurDto utilisateurDto);
    public List<UtilisateurDto> getAgent();
    public int deleteAgent(Long id)throws Exception;
    public UtilisateurDto DetailsUser(Long id) throws Exception;
    public UtilisateurDto maptoDto(Utilisateur utilisateur);
    public Utilisateur maptoEntity(UtilisateurDto utilisateurDto);


}
