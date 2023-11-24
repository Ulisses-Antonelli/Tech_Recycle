package tech.recycle.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tech.recycle.api.model.PromocaoUsuario;

public interface PromocaoUsuarioRepository extends JpaRepository<PromocaoUsuario, Long>{
    
    //@Query(nativeQuery = true)
}
