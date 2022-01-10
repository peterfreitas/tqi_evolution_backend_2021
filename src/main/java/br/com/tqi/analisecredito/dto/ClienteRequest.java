package br.com.tqi.analisecredito.dto;

import br.com.tqi.analisecredito.model.Cliente;
import br.com.tqi.analisecredito.model.SenhaLimpa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @CPF
    private String cpf;

    @NotBlank
    private String rg;

    @NotBlank
    private String endereco;

    @NotNull
    @Positive
    private BigDecimal renda;

    @NotBlank
    private String senha;

    public Cliente toModel() {
        return new Cliente(nome, email, cpf, rg, endereco, renda , new SenhaLimpa(senha));
    }

}