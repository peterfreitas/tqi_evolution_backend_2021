package br.com.tqi.analisecredito.service;

import br.com.tqi.analisecredito.dto.ClienteRequest;
import br.com.tqi.analisecredito.dto.ClienteResponse;
import br.com.tqi.analisecredito.model.Cliente;
import br.com.tqi.analisecredito.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public ResponseEntity<ClienteResponse> save(ClienteRequest clienteRequest, ClienteResponse clienteResponse) {
        Cliente cliente = clienteRequest.toModel();
        clienteRepository.save(cliente);
                return ResponseEntity.ok(clienteResponse);

    }

}