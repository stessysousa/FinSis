package model;


public class Lancamento {

	int id;
	String tipo;
	String pagamento;
	String perfil;
	String nome;
	String fixo;
	String descricao;
	double valor;
	String data;
	String status;

	public Lancamento(int id, String tipo, String pagamento, String perfil, String nome,
			String fixo, String descricao, double valor, String data, String status) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.pagamento = pagamento;
		this.perfil = perfil;
		this.nome = nome;
		this.fixo = fixo;
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFixo() {
		return fixo;
	}

	public void setFixo(String fixo) {
		this.fixo = fixo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
