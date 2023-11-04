package tech.recycle.api.dto;

import tech.recycle.api.model.Privilegio;
import tech.recycle.api.model.Usuario;

public record DadosListagemUsuario(
        Long id,
        String nome,
        String cpf,
        String email,
        Privilegio privilegio) {

    public DadosListagemUsuario(Usuario usuario) {
        this(
                usuario.getId(),
                usuario.getNome(),
                usuario.getCpf(),
                usuario.getCredenciais().getEmail(),
                usuario.getPrivilegio());
    }
}
