package tech.recycle.api.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tech.recycle.api.model.Privilegio;
import tech.recycle.api.model.Usuario;
import tech.recycle.api.model.Credenciais;
import tech.recycle.api.model.Eletronicos;
import tech.recycle.api.model.Empresa;
import tech.recycle.api.repository.EletronicosRepository;
import tech.recycle.api.repository.EmpresaRepository;
import tech.recycle.api.repository.UsuarioRepository;
import tech.recycle.api.dto.DadosCadastroEmpresa;
import tech.recycle.api.dto.DadosEnderecoUsuario;
import tech.recycle.api.dto.DadosCredenciaisUsuario;
import tech.recycle.api.dto.DadosCadastroUsuario;

@Configuration
public class LoadDatabase {
    
    @Autowired
    private EletronicosRepository repository;

    @Autowired
    private EmpresaRepository empresa_repo;

    @Autowired
    private UsuarioRepository usuario_repo;

    @Bean
    CommandLineRunner initTabelaEletronicos(){
        return args -> {
            if(repository.findAll().size() == 0){
                Eletronicos e1 = new Eletronicos("Ar Condicionado", 10000);
                Eletronicos e2 = new Eletronicos("Freezer", 10000);
                Eletronicos e3 = new Eletronicos("Geladeira", 8000);
                Eletronicos e4 = new Eletronicos("Máquina de Lavar", 8000);
                Eletronicos e5 = new Eletronicos("Fogão", 8000);
                Eletronicos e6 = new Eletronicos("Televisão", 6000);
                Eletronicos e7 = new Eletronicos("Microondas", 6000);
                Eletronicos e8 = new Eletronicos("Câmera Digital", 1000);
                Eletronicos e9 = new Eletronicos("Aspirador de Pó", 500);
                Eletronicos e10 = new Eletronicos("Ventilador", 500);
                Eletronicos e11 = new Eletronicos("Torradeira", 250);
                Eletronicos e12 = new Eletronicos("Batedeira", 250);
                Eletronicos e13 = new Eletronicos("Mixer", 250);
                Eletronicos e14 = new Eletronicos("Secador de Cabelo", 250);
                Eletronicos e15 = new Eletronicos("Radio", 250);
                Eletronicos e16 = new Eletronicos("Calculadoras", 100);
                Eletronicos e17 = new Eletronicos("Impressora", 5000);
                Eletronicos e18 = new Eletronicos("Computador", 5000);
                Eletronicos e19 = new Eletronicos("Monitor", 5000);
                Eletronicos e20 = new Eletronicos("Notebook", 5000);
                Eletronicos e21 = new Eletronicos("Celular", 2500);
                Eletronicos e22 = new Eletronicos("Telefone", 2500);
                Eletronicos e23 = new Eletronicos("Bateria 60Ah", 4000);
                Eletronicos e24 = new Eletronicos("Bateira de Moto", 2000);
                Eletronicos e25 = new Eletronicos("Pilha Modelo C/D", 100);
                Eletronicos e26 = new Eletronicos("Bateria 9V", 100);
                Eletronicos e27 = new Eletronicos("Pilha Modelo AA/AAA", 50);

                repository.saveAll(Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14,
                                                e15, e16, e17, e18, e19, e20, e21, e22, e23, e24, e25, e26, e27));
            }

            // Empresa 
            if(empresa_repo.findAll().size() == 0){
                DadosEnderecoUsuario enderec = new DadosEnderecoUsuario("Rua 123", "Jardim Direita", "23232344","22","Loja","São Paulo", "SP");
                Credenciais credenc = new Credenciais("Lucas@gmail.com", "12345678");
                byte[] foto = null;

                DadosCadastroEmpresa dto1 = new DadosCadastroEmpresa("Lucas Calçados", 
                                                                    "Calçados", 
                                                                    "06057223000171", 
                                                                    "11951441190", 
                                                                    foto, 
                                                                    enderec, 
                                                                    credenc);

                Empresa empresa = new Empresa(dto1, credenc);
                empresa_repo.save(empresa);
            }

            //  Usuario
            if(usuario_repo.findAll().size() == 0){
                DadosEnderecoUsuario enderec = new DadosEnderecoUsuario("Rua 123", "Jardim Direita", "23232344","22","Loja","São Paulo", "SP");
                Credenciais credenc = new Credenciais("Lucas@gmail.com", "12345678");

                DadosCadastroUsuario dto2 = new DadosCadastroUsuario("Ulisses Antonelli", 
                                                                    "951441190", 
                                                                    "91319218920", 
                                                                    Privilegio.USUARIO, 
                                                                    credenc, 
                                                                    enderec);

                Usuario usuario = new Usuario(dto2, credenc);
                usuario_repo.save(usuario);

            }
                
        };
    }
}
