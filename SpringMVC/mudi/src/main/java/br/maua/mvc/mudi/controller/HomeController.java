package br.maua.mvc.mudi.controller;

import br.maua.mvc.mudi.model.Pedido;
import br.maua.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class HomeController {

    @Autowired  // Produz uma instância da classe
    private PedidoRepository repository;

    @GetMapping("/home")
    public String home(Model model) {

        List<Pedido> pedidos = repository.recuperarTodosOsPedidos();
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
