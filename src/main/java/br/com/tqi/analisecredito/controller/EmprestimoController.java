package br.com.tqi.analisecredito.controller;

import br.com.tqi.analisecredito.dto.DetalheEmprestimoResponse;
import br.com.tqi.analisecredito.dto.EmprestimoRequest;
import br.com.tqi.analisecredito.dto.EmprestimoResponse;
import br.com.tqi.analisecredito.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/emprestimo")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping
    @Transactional
    EmprestimoRequest novoEmprestimo(@RequestBody @Valid EmprestimoRequest emprestimoRequest) {
        return emprestimoService.save(emprestimoRequest);
    }

    @GetMapping
    public List<EmprestimoResponse> buscaEmprestimo() {
        List<EmprestimoResponse> emprestimo = emprestimoService.buscaEmprestimo();
        return emprestimo;
    }

    @GetMapping("/{emprestimoId}")
    public ResponseEntity<DetalheEmprestimoResponse> buscaPorId(@PathVariable Long emprestimoId) {
        DetalheEmprestimoResponse detalheEmprestimoResponse = emprestimoService.findById(emprestimoId);
        return ResponseEntity.ok().body(detalheEmprestimoResponse);

    }

}