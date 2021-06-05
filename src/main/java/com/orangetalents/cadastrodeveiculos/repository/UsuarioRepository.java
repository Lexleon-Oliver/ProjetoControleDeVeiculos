package com.orangetalents.cadastrodeveiculos.repository;

import com.orangetalents.cadastrodeveiculos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
