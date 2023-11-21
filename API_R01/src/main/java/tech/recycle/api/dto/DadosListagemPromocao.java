package tech.recycle.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DadosListagemPromocao{
    private Long id;
    private Integer preco;
    private String descricao;
    private String nome_empresa;
    private byte[] foto;

}