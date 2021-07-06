package br.maua.mvc.mudi.controller;

import br.maua.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto("Xiaomi Note 8");
        pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/51wgmCYDFML._AC_SL1000_.jpg");
        pedido.setUrlProduto("https://www.amazon.com.br/Celular-Xiaomi-Vers%C3%A3o-Global-Space/dp/B07Y9ZHLXW/ref=asc_df_B07Y9ZHLXW/?tag=googleshopp00-20&linkCode=df0&hvadid=379773236150&hvpos=&hvnetw=g&hvrand=11446632447533449597&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1001773&hvtargid=pla-825774000605&psc=1");
        pedido.setDescricao("Celular Xiaomi Note 8");

        List<Pedido> pedidos = Arrays.asList(pedido);
        model.addAttribute("pedidos", pedidos);
        return "home";
    }
}
