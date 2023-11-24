package tech.recycle.api.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "PromocaoUsuario")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PromocaoUsuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "promocao_id", nullable = false)
    private Promocao promocao;

    private LocalDate data_compra;

    private Boolean ativo;

    public PromocaoUsuario(Promocao promocao, 
                            Usuario usuario,
                            LocalDate data_compra){
        this.usuario = usuario;
        this.promocao = promocao;
        this.data_compra = data_compra;
        this.ativo = true;
    }

    public void DesativarPromocao(){
        this.ativo = false;
    }
}
