package tech.recycle.api.dto;

import jakarta.validation.constraints.NotNull;
import tech.recycle.api.model.Privilegio;

public record DadosAtualizacaoUsuario(

        @NotNull Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        Privilegio privilegio,
        DadosEnderecoUsuario endereco) {

}
