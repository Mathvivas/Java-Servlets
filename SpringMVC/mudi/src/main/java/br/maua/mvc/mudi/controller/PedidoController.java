package br.maua.mvc.mudi.controller;

import br.maua.mvc.mudi.dto.RequisicaoNovoPedido;
import br.maua.mvc.mudi.model.Pedido;
import br.maua.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido req) {
        return "pedido/formulario";
    }

    @PostMapping("novo")    // @Valid executa a validação
    public String novo(@Valid RequisicaoNovoPedido req, BindingResult result) {

        if ( result.hasErrors() ) {
            return "pedido/formulario";
        }

        Pedido pedido = req.toPedido();
        pedidoRepository.save(pedido);      // Salvo no banco de dados

        return "redirect:/home";
    }
}
