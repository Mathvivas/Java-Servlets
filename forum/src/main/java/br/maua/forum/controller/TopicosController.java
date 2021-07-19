package br.maua.forum.controller;

import br.maua.forum.controller.dto.TopicoDTO;
import br.maua.forum.controller.form.TopicoForm;
import br.maua.forum.modelo.Topico;
import br.maua.forum.repository.CursoRepository;
import br.maua.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

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
    // RequestBody pegará no corpo, não na URL
    public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
        Topico topico = form.converter(cursoRepository);
        topicoRepository.save(topico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new TopicoDTO(topico));
    }
}
