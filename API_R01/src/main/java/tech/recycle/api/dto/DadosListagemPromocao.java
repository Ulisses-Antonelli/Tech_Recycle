package tech.recycle.api.dto;

import jakarta.validation.constraints.NotBlank;
import tech.recycle.api.model.Promocao;

public record DadosListagemPromocao(
    Long id,
    @NotBlank Float preco,
    @NotBlank String descricao,
    @NotBlank String nome_empresa,
    @NotBlank byte[] foto

){
    public DadosListagemPromocao(Promocao promocao){
        this(
            promocao.getId(),
            promocao.getPreco(),
            promocao.getDescricao(),
            promocao.getEmpresa_criadora(),
            promocao.get
        )
    }
}