package tech.recycle.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import tech.recycle.api.model.Privilegio;

public record DadosCadastroUsuario(

        @NotBlank String nome,

        @NotBlank @Email String email,

        @NotBlank @Pattern(regexp = "\\d{13}") String telefone,

        @NotBlank @Pattern(regexp = "\\d{12}") String cpf,

        @NotNull Privilegio privilegio,

        @NotNull @Valid DadosEnderecoUsuario endereco) {

}
