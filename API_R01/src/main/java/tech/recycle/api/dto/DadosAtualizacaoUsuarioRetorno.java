package tech.recycle.api.dto;

import jakarta.validation.constraints.NotNull;
import tech.recycle.api.model.Endereco;
import tech.recycle.api.model.Privilegio;
import tech.recycle.api.model.Usuario;

public record DadosAtualizacaoUsuarioRetorno(

        @NotNull Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        Privilegio privilegio,
        Endereco endereco) {

    public DadosAtualizacaoUsuarioRetorno(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefone(),
                usuario.getCpf(),
                usuario.getPrivilegio(),
                usuario.getEndereco());
    }
}
