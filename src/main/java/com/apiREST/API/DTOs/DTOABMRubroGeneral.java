package com.apiREST.API.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTOABMRubroGeneral {
    private String rubro;
    private String rubroPadre;
    private String estado;
}
