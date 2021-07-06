package br.maua.mvc.mudi.repository;

import br.maua.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PedidoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Pedido> recuperarTodosOsPedidos() {
        Query query = entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class);
        return query.getResultList();
    }
}
