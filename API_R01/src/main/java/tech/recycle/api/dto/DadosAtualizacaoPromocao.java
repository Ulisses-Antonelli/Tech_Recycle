package tech.recycle.api.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPromocao(
    @NotNull Long id,
    @NotBlank String descricao,
    @NotNull Float preco,
    @NotBlank LocalDate data_criacao
) 
{}
