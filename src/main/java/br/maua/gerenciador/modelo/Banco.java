package br.maua.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> usuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		lista.add(empresa);
		lista.add(empresa2);
		
		Usuario user1 = new Usuario();
		user1.setLogin("Nico");
		user1.setSenha("12345");
		Usuario user2 = new Usuario();
		user2.setLogin("Ana");
		user2.setSenha("54321");
		Usuario user3 = new Usuario();
		user3.setLogin("Matheus");
		user3.setSenha("senha");
		
		usuarios.add(user1);
		usuarios.add(user2);
		usuarios.add(user3);
	}
	
	public void adicionar(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}

	public List<Empresa> getEmpresas() {
		return Banco.lista;
	}

	public void removerEmpresa(Integer id) {
		
		Iterator<Empresa> it = lista.iterator();
		
		while ( it.hasNext() ) {
			Empresa empresa = it.next();
			
			if ( empresa.getId() == id ) {
				it.remove();
			}
		}
	}

	public Empresa buscarEmpresaPeloId(Integer id) {
		for ( Empresa empresa : lista ) {
			if ( empresa.getId() == id ) {
				return empresa;
			}
		}
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for ( Usuario user : usuarios ) {
			if ( user.ehIgual(login, senha) ) {
				return user;
			}
		}
		return null;
	}
}
