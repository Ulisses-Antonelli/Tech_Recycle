package tech.recycle.api.model;
import org.apache.catalina.connector.Request;

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
import tech.recycle.api.dto.RequestEmpresa;

@Table(name="Empresa")
@Entity
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Empresa {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private long id;
	private String estabelecimento;
	private String tipoEstabelecimento;
	private String cnpj;
	private String endereçoEstabelecimento;
	private String email;
    private String Senha;
	private boolean statusIncricao;
	
    public Empresa(RequestEmpresa requestproduct){
        this.estabelecimento = requestproduct.estabelecimento();
        this.tipoEstabelecimento = requestproduct.tipoEstabelecimento();
        this.cnpj = requestproduct.cnpj();
        this.endereçoEstabelecimento = requestproduct.endereçoEstabelecimento();
        this.email = requestproduct.email();
        this.Senha = requestproduct.senha();

    }
}

    

