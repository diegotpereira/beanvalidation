package br.com.java.entity;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private BigInteger idUsuario;

    private String nome;

    private String email;

    private String cpf;

    private Date dtNascimento;
    
}
