package br.maua.forum.controller;

import br.maua.forum.controller.dto.DetalhesDoTopicoDTO;
import br.maua.forum.controller.dto.TopicoDTO;
import br.maua.forum.controller.form.AtualizacaoTopicoForm;
import br.maua.forum.controller.form.TopicoForm;
import br.maua.forum.modelo.Topico;
import br.maua.forum.repository.CursoRepository;
import br.maua.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController     // Por padrão, métodos possuem ResponseBody
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<TopicoDTO> listar(String nomeCurso) {
        if ( nomeCurso == null ) {
            List<Topico> topicos = topicoRepository.findAll();
            // Passa objetos e retorna uma lista com esses objetos
            return TopicoDTO.converter(topicos);
        } else {
            // localhost:8080/topicos?nomeCurso=Spring+Boot
            List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
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