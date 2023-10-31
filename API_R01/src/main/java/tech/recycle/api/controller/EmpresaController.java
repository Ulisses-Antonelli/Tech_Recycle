package tech.recycle.api.controller;

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
import tech.recycle.api.dto.DadosAtualizacaoEmpresa;
import tech.recycle.api.dto.DadosCadastroEmpresa;
import tech.recycle.api.dto.DadosListagemEmpresa;
import tech.recycle.api.model.Empresa;
import tech.recycle.api.repository.EmpresaRepository;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    private EmpresaRepository repository;

    @CrossOrigin
    @GetMapping
    public ResponseEntity<Page<DadosListagemEmpresa>> listarTodasEmpresas
    (@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        var page = repository.findAllAllByAtivoTrue(paginacao).map(DadosListagemEmpresa::new);

        return ResponseEntity.status(200).body(page);
    }

    @CrossOrigin
    @GetMapping("{id}")
    public ResponseEntity acharCooperativaPorId(@PathVariable("id") Long id){
        var cooperativa = repository.findById(id).get();

        return ResponseEntity.status(200).body(cooperativa);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity creatEmpresa(@RequestBody @Valid DadosCadastroEmpresa data){
        Empresa Empresa1 = new Empresa(data);
        repository.save(Empresa1);
        System.out.println(data);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin
    @PutMapping
    @Transactional
    public ResponseEntity updateEmpresa(@RequestBody DadosAtualizacaoEmpresa data){
        Optional<Empresa> optionalEmpresa = repository.findById(data.id());
        if (optionalEmpresa.isPresent()) {
            var empresa = optionalEmpresa.get();
            empresa.atualizarEmpresa(data);

            return ResponseEntity.ok().body("Cadastrado com sucesso");
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<String> deleteEmpresa(@PathVariable Long id) {
        try {
            Empresa empresa = repository.findById(id).get();
            empresa.excluirEmpresa();

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}