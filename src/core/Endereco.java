package core;

import exceptions.ParametroException;

public class Endereco {

	private String rua;
	private String bairro;
	private String complemento;
	private String numero;
	private String cep;
	private String cidade;
	private String estado;
	private String pais;

	public Endereco(String rua, String bairro, String complemento,
			String numero, String cep, String cidade, String estado, String pais) throws ParametroException {
		super();
		setRua(rua);
		setBairro(bairro);
		setNumero(numero);
		setCep(cep);
		setCidade(cidade);
		setEstado(estado);
		setPais(pais);
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) throws ParametroException {
		if (rua == null || rua.isEmpty()) {
			throw new ParametroException("rua");
		} else {
			this.rua = rua;
		}
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) throws ParametroException {
		if (bairro == null || bairro.isEmpty()) {
			throw new ParametroException("bairro");
		} else {
			this.bairro = bairro;
		}
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) throws ParametroException {
		if (numero == null || numero.isEmpty()) {
			throw new ParametroException("numero");
		} else {
			this.numero = numero;
		}
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) throws ParametroException {
		if (cep == null || cep.isEmpty()) {
			throw new ParametroException("cep");
		} else {
			this.cep = cep;
		}
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) throws ParametroException {
		if (cidade == null || cidade.isEmpty()) {
			throw new ParametroException("cidade");
		} else {
			this.cidade = cidade;
		}
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) throws ParametroException {
		if (estado == null || estado.isEmpty()) {
			throw new ParametroException("estado");
		} else {
			this.estado = estado;
		}
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) throws ParametroException {
		if (pais == null || pais.isEmpty()) {
			throw new ParametroException("bairro");
		} else {
			this.pais = pais;
		}
	}

}
