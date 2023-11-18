package tech.recycle.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DadosListagemPromocao{
    private Long id;
    private Float preco;
    private String descricao;
    private String nome_empresa;
    private byte[] foto;
}