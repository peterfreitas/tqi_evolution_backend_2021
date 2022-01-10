package br.com.tqi.analisecredito.controller;

import br.com.tqi.analisecredito.dto.ClienteRequest;
import br.com.tqi.analisecredito.dto.ClienteResponse;
import br.com.tqi.analisecredito.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping("/cliente")
    @Transactional
    public ResponseEntity<ClienteResponse> novoCliente(@RequestBody @Valid ClienteResponse clienteResponse) {
        return ResponseEntity.ok(clienteResponse);
    }

}
