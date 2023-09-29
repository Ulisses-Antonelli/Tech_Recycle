package tech.recycle.api.model;

import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import tech.recycle.api.dto.DadosAtualizacaoPontos;
import tech.recycle.api.dto.DadosCadastroPontos;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pontos {
    
    private Integer qtd_pontos = 0;

    public Pontos(@Valid DadosCadastroPontos dados){
        this.qtd_pontos = dados.qtd_pontos();
    }

    public void atualizarPontos(@Valid DadosAtualizacaoPontos dados){
        if(dados.qtd_pontos() != null && dados.qtd_pontos() >= 0){
            this.qtd_pontos = dados.qtd_pontos();
        }        
    }

    public void deduzirPontos(@Valid DadosAtualizacaoPontos dados){
        if(dados.qtd_pontos() != null && dados.qtd_pontos() >= 0){
            this.qtd_pontos -= dados.qtd_pontos();
        }   
    }

    public void acrescentarPontos(@Valid DadosAtualizacaoPontos dados){
        if(dados.qtd_pontos() != null && dados.qtd_pontos() >= 0){
            this.qtd_pontos += dados.qtd_pontos();
        }   
    }

}
