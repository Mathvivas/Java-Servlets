package br.maua.jsf_pf;

/**
 *
 * @author matheus
 */
public class Livro {
    
    private String titulo;
    private String isbn;
    private double preco;
    private String dataLancamento;
    
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
    
    public String getData() {
        return this.dataLancamento;
    }
    
    public void setData(String data) {
        this.dataLancamento = data;
    }
}
