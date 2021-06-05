package com.orangetalents.cadastrodeveiculos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VeiculoDTO {

    private Long id;

    @NotEmpty
    private String tipo;

    @NotEmpty
    private String marca;

    @NotEmpty
    private String modelo;

    @NotEmpty
    private String ano;


    private String valor;

    private String diaRodizio;

    private Boolean rodizioAtivo;

    private Long usuario;

}
