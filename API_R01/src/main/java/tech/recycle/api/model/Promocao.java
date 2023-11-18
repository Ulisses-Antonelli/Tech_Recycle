package tech.recycle.api.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.recycle.api.dto.DadosAtualizacaoPromocao;
import tech.recycle.api.dto.DadosCadastroPromocao;
import tech.recycle.api.dto.DadosListagemPromocao;

@NamedNativeQuery(
    name = "findAllPromocaoByEmpresa",
    query = "SELECT p.id, p.preco, p.descricao, e.estabelecimento AS nome_empresa, e.foto"+
            "FROM Promocao p "+
            "INNER JOIN Empresa e "+
            "ON p.empresa_criadora = e.id"+
            "WHERE p.empresa_criadora = :idEmpresa"+
            "ORDER BY p.quant_vendidos DESC",
    resultClass = DadosListagemPromocao.class,
    resultSetMapping = "DadosListagemPromocao_mapping"
)
@SqlResultSetMapping(
    name = "DadosListagemPromocao_mapping",
    classes = {
        @ConstructorResult (
            targetClass = DadosListagemPromocao.class,
            columns = {
                @ColumnResult(name = "id", type = Long.class),
                @ColumnResult(name = "preco", type = String.class),
                @ColumnResult(name = "descricao", type = String.class),
                @ColumnResult(name = "nome_empresa", type = String.class),
                @ColumnResult(name = "foto", type = byte[].class)
            }
        )
    }
)
@Table(name = "Promocao")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Promocao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float preco;
    private String descricao;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonProperty("data_criacao")
    @Column(nullable = false)
    private LocalDate data_criacao;

    private Integer quant_vendidos;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa_criadora;

    public Promocao(DadosCadastroPromocao dados){
        this.preco = dados.preco();
        this.descricao = dados.descricao();
        this.data_criacao = dados.data_criacao();
        this.quant_vendidos = 0;
        this.empresa_criadora = dados.empresa_criadora();
    }

    public void atualizarPromocao(@Valid DadosAtualizacaoPromocao dados){
        if(dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if(dados.preco() != null){
            this.preco = dados.preco();
        }
        if(dados.data_criacao() != null){
            this.data_criacao = dados.data_criacao();
        }
    }
}
