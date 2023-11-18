package tech.recycle.api.controller;

import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import tech.recycle.api.dto.DadosCadastroPromocao;
import tech.recycle.api.dto.DadosAtualizacaoPromocao;
import tech.recycle.api.dto.DadosListagemPromocao;
import tech.recycle.api.model.Promocao;
import tech.recycle.api.repository.PromocaoRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("promocao")
public class PromocaoController {

    @Autowired
    private PromocaoRepository repository;

    @CrossOrigin
    @GetMapping("buscaPorEmpresa/{id}")
    public ResponseEntity<Page<DadosListagemPromocao>> listarPromocoesDaEmpresa
    (@PathVariable("id") Long id, @PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        var page = repository.findAllPromocaoByEmpresa(id, paginacao);

        return ResponseEntity.status(200).body(page);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Promocao> cadastrarPromocao(@RequestBody @Valid DadosCadastroPromocao dados){
        var promocao = new Promocao(dados);

        return ResponseEntity.status(201).body(promocao);
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<String> excluirPromocao(@PathVariable("id") Long id){
        var promocao = repository.findById(id);

        if(promocao.isPresent()){
            repository.deleteById(id);
        }

        return ResponseEntity.status(201).body("Promocao Excluida Com Sucesso");
    }
}