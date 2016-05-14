package br.si.es.sga.dto;


import java.util.Date;



public class AlunoDTO {
	private int idAluno;
	private String nomeAluno;
	private Date dataNasc;
	private Date dataVencimento;
	private Date dataMatricula;
	private String telefoneAluno;
	private ModalidadeDTO idModalidade;
	private EnderecoDTO idEndereco;
	private byte[] foto;
	private String sexo;
	private long cpfAluno;
	
	//private DateFormat dateFormtBD = new SimpleDateFormat("YYYY/MM/DD");
	
	public int getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public Date getDataNasc() {
		
		return dataNasc;
	}
	public void setDataNasc(Date date) {
		this.dataNasc = date;
	}
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public Date getDataMatricula() {
//		 String date = dateFormtBD.format(dataMatricula);
//		try {
//			dataMatricula = dateFormtBD.parse(date);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		 return dataMatricula;
	}
	public void setDataMatricula(Date date) {
		this.dataMatricula = date;
	}
	public String getTelefoneAluno() {
		return telefoneAluno;
	}
	public void setTelefoneAluno(String telefoneAluno) {
		this.telefoneAluno = telefoneAluno;
	}

	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	public ModalidadeDTO getIdModalidade() {
		return idModalidade;
	}
	public void setIdModalidade(ModalidadeDTO idModalidade) {
		this.idModalidade = idModalidade;
	}
	public EnderecoDTO getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(EnderecoDTO idEndereco) {
		this.idEndereco = idEndereco;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public long getCpfAluno() {
		return cpfAluno;
	}
	public void setCpfAluno(long cpfAluno) {
		this.cpfAluno = cpfAluno;
	}
	
}
