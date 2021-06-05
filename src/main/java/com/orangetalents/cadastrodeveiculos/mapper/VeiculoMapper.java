package com.orangetalents.cadastrodeveiculos.mapper;

import com.orangetalents.cadastrodeveiculos.dto.request.VeiculoDTO;
import com.orangetalents.cadastrodeveiculos.entity.Veiculo;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VeiculoMapper {
    VeiculoMapper INSTANCE = Mappers.getMapper(VeiculoMapper.class);

    @Mapping(source = "usuario", target = "usuario.id")

    Veiculo toModel(VeiculoDTO veiculoDTO);

    @Mapping(source = "usuario.id", target = "usuario")
    @Mapping(target = "rodizioAtivo", ignore = true)
    VeiculoDTO toDTO(Veiculo veiculo);

    List<Veiculo> toModel(List<VeiculoDTO> veiculoDTOList);

    List<VeiculoDTO> toDTO(List<Veiculo> veiculoList);
}
