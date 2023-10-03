package com.apiREST.API.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "rubroGeneral")
public class RubroGeneral extends BaseEntidad {

    private String denominacion;

}
