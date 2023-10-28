package tech.recycle.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import tech.recycle.api.dto.RequestEmpresa;
import tech.recycle.api.model.Empresa;
import tech.recycle.api.model.IEmpresaRepository;

@RestController
@RequestMapping("/empresa")
public class EmpresaControler {
    @Autowired
    private IEmpresaRepository repository;
    @CrossOrigin
    @GetMapping
    public ResponseEntity getAllEmpresa(){
        var allEmpresa = repository.findAll();
        return ResponseEntity.ok(allEmpresa);
    }
    @CrossOrigin
    @PostMapping
    public ResponseEntity creatEmpresa(@RequestBody RequestEmpresa data){
        Empresa Empresa1 = new Empresa(data);
        repository.save(Empresa1);
        System.out.println(data);
        return ResponseEntity.ok().build();
    }
    /**
     * @param data
     * @return
     */
    @PutMapping
    @Transactional
    public ResponseEntity updateEmpresa(@RequestBody RequestEmpresa data){
        Optional<Empresa> optionalEmpresa = repository.findById(data.id());
        if (optionalEmpresa.isPresent()) {
            Empresa empresa = optionalEmpresa.get();
        empresa.setEstabelecimento(data.estabelecimento());
        empresa.setTipoEstabelecimento(data.tipoEstabelecimento());
        empresa.setCnpj(data.cnpj());
        empresa.setEmail(data.email());
        empresa.setSenha(data.senha());
        empresa.setEndereçoEstabelecimento(data.endereçoEstabelecimento());
        return ResponseEntity.ok(empresa);
    }else{
        return ResponseEntity.notFound().build();
    }
}
    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<Void> deleteEmpresa(@PathVariable Long id) {
        try {
            Empresa empresa = repository.findById(id).orElse(null);

            if (empresa == null) {
                return ResponseEntity.notFound().build();
            }

            repository.delete(empresa);

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
