package tech.recycle.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tech.recycle.api.model.Promocao;

import tech.recycle.api.dto.DadosListagemPromocao;

public interface PromocaoRepository extends JpaRepository<Promocao, Long>{

    @Query(nativeQuery = true, name = "findAllPromocao")
    Page<DadosListagemPromocao> findAllPromocao(Pageable pageable);

    // query está sendo feita e mapeada no "/model/Promocao.java"
    @Query(nativeQuery = true, name = "findAllPromocaoByEmpresa")
    Page<DadosListagemPromocao> findAllPromocaoByEmpresa(Long id, Pageable pageable);
}