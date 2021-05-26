package br.maua.jsf_pf.bean;

import br.maua.jsf_pf.dao.DAO;
import br.maua.jsf_pf.models.Autor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean @ViewScoped
public class AutorBean {
    
    private Autor autor = new Autor();
    
    private Integer autorId;
    
    public Autor getAutor() {
        return autor;
    }
    
    public List<Autor> getAutores() {
        return new DAO<Autor>(Autor.class).listarTodos();
    }
    
    public String gravar() {
        System.out.println("Gravando autor " + this.autor.getNome());
        
        if (this.autor.getId() == null) {
            new DAO<Autor>(Autor.class).adicionar(this.autor);
        } else {
            new DAO<Autor>(Autor.class).atualizar(this.autor);
        }
        
        this.autor = new Autor();
        
        return "livro?faces-redirect=true";
    }
    
    public void carregar(Autor autor) {
	System.out.println("Carregando autor");
	this.autor = autor;
    }

    public void remover(Autor autor) {
	System.out.println("Removendo autor");
	new DAO<Autor>(Autor.class).remover(autor);
    }

    public Integer getAutorId() {
	return autorId;
    }

    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }
	
    public void carregarAutorPelaId() {
	this.autor = new DAO<Autor>(Autor.class).buscarPorId(autorId);
    }
}
