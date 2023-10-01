package tech.recycle.api.dto;

import tech.recycle.api.model.Cooperativa;

public record DadosListagemCooperativa(
    Long id,
    String nome,
    String email,
    String cpf
){
    public DadosListagemCooperativa(Cooperativa cooperativa){
        this(
            cooperativa.getId(),
            cooperativa.getNome(),
            cooperativa.getEmail(),
            cooperativa.getCnpj()
        );
    }
}
