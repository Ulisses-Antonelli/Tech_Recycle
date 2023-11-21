package tech.recycle.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.recycle.api.model.Eletronicos;

public interface EletronicosRepository extends JpaRepository<Eletronicos, Long>{
    
}
