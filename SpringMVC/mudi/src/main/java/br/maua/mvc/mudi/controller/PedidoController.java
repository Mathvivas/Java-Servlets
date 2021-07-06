package br.maua.mvc.mudi.controller;

import br.maua.mvc.mudi.dto.RequisicaoNovoPedido;
import br.maua.mvc.mudi.model.Pedido;
import br.maua.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("formulario")
    public String formulario() {
        return "pedido/formulario";
    }

    @PostMapping("novo")
    public String novo(RequisicaoNovoPedido req) {

        Pedido pedido = req.toPedido();
        pedidoRepository.save(pedido);      // Salvo no banco de dados

        return "pedido/formulario";
    }
}
