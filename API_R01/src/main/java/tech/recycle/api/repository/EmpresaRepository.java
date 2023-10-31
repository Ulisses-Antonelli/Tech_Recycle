package tech.recycle.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import tech.recycle.api.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    Page<Empresa> findAllAllByAtivoTrue(Pageable paginacao);
}
