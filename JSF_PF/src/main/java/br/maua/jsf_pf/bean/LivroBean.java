package br.maua.jsf_pf.bean;

import br.maua.jsf_pf.dao.DAO;
import br.maua.jsf_pf.models.Livro;
import br.maua.jsf_pf.models.Autor;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

@ManagedBean @ViewScoped
public class LivroBean {
    
    private static final long serialVersionUID = 1L;
    
    private Livro livro = new Livro();
    
    private Integer autorId;
    
    private Integer livroId;
    
    public void setAutorId(Integer autorId) {
        this.autorId = autorId;
    }
    
    public Integer getAutorId() {
        return autorId;
    }
    
    public Livro getLivro() {
        return livro;
    }
    
    public Integer getLivroId() {
        return livroId;
    }
    
    public void setLivroId(Integer livroId) {
        this.livroId = livroId;
    }
    
    public List<Livro> getLivros() {
        return new DAO<Livro>(Livro.class).listarTodos();
    }
    
    public List<Autor> getAutores() {
	return new DAO<Autor>(Autor.class).listarTodos();
    }

    public List<Autor> getAutoresDoLivro() {
	return this.livro.getAutores();
    }
    
    public void gravarAutor() {
	Autor autor = new DAO<Autor>(Autor.class).buscarPorId(this.autorId);
	this.livro.adicionarAutor(autor);
	System.out.println("Escrito por: " + autor.getNome());
    }
    
    public void gravar() {
        System.out.println("Gravando livro " + this.livro.getTitulo());
        
        if (livro.getAutores().isEmpty()) {
            FacesContext.getCurrentInstance().addMessage("autor", 
                    new FacesMessage("Livro deve ter pelo menos um Autor!"));
        }
        
        if (this.livro.getId() == null) {
            new DAO<Livro>(Livro.class).adicionar(this.livro);
        } else {
            new DAO<Livro>(Livro.class).atualizar(this.livro);
        }
        
        this.livro = new Livro();
    }
    
    public void carregar(Livro livro) {
        System.out.println("Carregando livro " + livro.getTitulo());
        this.livro = livro;
    }
    
    public void remover(Livro livro) {
        System.out.println("Removendo livro " + livro.getTitulo());
        new DAO<Livro>(Livro.class).remover(livro);
    }
    
    public void removerAutorDoLivro(Autor autor) {
        this.livro.removerAutor(autor);
    }
    
    public String formAutor() {
        System.out.println("Chamanda do formulário do Autor.");
        return "autor?faces-redirect=true";
    }
    
    public void comecaComDigitoUm(FacesContext fc, UIComponent component, Object value) throws ValidatorException {
        String valor = value.toString();
        if (!valor.startsWith("1")) {
            throw new ValidatorException(new FacesMessage("ISBN deveria começar com 1"));
        }
    }
    
    public void carregarLivroPeloId() {
        this.livro = new DAO<Livro>(Livro.class).buscarPorId(livroId);
    }
}
