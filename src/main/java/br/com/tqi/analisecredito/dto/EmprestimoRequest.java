package br.com.tqi.analisecredito.dto;

import br.com.tqi.analisecredito.config.anotation.DateMax;
import br.com.tqi.analisecredito.model.Cliente;
import br.com.tqi.analisecredito.model.Emprestimo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoRequest {

    @NotNull
    @Positive
    private BigDecimal valor;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @DateMax
    private LocalDate dataPrimeiraParcela;

    @NotNull
    @Min(value = 1)
    @Max(value = 60)
    private int qtdParcelas;

    private Cliente cliente;

    public static EmprestimoRequest convert(Emprestimo emprestimo) {
        EmprestimoRequest emprestimoRequest = new EmprestimoRequest();
        emprestimoRequest.setValor(emprestimo.getValor());
        emprestimoRequest.setDataPrimeiraParcela(emprestimo.getDataPrimeiraParcela());
        emprestimoRequest.setQtdParcelas(emprestimo.getQtdParcelas());
        emprestimoRequest.setCliente(emprestimo.getCliente());
        return emprestimoRequest;
    }

}