package tech.recycle.api.dto;


public record RequestEmpresa(Long id, String estabelecimento, String tipoEstabelecimento, String cnpj, String endereçoEstabelecimento, String email, String senha ) {
    
}
