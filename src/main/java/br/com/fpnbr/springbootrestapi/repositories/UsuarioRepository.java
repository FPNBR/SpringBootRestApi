package br.com.fpnbr.springbootrestapi.repositories;

import br.com.fpnbr.springbootrestapi.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
