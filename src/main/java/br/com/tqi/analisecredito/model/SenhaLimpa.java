package br.com.tqi.analisecredito.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotBlank;

public class SenhaLimpa {

    @NotBlank
    private String senha;

    public SenhaLimpa(@NotBlank String senha) {
        this.senha = senha;
    }

    public String hash() {
        return new BCryptPasswordEncoder().encode(senha);
    }
}