package com.orangetalents.cadastrodeveiculos.repository;

import com.orangetalents.cadastrodeveiculos.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    @Query( "SELECT u FROM Usuario u WHERE u.cpf = ?1")
    Optional<Usuario> findUsuarioByCpf(String cpf);

    @Query("SELECT u FROM Usuario u WHERE u.email = ?1")
    Optional<Usuario> findUsuarioByEmail(String email);
}
