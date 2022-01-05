package br.com.java.entity;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table( name =  "tb_UsuarioEntity")
public class UsuarioEntity {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private BigInteger idUsuario;

	    @NotBlank(message = "O nome não pode ser vazio.")
	    @Size(min = 3,max = 50,message = "O nome precisar ser entre 3 a 50 caracteres")
	    @Column(length = 50)/*Validação lado do Banco*/
	    private String nome;

	    @Email
	    @NotBlank
	    private String email;

	    @CPF
	    @NotBlank
	    private String cpf;

	    @Past
	    @NotNull
	    private Date dtNascimento;

		public UsuarioEntity(BigInteger idUsuario,
				@NotBlank(message = "O nome não pode ser vazio.") @Size(min = 3, max = 50, message = "O nome precisar ser entre 3 a 50 caracteres") String nome,
				@Email @NotBlank String email, @CPF @NotBlank String cpf, @Past @NotNull Date dtNascimento) {
			this.idUsuario = idUsuario;
			this.nome = nome;
			this.email = email;
			this.cpf = cpf;
			this.dtNascimento = dtNascimento;
		}

		public UsuarioEntity() {
		}

		public BigInteger getIdUsuario() {
			return idUsuario;
		}

		public void setIdUsuario(BigInteger idUsuario) {
			this.idUsuario = idUsuario;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public Date getDtNascimento() {
			return dtNascimento;
		}

		public void setDtNascimento(Date dtNascimento) {
			this.dtNascimento = dtNascimento;
		}    
}
