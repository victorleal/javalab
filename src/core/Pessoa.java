package core;

import exceptions.ParametroException;
import exceptions.Validadores;

public class Pessoa extends PersistentObject {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String celular;
	private Endereco endereco;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ParametroException {
		if (nome == null || nome.isEmpty()) {
			throw new ParametroException("nome");
		} else {
			this.nome = nome;
		}
	}

	public String getCpf() {
		return cpf;
	}

	private void setCpf(String cpf) throws ParametroException {
		if (cpf == null || cpf.isEmpty() || !Validadores.validaCPF(cpf)) {
			throw new ParametroException("cpf");
		} else {
			this.cpf = cpf;
		}
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) throws ParametroException {
		if (endereco == null) {
			throw new ParametroException("endere�o");
		} else {
			this.endereco = endereco;
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws ParametroException {
		if (email == null || email.isEmpty()) {
			throw new ParametroException("e-mail");
		} else {
			this.email = email;
		}
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) throws ParametroException {
		if (telefone == null || telefone.isEmpty()) {
			throw new ParametroException("telefone");
		} else {
			this.telefone = telefone;
		}
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) throws ParametroException {
		if (celular == null || celular.isEmpty()) {
			throw new ParametroException("celular");
		} else {
			this.celular = celular;
		}
	}

	public Pessoa(String nome, String cpf, String email, String telefone,
			String celular, Endereco endereco, String classeFilha) throws ParametroException {
		super(classeFilha, cpf);
		try {
			setNome(nome);
			setCpf(cpf);
			setCelular(celular);
			setTelefone(telefone);
			setEmail(email);
			setEndereco(endereco);
		} catch (ParametroException e) {
			throw e;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

}
