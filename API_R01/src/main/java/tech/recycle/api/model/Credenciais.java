package tech.recycle.api.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.recycle.api.dto.DadosCredenciaisUsuario;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Credenciais {

    private String email;
    private String password;

    public Credenciais(DadosCredenciaisUsuario dados) {
        this.email = dados.email();
        this.password = dados.password();
    }

    public void atualizarCredenciais(DadosCredenciaisUsuario dados) {
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.password() != null) {
            this.password = dados.password();
        }
    }
}