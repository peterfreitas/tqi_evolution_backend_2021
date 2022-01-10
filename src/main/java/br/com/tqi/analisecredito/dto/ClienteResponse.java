package br.com.tqi.analisecredito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private String rg;

    private String endereco;

    private BigDecimal renda;

}
