package tech.recycle.api.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import tech.recycle.api.model.Empresa;

public record DadosCadastroPromocao(
    @NotBlank Float preco,
    @NotBlank String descricao,
    @NotBlank LocalDate data_criacao,
    @NotBlank Empresa empresa_criadora
) 
{}
