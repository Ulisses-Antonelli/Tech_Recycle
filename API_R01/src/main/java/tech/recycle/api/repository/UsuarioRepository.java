package tech.recycle.api.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tech.recycle.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Page<Usuario> findAllAllByAtivoTrue(Pageable paginacao);

    @Query(value = "SELECT * FROM usuarios WHERE id = ?1 AND ativo = 1", nativeQuery = true)
    Usuario findByIdWhereAtivoTrue(Long id);

    @Query(value = "SELECT * FROM usuarios WHERE email = ?1 AND password = ?2", nativeQuery = true)
    Optional<Usuario> findByEmailAndSenha(String email, String password);
}
