package tech.recycle.api.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroPontos(
    @NotBlank Integer qtd_pontos
) 
{}
