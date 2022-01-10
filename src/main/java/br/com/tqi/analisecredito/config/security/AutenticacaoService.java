package br.com.tqi.analisecredito.config.security;

import br.com.tqi.analisecredito.model.Cliente;
import br.com.tqi.analisecredito.repository.ClienteRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    private final ClienteRepository clienteRepository;

    public AutenticacaoService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Cliente> cliente = clienteRepository.findByEmail(s);
        if (cliente.isPresent()) {
            return cliente.get();
        }
        throw new UsernameNotFoundException("Dados digitado inválido!");
    }
}