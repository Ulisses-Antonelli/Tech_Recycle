package tech.recycle.api.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tech.recycle.api.model.Promocao;

import tech.recycle.api.dto.DadosListagemPromocao;

public interface PromocaoRepository extends JpaRepository<Promocao, Long>{

    // query está sendo feita e mapeada no "/model/Promocao.java"
    @Query(nativeQuery = true, name = "findPromocaoByEmpresa")
    Optional<List<DadosListagemPromocao>> findAllEstudantesWithCurso();
}