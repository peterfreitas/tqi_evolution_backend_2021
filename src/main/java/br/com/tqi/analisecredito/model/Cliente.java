package br.com.tqi.analisecredito.model;

import br.com.tqi.analisecredito.dto.ClienteRequest;
import br.com.tqi.analisecredito.dto.ClienteResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String cpf;

    private String rg;

    private String endereco;

    private BigDecimal renda;

    private String senha;

    public Cliente(String nome, String email, String cpf, String rg, String endereco, BigDecimal renda, SenhaLimpa senhaLimpa) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.endereco = endereco;
        this.renda = renda;
        this.senha = senhaLimpa.hash();
    }

//    public Cliente(String email, SenhaLimpa senhaLimpa) {
//        this.email = email;
//        this.senha = senhaLimpa.hash();
//    }

    //    public Cliente(Long id, String nome, String email, String cpf, String rg, String endereco, BigDecimal renda, SenhaLimpa senhaLimpa) {
//        this.id = id;
//        this.nome = nome;
//        this.email = email;
//        this.cpf = cpf;
//        this.rg = rg;
//        this.endereco = endereco;
//        this.renda = renda;
//        this.senha = senhaLimpa.hash();
//    }

//    public static Cliente convert(ClienteResponse clienteResponse) {
//        Cliente cliente = new Cliente();
//        cliente.setId(clienteResponse.getId());
//        cliente.setNome(clienteResponse.getNome());
//        cliente.setEmail(clienteResponse.getEmail());
//        cliente.setCpf(clienteResponse.getCpf());
//        cliente.setRg(clienteResponse.getRg());
//        cliente.setEndereco(clienteResponse.getEndereco());
//        cliente.setRenda(clienteResponse.getRenda());
//        return cliente;
//    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
