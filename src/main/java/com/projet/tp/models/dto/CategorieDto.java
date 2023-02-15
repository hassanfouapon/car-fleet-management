package com.projet.tp.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategorieDto {

    private Long id;
    private String libele;
    private String description;

}
