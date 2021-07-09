package br.maua.mvc.mudi.repository;

import br.maua.mvc.mudi.model.Pedido;
import br.maua.mvc.mudi.model.StatusPedido;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository                              // Classe que está lidando e o id dessa classe
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    @Cacheable("books")
    List<Pedido> findByStatus(StatusPedido status, Pageable pageable);

    @Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :username")
    List<Pedido> findAllByUsuario(@Param("username")String username);

    @Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :username AND p.status = :status")
    List<Pedido> findByStatusEUsuario(@Param("status")StatusPedido status, @Param("username")String username);
}
