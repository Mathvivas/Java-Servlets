package br.maua.jsf_pf;

import javax.annotation.ManagedBean;

/**
 *
 * @author matheus
 */
@ManagedBean
public class LivroBean {
    
    private Livro livro = new Livro();
    
    public Livro getLivro() {
        return livro;
    }
    
    public void gravar() {
        System.out.println("Gravando livro " + this.livro.getTitulo());
    }
}
