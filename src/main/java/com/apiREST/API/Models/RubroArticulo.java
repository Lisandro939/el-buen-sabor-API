package com.apiREST.API.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "rubroArticulo")
public class RubroArticulo extends BaseEntidad {

    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "rubroArticulo_id", referencedColumnName = "id")
    @Builder.Default
    private List<RubroArticulo> rubroArticulo = new ArrayList<>();

    public void agregarRubroArticulo(RubroArticulo rubroArticulo) {
        this.rubroArticulo.add(rubroArticulo);
    }

}
