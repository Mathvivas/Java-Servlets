package br.maua.mvc.mudi.controller;

import br.maua.mvc.mudi.model.Pedido;
import br.maua.mvc.mudi.model.StatusPedido;
import br.maua.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired  // Produz uma instância da classe
    private PedidoRepository pedidoRepository;

    @GetMapping
    public String home(Model model) {
        Sort sort = Sort.by("dataEntrega").descending();
        PageRequest paginacao = PageRequest.of(0, 2, sort);

        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }

//    @GetMapping("/{status}")
//    public String porStatus(@PathVariable("status") String status, Model model) {
//        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
//        model.addAttribute("pedidos", pedidos);
//        model.addAttribute("status", status);
//        return "home";
//    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/home";
    }
}
