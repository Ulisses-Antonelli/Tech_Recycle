package tech.recycle.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import tech.recycle.api.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Page<Usuario> findAllAllByAtivoTrue(Pageable paginacao);

}
