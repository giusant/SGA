package br.si.es.sga.dto;

public class UsuarioDTO {
	private String nomeUsuario;
	private boolean isGerente;
	private String login;
	private String senha;
	private String telefoneUsuario;
	private EnderecoDTO endereco;
	private long cpfUsuario;
	

	public long getCpfUsuario() {
		return cpfUsuario;
	}
	public void setCpfUsuario(long cpfUsuario) {
		this.cpfUsuario = cpfUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public boolean isGerente() {
		return isGerente;
	}
	public void setGerente(boolean isGerente) {
		this.isGerente = isGerente;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTelefoneUsuario() {
		return telefoneUsuario;
	}
	public void setTelefoneUsuario(String telefoneUsuario) {
		this.telefoneUsuario = telefoneUsuario;
	}
	
	public EnderecoDTO getEndereco() {
		return endereco;
	}
	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
}
