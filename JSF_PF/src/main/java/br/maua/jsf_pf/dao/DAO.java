package br.maua.jsf_pf.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public class DAO<T> {
    private final Class<T> classe;
    
    public DAO(Class<T> classe) {
        this.classe = classe;
    }
    
    public void adicionar(T t) {
        // Consegue a entity manager
        EntityManager em = new JPAUtil().getEntityManager();
        // Abre transação
        em.getTransaction().begin();
        
        // Persiste o Objeto
        em.persist(t);
        
        // Comita a transação
        em.getTransaction().commit();
        
        // Fecha a entity manager
        em.close();
    }
    
    public void remover(T t) {
        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();
        
        em.remove(em.merge(t));
        
        em.getTransaction().commit();
        em.close();
    }
    
    public void atualizar(T t) {
       EntityManager em = new JPAUtil().getEntityManager();
	em.getTransaction().begin();

	em.merge(t);

	em.getTransaction().commit();
	em.close();
    }
    
    public List<T> listarTodos() {
        EntityManager em = new JPAUtil().getEntityManager();
	CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
	query.select(query.from(classe));

	List<T> lista = em.createQuery(query).getResultList();

	em.close();
	return lista;
    }
    
    public T buscarPorId(Integer id) {
        EntityManager em = new JPAUtil().getEntityManager();
	T instancia = em.find(classe, id);
	em.close();
	return instancia;
    }
    
    public int contarTodos() {
        EntityManager em = new JPAUtil().getEntityManager();
	long result = (Long) em.createQuery("select count(n) from livro n")
			.getSingleResult();
	em.close();

	return (int) result;
    }
    
    public List<T> listarTodosPaginada(int firstResult, int maxResults) {
        EntityManager em = new JPAUtil().getEntityManager();
	CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));

	List<T> lista = em.createQuery(query).setFirstResult(firstResult)
			.setMaxResults(maxResults).getResultList();

	em.close();
	return lista;
    }
}
