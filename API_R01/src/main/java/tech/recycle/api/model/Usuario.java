package tech.recycle.api.model;

import java.util.Set;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.recycle.api.dto.DadosAtualizacaoCredenciais;
import tech.recycle.api.dto.DadosAtualizacaoUsuario;
import tech.recycle.api.dto.DadosCadastroUsuario;

@Table(name = "usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String cpf;

    @Enumerated(EnumType.STRING)
    // @EnumValidator(enumClass = Privilegio.class, message =
    // "{user.privilege.invalid}")
    private Privilegio privilegio;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Credenciais credenciais;

    private boolean ativo;

    private Integer quant_pontos;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pontos> listaPontosRecebidos;

    public Usuario(DadosCadastroUsuario dados) {
        this.ativo = true;
        this.quant_pontos = 0;
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.privilegio = dados.privilegio() != null ? dados.privilegio() : Privilegio.USUARIO;
        this.credenciais = new Credenciais(dados.credenciais());
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoUsuario dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.cpf() != null) {
            this.cpf = dados.cpf();
        }
        if (dados.privilegio() != null) {
            this.privilegio = dados.privilegio();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }
    }

    public void atualizarCredenciais(@Valid DadosAtualizacaoCredenciais dados) {

        if (dados.credenciais() != null) {
            this.credenciais.atualizarCredenciais(dados.credenciais());
        }
    }

    public void excluirUsuario() {
        this.ativo = false;
    }
}
