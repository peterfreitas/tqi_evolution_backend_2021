package br.com.tqi.analisecredito.model;

import br.com.tqi.analisecredito.dto.EmprestimoRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    private LocalDate dataPrimeiraParcela;

    private int qtdParcelas;

    @ManyToOne
    @JoinColumn(name = "idCliente", foreignKey = @ForeignKey(name = "emprestimo_cliente"))
    private Cliente Cliente;

    public static Emprestimo convert(EmprestimoRequest emprestimoRequest) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setValor(emprestimoRequest.getValor());
        emprestimo.setDataPrimeiraParcela(emprestimoRequest.getDataPrimeiraParcela());
        emprestimo.setQtdParcelas(emprestimoRequest.getQtdParcelas());
        emprestimo.setCliente(emprestimoRequest.getCliente());
        return emprestimo;
    }

}
