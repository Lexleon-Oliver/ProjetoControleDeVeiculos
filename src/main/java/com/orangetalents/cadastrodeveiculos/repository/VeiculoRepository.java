package com.orangetalents.cadastrodeveiculos.repository;

import com.orangetalents.cadastrodeveiculos.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository  extends JpaRepository<Veiculo,Long> {
}
