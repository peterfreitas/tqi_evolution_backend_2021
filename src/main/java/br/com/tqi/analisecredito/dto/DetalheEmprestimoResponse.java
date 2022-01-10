package br.com.tqi.analisecredito.dto;

import br.com.tqi.analisecredito.model.Cliente;
import br.com.tqi.analisecredito.model.Emprestimo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetalheEmprestimoResponse {

    private Long id;
    private BigDecimal valor;
    private int qtdParcelas;
    private LocalDate dataPrimeiraParcela;
    private Cliente cliente;

    public static DetalheEmprestimoResponse convert(Emprestimo emprestimo) {
        DetalheEmprestimoResponse detalheEmprestimoResponse = new DetalheEmprestimoResponse();
        detalheEmprestimoResponse.setId(emprestimo.getId());
        detalheEmprestimoResponse.setValor(emprestimo.getValor());
        detalheEmprestimoResponse.setQtdParcelas(emprestimo.getQtdParcelas());
        detalheEmprestimoResponse.setDataPrimeiraParcela(emprestimo.getDataPrimeiraParcela());
        detalheEmprestimoResponse.setCliente(emprestimo.getCliente());
        return detalheEmprestimoResponse;
    }

}