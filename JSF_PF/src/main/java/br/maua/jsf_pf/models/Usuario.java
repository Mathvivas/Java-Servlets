package br.maua.jsf_pf.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Usuario {
    
    private static final long serialVersonUID = 1L;
    
    @Id @GeneratedValue
    private Integer id;
    private String email;
    private String senha;
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
	this.id = id;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }
	
    public String getSenha() {
	return senha;
    }

    public void setSenha(String senha) {
	this.senha = senha;
    }
}
