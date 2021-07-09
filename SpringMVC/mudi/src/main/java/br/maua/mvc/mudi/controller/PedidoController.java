package br.maua.mvc.mudi.controller;

import br.maua.mvc.mudi.dto.RequisicaoNovoPedido;
import br.maua.mvc.mudi.model.Pedido;
import br.maua.mvc.mudi.model.User;
import br.maua.mvc.mudi.repository.PedidoRepository;
import br.maua.mvc.mudi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @Autowired
    private UserRepository userRepository;

    @GetMapping("formulario")
    public String formulario(RequisicaoNovoPedido req) {
        return "pedido/formulario";
    }

    @PostMapping("novo")    // @Valid executa a validação
    public String novo(@Valid RequisicaoNovoPedido req, BindingResult result) {

        if ( result.hasErrors() ) {
            return "pedido/formulario";
        }

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);

        Pedido pedido = req.toPedido();
        pedido.setUser(user);
        pedidoRepository.save(pedido);      // Salvo no banco de dados

        return "redirect:/home";
    }
}
