package br.maua.forum.config.security;

import br.maua.forum.modelo.Usuario;
import br.maua.forum.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        Optional<Usuario> usuario = repository.findByEmail(user);
        if ( usuario.isPresent() ) {
            return usuario.get();
        }
        throw new UsernameNotFoundException("Dados Inválidos!");
    }
}
