package br.maua.mvc.mudi.repository;

import br.maua.mvc.mudi.model.Pedido;
import br.maua.mvc.mudi.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository                              // Classe que está lidando e o id dessa classe
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatus(StatusPedido status);
}
