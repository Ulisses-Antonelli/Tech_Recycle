package tech.recycle.api.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tech.recycle.api.dto.DadosAtualizacaoEmpresa;
import tech.recycle.api.dto.DadosCadastroEmpresa;

@Table(name="Empresa")
@Entity
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Empresa {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	private long id;
	private String estabelecimento;
	private String tipoEstabelecimento;
	private String cnpj;
    private String telefone;
	private boolean ativo;

    @Embedded
    private Endereco endereco;

    @Embedded
    private Credenciais credenciais;
	
    public Empresa(DadosCadastroEmpresa dados){
        this.ativo = true;
        this.estabelecimento = dados.estabelecimento();
        this.tipoEstabelecimento = dados.tipoEstabelecimento();
        this.cnpj = dados.cnpj();
        this.telefone = dados.telefone();
        this.endereco = new Endereco(dados.endereco());
        this.credenciais = new Credenciais(dados.credenciais());
    }

    public void atualizarEmpresa(DadosAtualizacaoEmpresa dados){
        if(dados.estabelecimento() != null){
            this.estabelecimento = dados.estabelecimento();
        }
        if(dados.tipoEstabelecimento() != null){
            this.tipoEstabelecimento = dados.tipoEstabelecimento();
        }
        if(dados.cnpj() != null){
            this.cnpj = dados.cnpj();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.endereco() != null){
            this.endereco = new Endereco(dados.endereco());
        }
    }

    public void excluirEmpresa(){
        this.ativo = false;
    }
}

    
