package com.eduardo.HpaeApi.repositories;

import com.eduardo.HpaeApi.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
