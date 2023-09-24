package tech.recycle.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.validation.Valid;

import tech.recycle.api.dto.DadosCadastroUsuario;
import tech.recycle.api.dto.DadosCadastroUsuarioRetorno;
import tech.recycle.api.dto.DadosListagemUsuario;
import tech.recycle.api.dto.DadosAtualizacaoUsuario;
import tech.recycle.api.dto.DadosAtualizacaoUsuarioRetorno;
import tech.recycle.api.model.Usuario;
import tech.recycle.api.repository.UsuarioRepository;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dados, UriComponentsBuilder uriBuilder) {

        var usuario = new Usuario(dados);
        repository.save(usuario);

        var URI = uriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(URI).body(new DadosCadastroUsuarioRetorno(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuario>> listar(
            @PageableDefault(size = 10, sort = { "id" }) Pageable paginacao) {
        var page = repository.findAllAllByAtivoTrue(paginacao).map(DadosListagemUsuario::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity ExibirUsuarioPorId(@PathVariable Long id) {
        var usuario = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosAtualizacaoUsuarioRetorno(usuario));
        // repository.deleteById(id);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoUsuario dados) {

        var usuario = repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosAtualizacaoUsuarioRetorno(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var usuario = repository.getReferenceById(id);
        usuario.excluirUsuario();

        return ResponseEntity.noContent().build();
        // repository.deleteById(id);
    }
}
