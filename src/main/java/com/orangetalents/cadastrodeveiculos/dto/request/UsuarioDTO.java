package com.orangetalents.cadastrodeveiculos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String nome;

    @NotEmpty
    @Size(min = 5, max = 100)
    private String email;

    @NotEmpty
    @CPF
    private String cpf;

    @NotEmpty
    private String dataNascimento;

    private List<VeiculoDTO> veiculos;

}
