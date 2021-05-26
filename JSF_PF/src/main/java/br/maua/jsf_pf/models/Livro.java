package br.maua.jsf_pf.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Livro {
    
    @Id @GeneratedValue
    private Integer id;
    
    private String titulo;
    private String isbn;
    private double preco;
    
    @Temporal(TemporalType.DATE)
    private Calendar dataLancamento = Calendar.getInstance();
    
    @ManyToMany(fetch=FetchType.EAGER)
    private List<Autor> autores = new ArrayList<Autor>();
    
    public List<Autor> getAutores() {
        return autores;
    }
    
    public void adicionarAutor(Autor autor) {
        this.autores.add(autor);
    }
    
    public Integer getId() {
        return id;
    }
    
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String getIsbn() {
        return this.isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    public double getPreco() {
        return this.preco;
    }
    
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public Calendar getDataLancamento() {
        return this.dataLancamento;
    }
    
    public void setDataLancamento(Calendar data) {
        this.dataLancamento = data;
    }
    
    public void removerAutor(Autor autor) {
        this.autores.remove(autor);
    }
}
