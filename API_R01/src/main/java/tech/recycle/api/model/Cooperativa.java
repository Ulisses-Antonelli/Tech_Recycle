package tech.recycle.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.recycle.api.dto.DadosAtualizacaoCooperativa;
import tech.recycle.api.dto.DadosCadastroCooperativa;

@Entity
@Table(name = "Cooperativa")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cooperativa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cnpj;
    private Endereco endereco;
    private boolean ativo;

    public Cooperativa(DadosCadastroCooperativa dados){
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cnpj = dados.cnpj();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(@Valid DadosAtualizacaoCooperativa dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }   
        if(dados.email() != null){
            this.email = dados.email();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }   
        if(dados.cnpj() != null){
            this.cnpj = dados.cnpj();
        }
        if(dados.endereco() != null){
            this.endereco = new Endereco(dados.endereco());
        }
    }

    public void excluirCooperativa(){
        this.ativo = false;
    }
}