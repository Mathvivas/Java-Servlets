package br.maua.forum.controller;

import br.maua.forum.controller.dto.DetalhesDoTopicoDTO;
import br.maua.forum.controller.dto.TopicoDTO;
import br.maua.forum.controller.form.AtualizacaoTopicoForm;
import br.maua.forum.controller.form.TopicoForm;
import br.maua.forum.modelo.Topico;
import br.maua.forum.repository.CursoRepository;
import br.maua.forum.repository.TopicoRepository;

import java.net.URI;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController     // Por padrão, métodos possuem ResponseBody
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping                 // Parâmetros de URL (default = obrigatório)
    public Page<TopicoDTO> listar(@RequestParam(required = false) String nomeCurso,
                                  @PageableDefault(sort="id", direction= Sort.Direction.ASC, size=2)
                                          Pageable paginacao) {

        // http://localhost:8080/topicos?page=0&size=3&sort=id,asc

        if ( nomeCurso == null ) {
            Page<Topico> topicos = topicoRepository.findAll(paginacao);
            // Passa objetos e retorna uma lista com esses objetos
            return TopicoDTO.converter(topicos);
        } else {
            // localhost:8080/topicos?nomeCurso=Spring+Boot
            Page<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso, paginacao);
            return TopicoDTO.converter(topicos);
        }
    }

    @PostMapping
    @Transactional
    // RequestBody pegará no corpo, não na URL
    public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesDoTopicoDTO> detalhar(@PathVariable Long id) {
        // Pode ser que retorne algo e pode ser que não retorne
        Optional<Topico> optional = topicoRepository.findById(id);
        if ( optional.isPresent() ) {
            return ResponseEntity.ok(new DetalhesDoTopicoDTO(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional          // Efetuar commit da transação
    public ResponseEntity<TopicoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form) {
        Optional<Topico> optional = topicoRepository.findById(id);
        if (optional.isPresent()) {
            Topico topico = form.atualizar(id, topicoRepository);
            return ResponseEntity.ok(new TopicoDTO(topico));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Topico> optional = topicoRepository.findById(id);
        if (optional.isPresent()) {
            topicoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
}