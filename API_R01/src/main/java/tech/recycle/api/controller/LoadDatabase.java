package tech.recycle.api.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tech.recycle.api.model.Eletronicos;
import tech.recycle.api.repository.EletronicosRepository;

@Configuration
public class LoadDatabase {
    
    @Autowired
    private EletronicosRepository repository;

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
                
        };
    }
}
