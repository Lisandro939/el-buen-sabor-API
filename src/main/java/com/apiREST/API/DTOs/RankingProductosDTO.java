package com.apiREST.API.DTOs;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class RankingProductosDTO {

    private Long id;

    private String denominacion;

    private BigDecimal cantidad;
}
