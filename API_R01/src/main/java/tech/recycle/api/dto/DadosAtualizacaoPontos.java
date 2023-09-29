package tech.recycle.api.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosAtualizacaoPontos(
    @NotBlank Integer qtd_pontos
) 
{}
