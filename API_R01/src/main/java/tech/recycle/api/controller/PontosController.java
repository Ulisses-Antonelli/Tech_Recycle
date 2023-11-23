package tech.recycle.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.recycle.api.repository.EmpresaRepository;
import tech.recycle.api.repository.PontosRepository;
import tech.recycle.api.repository.UsuarioRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("pontos")
public class PontosController {
    
    @Autowired
    private PontosRepository repository;

    @Autowired
    private EmpresaRepository empresa_repo;

    @Autowired
    private UsuarioRepository usuario_repo;

    /* 
    @CrossOrigin
    @GetMapping
    public ResponseEntityity<Page<Pontos>> listaTodasTransacoes
    (@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao){
        var page = repository.findAllPromocao(paginacao);

        return ResponseEntity.status(200).body(page);
        
    }
    */
    


}
