package br.com.tqi.analisecredito.service;

import br.com.tqi.analisecredito.dto.DetalheEmprestimoResponse;
import br.com.tqi.analisecredito.dto.EmprestimoRequest;
import br.com.tqi.analisecredito.dto.EmprestimoResponse;
import br.com.tqi.analisecredito.model.Emprestimo;
import br.com.tqi.analisecredito.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmprestimoService {

    @Autowired
    private EmprestimoRepository emprestimoRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    public EmprestimoRequest save(EmprestimoRequest emprestimoRequest) {
        Emprestimo emprestimo = emprestimoRepository.save(Emprestimo.convert(emprestimoRequest));
        return EmprestimoRequest.convert(emprestimo);
    }

    public List<EmprestimoResponse> buscaEmprestimo() {
        List<Emprestimo> emprestimo = emprestimoRepository.findAll();
        return emprestimo.stream().map(EmprestimoResponse::convert).collect(Collectors.toList());
    }

    public DetalheEmprestimoResponse findById(Long emprestimoId) {
        Optional<Emprestimo> emprestimo = emprestimoRepository.findById(emprestimoId);
        if (emprestimo.isPresent()) {
            return DetalheEmprestimoResponse.convert(emprestimo.get());
        }

        return null;
    }

}
