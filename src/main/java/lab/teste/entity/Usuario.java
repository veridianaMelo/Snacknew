package lab.teste.entity;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Usuario
 *
 */
@Entity

public class Usuario implements Serializable {

	   
	@Id
	@GeneratedValue(strategy = SEQUENCE)
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private Integer seat;
	private static final long serialVersionUID = 1L;

	public Usuario() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}   
	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}   
	public Integer getSeat() {
		return this.seat;
	}

	public void setSeat(Integer seat) {
		this.seat = seat;
	}
	public void clear() {
		this.email = null;
		this.senha= null;
	}

}
