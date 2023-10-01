package tech.recycle.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.recycle.api.model.Cooperativa;

@Repository
public interface CooperativaRepository extends JpaRepository<Cooperativa, Long> {
    
    Page<Cooperativa> findAllAllByAtivoTrue(Pageable paginacao);

}
