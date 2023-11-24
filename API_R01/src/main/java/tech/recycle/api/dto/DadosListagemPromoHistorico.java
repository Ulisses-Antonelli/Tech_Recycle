package tech.recycle.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DadosListagemPromoHistorico {
    private Long id;
    private String nome_usuario;
    private Integer preco;
    private String descricao;
    private String nome_empresa;
    private byte[] foto;
    private Boolean ativo;
}
