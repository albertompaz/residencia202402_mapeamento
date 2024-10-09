package br.org.serratec.mapeamento.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_produto")
	private Long id;

	@NotBlank(message = "Preencha a descrição")
	@Size(max = 40, min = 2, message = "O tamanho da descrição tem que ser entre {max} e {min} caracteres")
	@Column(name="descricao", nullable = false, length = 40)
	private String descricao;

	@Column
	@DecimalMax(value = "50000", message = "O preço não pode ser maior que R${value}.00")
	@DecimalMin(value = "1", message = "O preço não pode ser menor que R${value}.00")
	private BigDecimal valor;

	@Column(name="data_cadastro")
	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	public Produto() {}
	
	public Produto(Long id, String descricao, BigDecimal valor, Date dataCadastro) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.valor = valor;
		this.dataCadastro = dataCadastro;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}
	
}
