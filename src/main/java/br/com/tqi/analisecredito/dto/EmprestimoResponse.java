package br.com.tqi.analisecredito.dto;

import br.com.tqi.analisecredito.model.Emprestimo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoResponse {

    private Long id;
    private BigDecimal valor;
    private Integer qtdParcelas;

    public static EmprestimoResponse convert(Emprestimo emprestimo) {
        EmprestimoResponse emprestimoResponse = new EmprestimoResponse();
        emprestimoResponse.setId(emprestimo.getId());
        emprestimoResponse.setValor(emprestimo.getValor());
        emprestimoResponse.setQtdParcelas(emprestimo.getQtdParcelas());
        return emprestimoResponse;
    }

}
