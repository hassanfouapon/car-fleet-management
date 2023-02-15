package com.projet.tp.services.serviceImpl;


import com.projet.tp.models.dto.UtilisateurDto;
import com.projet.tp.models.entitie.Utilisateur;
import com.projet.tp.repositories.UtilisateurRepository;
import com.projet.tp.services.Iservices.IUtilisateur;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UtilisateurService implements IUtilisateur {

    private ModelMapper mapper  = new ModelMapper();

    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Override
    public UtilisateurDto saveUser(UtilisateurDto utilisateurDto) {

        Utilisateur user= maptoEntity(utilisateurDto);
        user.setPassword(encoder.encode(utilisateurDto.getPassword()));
        user.setEtat(Utilisateur.Etat.Inactive);
        utilisateurRepository.save(user);
        return maptoDto(user);
    }

    public UtilisateurDto updateUser(UtilisateurDto utilisateurDto) {

        Utilisateur utilisateur = utilisateurRepository.findById(utilisateurDto.getId()).get();
        Utilisateur user= maptoEntity(utilisateurDto);
        user.setPassword(encoder.encode(utilisateur.getPassword()));
        user.setEtat(Utilisateur.Etat.Inactive);

        utilisateurRepository.save(user);
        return maptoDto(user);
    }
    @Override
    public List<UtilisateurDto> getAgent() {

        return utilisateurRepository.findUtilisateurByRole(Utilisateur.Role.Agent)
                .stream()
                .map(user -> mapper.map(user, UtilisateurDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public int deleteAgent(Long id) throws Exception{
        if(utilisateurRepository.existsById(id)){
            utilisateurRepository.deleteById(id);
            return 1;
        }else {
            throw new Exception("Utilisateur non trouver");
        }
    }

    @Override
    public UtilisateurDto DetailsUser(Long id) throws Exception{

        if(utilisateurRepository.existsById(id)){
            return maptoDto(utilisateurRepository.findById(id).get());
        }else {
            throw new Exception("Utilisateur non trouver");
        }
    }

    @Override
    public UtilisateurDto maptoDto(Utilisateur utilisateur) {
        return mapper.map(utilisateur,UtilisateurDto.class);
    }

    @Override
    public Utilisateur maptoEntity(UtilisateurDto utilisateurDto) {
        return mapper.map(utilisateurDto,Utilisateur.class);
    }

    public  Utilisateur findUserByMail(String email){
        return utilisateurRepository.findByEmail(email);
    }


}
