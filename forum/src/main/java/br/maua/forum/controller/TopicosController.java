package br.maua.forum.controller;

import br.maua.forum.controller.dto.TopicoDTO;
import br.maua.forum.modelo.Curso;
import br.maua.forum.modelo.Topico;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController     // Por padrão, métodos possuem ResponseBody
public class TopicosController {

    @RequestMapping("/topicos")
    public List<TopicoDTO> lista() {
        Topico topico = new Topico("Dúvida", "Dúvida com Spring", new Curso("Spring", "Programação"));

        // Passa objetos e retorna uma lista com esses objetos
        return TopicoDTO.converter(Arrays.asList(topico, topico, topico));
    }
}
