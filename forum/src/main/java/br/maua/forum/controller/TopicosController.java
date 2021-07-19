package br.maua.forum.controller;

import br.maua.forum.controller.dto.TopicoDTO;
import br.maua.forum.modelo.Topico;
import br.maua.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController     // Por padrão, métodos possuem ResponseBody
public class TopicosController {

    @Autowired
    private TopicoRepository topicoRepository;

    @RequestMapping("/topicos")
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
}
