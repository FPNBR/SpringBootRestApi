package br.com.fpnbr.springbootrestapi.repositories;

import br.com.fpnbr.springbootrestapi.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "select u from Usuario u where upper(trim(u.nome)) like %?1%")
    List<Usuario> buscarUsuarioPorNome(String nome);
}
